package com.eucalyptus.webui.client.place;

import com.eucalyptus.webui.client.service.CategoryConstants;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ConfigPlace extends SearchPlace {
  
  public ConfigPlace( String search ) {
    super( search );
  }

  @Prefix( CategoryConstants.CONFIGURATION )
  public static class Tokenizer implements PlaceTokenizer<ConfigPlace> {

    @Override
    public ConfigPlace getPlace( String token ) {
      return new ConfigPlace( decode( token ) );
    }

    @Override
    public String getToken( ConfigPlace place ) {
      return encode( place.getSearch( ) ); 
    }
    
  }
  
}
