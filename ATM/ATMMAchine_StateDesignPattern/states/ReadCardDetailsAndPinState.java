package states;

import enums.ATMState;
import models.Card;

public class ReadCardDetailsAndPinState implements State{

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot init transaction while Reading card Details");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot Eject card While Reading card Details");
    }

    @Override
    public int dispenseCash(int transactionId) {
        throw new IllegalStateException("Cannot dispense cash while Reading card Details");
    }

    @Override
    public boolean readCardAndPin(Card card) {
        return false;
    }

    @Override
    public boolean withdrawCash(int transactionId, int amount) {
        throw new IllegalStateException("Cannot withdraw cash while Reading card Details");
    }

    @Override
    public ATMState getATMState() {
        return ATMState.READ_CARD_AND_PIN;
    }
}
