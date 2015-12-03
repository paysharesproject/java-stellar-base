package org.stellar.base;

import org.stellar.base.xdr.AccountID;
import org.stellar.base.xdr.CreateAccountOp;
import org.stellar.base.xdr.Int64;
import org.stellar.base.xdr.OperationType;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents <a href="https://www.stellar.org/developers/learn/concepts/list-of-operations.html#create-account" target="_blank">CreateAccount</a> operation.
 * @see <a href="https://www.stellar.org/developers/learn/concepts/list-of-operations.html" target="_blank">List of Operations</a>
 */
public class CreateAccountOperation extends Operation {

  private final Keypair destination;
  private final String startingBalance;

  private CreateAccountOperation(Keypair destination, String startingBalance) {
    this.destination = checkNotNull(destination, "destination cannot be null");
    this.startingBalance = checkNotNull(startingBalance, "startingBalance cannot be null");
  }

  /**
   * Amount of XLM to send to the newly created account.
   */
  public String getStartingBalance() {
    return startingBalance;
  }

  /**
   * Account that is created and funded
   */
  public Keypair getDestination() {
    return destination;
  }

  @Override
  org.stellar.base.xdr.Operation.OperationBody toOperationBody() {
    CreateAccountOp op = new CreateAccountOp();
    AccountID destination = new AccountID();
    destination.setAccountID(this.destination.getXdrPublicKey());
    op.setDestination(destination);
    Int64 startingBalance = new Int64();
    startingBalance.setInt64(Operation.toXdrAmount(this.startingBalance));
    op.setStartingBalance(startingBalance);

    org.stellar.base.xdr.Operation.OperationBody body = new org.stellar.base.xdr.Operation.OperationBody();
    body.setDiscriminant(OperationType.CREATE_ACCOUNT);
    body.setCreateAccountOp(op);
    return body;
  }

  /**
   * Builds CreateAccount operation.
   * @see CreateAccountOperation
   */
  public static class Builder {
    private final Keypair destination;
    private final String startingBalance;

    private Keypair mSourceAccount;

    /**
     * Construct a new CreateAccount builder from a CreateAccountOp XDR.
     * @param op {@link CreateAccountOp}
     */
    Builder(CreateAccountOp op) {
      destination = Keypair.fromXdrPublicKey(op.getDestination().getAccountID());
      startingBalance = Operation.fromXdrAmount(op.getStartingBalance().getInt64().longValue());
    }

    /**
     * Creates a new CreateAccount builder.
     * @param destination The destination keypair (uses only the public key).
     * @param startingBalance The initial balance to start with in lumens.
     * @throws ArithmeticException when startingBalance has more than 7 decimal places.
     */
    public Builder(Keypair destination, String startingBalance) {
      this.destination = destination;
      this.startingBalance = startingBalance;
    }

    /**
     * Sets the source account for this operation.
     * @param account The operation's source account.
     * @return Builder object so you can chain methods.
     */
    public Builder setSourceAccount(Keypair account) {
      mSourceAccount = account;
      return this;
    }

    /**
     * Builds an operation
     */
    public CreateAccountOperation build() {
      CreateAccountOperation operation = new CreateAccountOperation(destination, startingBalance);
      if (mSourceAccount != null) {
        operation.setSourceAccount(mSourceAccount);
      }
      return operation;
    }
  }
}
