package states;

import enums.ATMState;
import factories.CardManagerFactory;
import models.ATM;
import models.Card;
import services.CardManagerServices;
import services.CashDispenseServiceImpl;
import services.CashDispenserService;

public class DispensingCashState implements State{
    private final ATM atm;
    private final CashDispenserService dispenser;

    public DispensingCashState(ATM atm) {
        this.atm = atm;
        this.dispenser = new CashDispenseServiceImpl();
    }
    @Override
    public int initTransaction() {
        throw new IllegalStateException("Can't init transaction");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card");
    }

    @Override
    public int dispenseCash(Card card,int amount,int transactionId) {
        CardManagerServices manager = CardManagerFactory.getCardManagerServices(card.getCardType());
        boolean isTxnSuccessful = manager.doTransaction(card,amount,transactionId);
        if(isTxnSuccessful){
            dispenser.dispenseCash(atm,amount);
            this.atm.setAtmState(new EjectingCardState(this.atm));
        }else {
            this.atm.setAtmState(new EjectingCardState(this.atm));
        }
        return amount;
    }

    @Override
    public boolean readCardAndPin(Card card, String pin) {
        throw new IllegalStateException("Cannot read card and pin");
    }

    @Override
    public boolean withdrawCash(Card card, int transactionId, int amount) {
        throw new IllegalStateException("Cannot withdraw cash");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Cannot cancel transaction while Dispensing Cash");
    }

    @Override
    public ATMState getATMState() {
        return ATMState.DISPENSING_CASH;
    }
}
