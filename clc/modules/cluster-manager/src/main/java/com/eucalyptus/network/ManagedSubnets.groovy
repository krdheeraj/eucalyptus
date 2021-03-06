/*************************************************************************
 * Copyright 2009-2015 Ent. Services Development Corporation LP
 *
 * Redistribution and use of this software in source and binary forms,
 * with or without modification, are permitted provided that the
 * following conditions are met:
 *
 *   Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 *   Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer
 *   in the documentation and/or other materials provided with the
 *   distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ************************************************************************/
package com.eucalyptus.network

import com.eucalyptus.network.config.ManagedSubnet
import com.eucalyptus.network.config.NetworkConfiguration
import com.eucalyptus.util.Pair
import com.google.common.base.Function
import com.google.common.primitives.UnsignedInteger
import groovy.transform.PackageScope

import javax.annotation.Nonnull

/**
 *
 */
class ManagedSubnets {

  static boolean validSegmentForSubnet(
      @Nonnull final ManagedSubnet managedSubnet,
      @Nonnull final Integer segmentId
  ) {
    segmentId == restrictToMaximumSegment( managedSubnet, segmentId )
  }

  static Integer restrictToMaximumSegment(
      @Nonnull final ManagedSubnet managedSubnet,
      @Nonnull final Integer segmentId
  ) {
    restrictToMaximumSegment(
        managedSubnet.subnet,
        managedSubnet.netmask,
        segmentSize( managedSubnet ).intValue( ),
        segmentId )
  }

  static Integer restrictToMaximumSegment(
      @Nonnull final String subnet,
      @Nonnull final String netmask,
      @Nonnull final Integer segmentSize,
      @Nonnull final Integer segmentId
  ) {
    Math.min(
        (int) segmentId,
        (int) ( IPRange.fromSubnet( subnet, netmask ).size( ) + 2 ) / segmentSize )
  }

  /**
   * Retrieves a private IP address from a given network segment index and an IP
   * address index from within the segment.
   *
   * @param segmentId the network segment index to select
   * @param ipIndex the IP address index from within the network segment
   *
   * @return the matching IP address in a String format
   */
  @PackageScope
  @Nonnull
  static String indexToAddress(
      @Nonnull final ManagedSubnet managedSubnet,
      @Nonnull final Integer segmentId,
      @Nonnull final Long ipIndex
  ) {
    final UnsignedInteger subnetInt = subnet( managedSubnet )
    final UnsignedInteger segmentSizeInt = segmentSize( managedSubnet )

    final UnsignedInteger privateIp = subnetInt
        .plus( segmentSizeInt.times( unsigned( segmentId ).minus( unsigned( ManagedSubnet.MIN_VLAN ) ) ) )
        .plus( unsigned( ipIndex.intValue( ) ) )

    PrivateAddresses.fromInteger( privateIp )
  }

  @PackageScope
  static Pair<Integer,Long> addressToIndex(
      @Nonnull final ManagedSubnet managedSubnet,
      @Nonnull final String address
  ) {
    final UnsignedInteger subnetInt = subnet( managedSubnet )
    final UnsignedInteger segmentSizeInt = segmentSize( managedSubnet )

    final UnsignedInteger rebasedAddressInt = unsigned( PrivateAddresses.asInteger( address ) ).minus( subnetInt )

    Pair.pair(
      rebasedAddressInt.dividedBy( segmentSizeInt ).plus( unsigned( ManagedSubnet.MIN_VLAN ) ).intValue( ),
      rebasedAddressInt.mod( segmentSizeInt ).longValue( )
    )
  }

  @PackageScope
  static Function<String,Pair<Integer,Long>> addressToIndex(
      @Nonnull final ManagedSubnet managedSubnet
  ) {
    { String address -> addressToIndex( managedSubnet, address ) } as Function<String,Pair<Integer,Long>>
  }

  @PackageScope
  static Function<NetworkConfiguration,ManagedSubnet> managedSubnet( ) {
    {  NetworkConfiguration networkConfiguration -> networkConfiguration?.managedSubnet } as Function<NetworkConfiguration,ManagedSubnet>
  }

  private static UnsignedInteger subnet( final ManagedSubnet managedSubnet ) {
    unsigned( PrivateAddresses.asInteger( managedSubnet.subnet ) )
  }

  private static UnsignedInteger segmentSize( final ManagedSubnet managedSubnet ) {
    unsigned( managedSubnet.segmentSize ?: ManagedSubnet.DEF_SEGMENT_SIZE )
  }

  private static UnsignedInteger unsigned( int value ) {
    UnsignedInteger.fromIntBits( value )
  }
}
