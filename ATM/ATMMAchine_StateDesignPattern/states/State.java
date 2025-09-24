package states;

import enums.ATMState;
import models.Card;

public interface State {
    int initTransaction();

    void ejectCard();

    int dispenseCash(int transactionId);

    boolean readCardAndPin(Card card);

    boolean withdrawCash(int transactionId,int amount);

    ATMState getATMState();

}
