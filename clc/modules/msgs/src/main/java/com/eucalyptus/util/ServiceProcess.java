package com.eucalyptus.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.log4j.Logger;
import com.eucalyptus.system.Threads;
import com.google.common.collect.Lists;

public class ServiceProcess implements Runnable {
  private static Logger LOG = Logger.getLogger( ServiceProcess.class );
  private Threads.ThreadPool threads;
  private Process     self;
  private File        pwd;
  private Integer     returnCode;
  private String[]    args;
  private String[]    envp;
  private String      name;
  private PrintStream out, err;
  private List        listeners = Lists.newArrayList( );
  
  public static ServiceProcess exec( String name, File pwd, String[] args, String[] envp ) {
    return new ServiceProcess( name, pwd, args, envp ).exec();
  }
  private ServiceProcess( String name, File pwd, String[] args, String[] envp ) {
    super( );
    this.threads = Threads.lookup( name );
    this.pwd = pwd;
    this.returnCode = null;
    this.args = args;
    this.envp = envp;
    this.name = name;
    this.out = System.out;
    this.err = System.err;
  }
  
  public void kill( ) {
    if( this.self != null ) {
      this.self.destroy( );
    }
  }
  
  public ServiceProcess exec() {
    this.threads.getPool( ).submit( this );
    return this;
  }

  public void run( ) {
    if ( this.self != null ) {
      throw new RuntimeException( "Process already running." );
    }
    this.returnCode = null;
    try {
      this.self = Runtime.getRuntime( ).exec( this.args, this.envp, this.pwd );
      this.threads.getPool( ).submit( new IOMonitor( this.self.getInputStream( ) ) );
      this.threads.getPool( ).submit( new IOMonitor( this.self.getErrorStream( ) ) );
      try {
        this.returnCode = this.self.waitFor( );
      } catch ( InterruptedException e ) {
        LOG.debug( e, e );
      }
    } catch ( Exception e ) {
      LOG.error( e, e );
      this.threads.getPool( ).submit( this );
    }    
  }
  
  private static class IOMonitor implements Runnable {
    private static Logger LOG = Logger.getLogger( ServiceProcess.IOMonitor.class );
    private AtomicBoolean finished = new AtomicBoolean( false );
    private BufferedReader   in;
    
    public IOMonitor( InputStream in ) {
      this.in = new BufferedReader( new InputStreamReader( in ) );
    }
    
    public boolean isFinished() {
      return this.finished.get( );
    }
    
    @Override
    public void run( ) {
      byte[] buf = new byte[1024];
      while ( !this.finished.get( ) ) {
        try {
          if( !in.ready( ) ) {
            TimeUnit.MILLISECONDS.sleep( 100 );
          }
          String line = "";
          if( ( line = in.readLine( ) ) == null ) {
            LOG.info( "I/O Stream closed for: " + in.toString( ) );
            this.finished.set( true );
            return;
          }
          LOG.info( line );
        } catch ( Exception e ) {
          LOG.debug( e, e );
          this.finished.set( true );
        }
      }
    }
    
  }
  
}
