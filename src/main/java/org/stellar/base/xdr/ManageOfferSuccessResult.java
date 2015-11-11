// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  struct ManageOfferSuccessResult
//  {
//      // offers that got claimed while creating this offer
//      ClaimOfferAtom offersClaimed<>;
//  
//      union switch (ManageOfferEffect effect)
//      {
//      case MANAGE_OFFER_CREATED:
//      case MANAGE_OFFER_UPDATED:
//          OfferEntry offer;
//      default:
//          void;
//      }
//      offer;
//  };

//  ===========================================================================
public class ManageOfferSuccessResult  {
  public ManageOfferSuccessResult () {}
  private ClaimOfferAtom[] offersClaimed;
  public ClaimOfferAtom[] getOffersClaimed() {
    return this.offersClaimed;
  }
  public void setOffersClaimed(ClaimOfferAtom[] value) {
    this.offersClaimed = value;
  }
  private ManageOfferSuccessResultOffer offer;
  public ManageOfferSuccessResultOffer getOffer() {
    return this.offer;
  }
  public void setOffer(ManageOfferSuccessResultOffer value) {
    this.offer = value;
  }
  public static void encode(XdrDataOutputStream stream, ManageOfferSuccessResult encodedManageOfferSuccessResult) throws IOException{
    int offersClaimedsize = encodedManageOfferSuccessResult.getOffersClaimed().length;
    stream.writeInt(offersClaimedsize);
    for (int i = 0; i < offersClaimedsize; i++) {
      ClaimOfferAtom.encode(stream, encodedManageOfferSuccessResult.offersClaimed[i]);
    }
    ManageOfferSuccessResultOffer.encode(stream, encodedManageOfferSuccessResult.offer);
  }
  public static ManageOfferSuccessResult decode(XdrDataInputStream stream) throws IOException {
    ManageOfferSuccessResult decodedManageOfferSuccessResult = new ManageOfferSuccessResult();
    int offersClaimedsize = stream.readInt();
    decodedManageOfferSuccessResult.offersClaimed = new ClaimOfferAtom[offersClaimedsize];
    for (int i = 0; i < offersClaimedsize; i++) {
      decodedManageOfferSuccessResult.offersClaimed[i] = ClaimOfferAtom.decode(stream);
    }
    decodedManageOfferSuccessResult.offer = ManageOfferSuccessResultOffer.decode(stream);
    return decodedManageOfferSuccessResult;
  }

  public static class ManageOfferSuccessResultOffer {
    public ManageOfferSuccessResultOffer () {}
    ManageOfferEffect effect;
    public ManageOfferEffect getDiscriminant() {
      return this.effect;
    }
    public void setDiscriminant(ManageOfferEffect value) {
      this.effect = value;
    }
    private OfferEntry offer;
    public OfferEntry getOffer() {
      return this.offer;
    }
    public void setOffer(OfferEntry value) {
      this.offer = value;
    }
    public static void encode(XdrDataOutputStream stream, ManageOfferSuccessResultOffer encodedManageOfferSuccessResultOffer) throws IOException {
    stream.writeInt(encodedManageOfferSuccessResultOffer.getDiscriminant().getValue());
    switch (encodedManageOfferSuccessResultOffer.getDiscriminant()) {
    case MANAGE_OFFER_CREATED:
    case MANAGE_OFFER_UPDATED:
    OfferEntry.encode(stream, encodedManageOfferSuccessResultOffer.offer);
    break;
    default:
    break;
    }
    }
    public static ManageOfferSuccessResultOffer decode(XdrDataInputStream stream) throws IOException {
      ManageOfferSuccessResultOffer decodedManageOfferSuccessResultOffer = new ManageOfferSuccessResultOffer();
      switch (decodedManageOfferSuccessResultOffer.getDiscriminant()) {
    case MANAGE_OFFER_CREATED:
    case MANAGE_OFFER_UPDATED:
    decodedManageOfferSuccessResultOffer.offer = OfferEntry.decode(stream);
    break;
    default:
    break;
    }
      return decodedManageOfferSuccessResultOffer;
    }

  }
}
