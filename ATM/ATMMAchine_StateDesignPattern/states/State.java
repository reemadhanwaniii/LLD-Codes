package states;

import enums.ATMState;
import models.Card;

public interface State {
    int initTransaction();

    void ejectCard();

    int dispenseCash(Card card,int amount,int transactionId);

    boolean readCardAndPin(Card card,String pin);

    boolean withdrawCash(Card card,int transactionId,int amount);

    boolean cancelTransaction(int transactionId);

    ATMState getATMState();

}
