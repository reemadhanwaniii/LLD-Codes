package states;

import enums.ATMState;
import models.ATM;
import models.Card;

public class EjectingCardState implements State {
    private final ATM atm;
    public EjectingCardState(ATM atm) {
        this.atm = atm;
    }
    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot init transaction");
    }

    @Override
    public void ejectCard() {
        System.out.println("Ejecting Card");
    }

    @Override
    public int dispenseCash(Card card, int amount, int transactionId) {
        throw new IllegalStateException("Cannot dispense cash");
    }

    @Override
    public boolean readCardAndPin(Card card, String pin) {
        throw new IllegalStateException("Cannot read card");
    }

    @Override
    public boolean withdrawCash(Card card, int transactionId, int amount) {
        throw new  IllegalStateException("Cannot withdraw cash");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new  IllegalStateException("Cannot cancel transaction");
    }

    @Override
    public ATMState getATMState() {
        return ATMState.EJECTING_CARD;
    }
}
