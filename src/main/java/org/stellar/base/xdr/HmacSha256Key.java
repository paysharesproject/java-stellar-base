// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  struct HmacSha256Key
//  {
//          opaque key[32];
//  };

//  ===========================================================================
public class HmacSha256Key  {
  public HmacSha256Key () {}
  private byte[] key;
  public byte[] getKey() {
    return this.key;
  }
  public void setKey(byte[] value) {
    this.key = value;
  }
  public static void encode(XdrDataOutputStream stream, HmacSha256Key encodedHmacSha256Key) throws IOException{
    int keysize = encodedHmacSha256Key.key.length;
    stream.write(encodedHmacSha256Key.getKey(), 0, keysize);
  }
  public static HmacSha256Key decode(XdrDataInputStream stream) throws IOException {
    HmacSha256Key decodedHmacSha256Key = new HmacSha256Key();
    int keysize = 32;
    decodedHmacSha256Key.key = new byte[keysize];
    stream.read(decodedHmacSha256Key.key, 0, keysize);
    return decodedHmacSha256Key;
  }
}
