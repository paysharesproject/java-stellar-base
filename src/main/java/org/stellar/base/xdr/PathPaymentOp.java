// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  struct PathPaymentOp
//  {
//      Asset sendAsset; // asset we pay with
//      int64 sendMax;   // the maximum amount of sendAsset to
//                       // send (excluding fees).
//                       // The operation will fail if can't be met
//  
//      AccountID destination; // recipient of the payment
//      Asset destAsset;       // what they end up with
//      int64 destAmount;      // amount they end up with
//  
//      Asset path<5>; // additional hops it must go through to get there
//  };

//  ===========================================================================
public class PathPaymentOp  {
  public PathPaymentOp () {}
  private Asset sendAsset;
  public Asset getSendAsset() {
    return this.sendAsset;
  }
  public void setSendAsset(Asset value) {
    this.sendAsset = value;
  }
  private Int64 sendMax;
  public Int64 getSendMax() {
    return this.sendMax;
  }
  public void setSendMax(Int64 value) {
    this.sendMax = value;
  }
  private AccountID destination;
  public AccountID getDestination() {
    return this.destination;
  }
  public void setDestination(AccountID value) {
    this.destination = value;
  }
  private Asset destAsset;
  public Asset getDestAsset() {
    return this.destAsset;
  }
  public void setDestAsset(Asset value) {
    this.destAsset = value;
  }
  private Int64 destAmount;
  public Int64 getDestAmount() {
    return this.destAmount;
  }
  public void setDestAmount(Int64 value) {
    this.destAmount = value;
  }
  private Asset[] path;
  public Asset[] getPath() {
    return this.path;
  }
  public void setPath(Asset[] value) {
    this.path = value;
  }
  public static void encode(XdrDataOutputStream stream, PathPaymentOp encodedPathPaymentOp) throws IOException{
    Asset.encode(stream, encodedPathPaymentOp.sendAsset);
    Int64.encode(stream, encodedPathPaymentOp.sendMax);
    AccountID.encode(stream, encodedPathPaymentOp.destination);
    Asset.encode(stream, encodedPathPaymentOp.destAsset);
    Int64.encode(stream, encodedPathPaymentOp.destAmount);
    int pathsize = encodedPathPaymentOp.getPath().length;
    stream.writeInt(pathsize);
    for (int i = 0; i < pathsize; i++) {
      Asset.encode(stream, encodedPathPaymentOp.path[i]);
    }
  }
  public static PathPaymentOp decode(XdrDataInputStream stream) throws IOException {
    PathPaymentOp decodedPathPaymentOp = new PathPaymentOp();
    decodedPathPaymentOp.sendAsset = Asset.decode(stream);
    decodedPathPaymentOp.sendMax = Int64.decode(stream);
    decodedPathPaymentOp.destination = AccountID.decode(stream);
    decodedPathPaymentOp.destAsset = Asset.decode(stream);
    decodedPathPaymentOp.destAmount = Int64.decode(stream);
    int pathsize = stream.readInt();
    decodedPathPaymentOp.path = new Asset[pathsize];
    for (int i = 0; i < pathsize; i++) {
      decodedPathPaymentOp.path[i] = Asset.decode(stream);
    }
    return decodedPathPaymentOp;
  }
}
