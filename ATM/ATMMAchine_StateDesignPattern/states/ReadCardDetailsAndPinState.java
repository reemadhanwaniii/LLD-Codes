package states;

import enums.ATMState;
import factories.CardManagerFactory;
import models.ATM;
import models.Card;
import services.CardManagerServices;

public class ReadCardDetailsAndPinState implements State{
    private final ATM atm;

    public ReadCardDetailsAndPinState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot init transaction while Reading card Details");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot Eject card While Reading card Details");
    }

    @Override
    public int dispenseCash(Card card,int amount,int transactionId) {
        throw new IllegalStateException("Cannot dispense cash while Reading card Details");
    }

    @Override
    public boolean readCardAndPin(Card card,String pin) {
        CardManagerServices manager = CardManagerFactory.getCardManagerServices(card.getCardType());
        boolean isCardValid = manager.validateCard(card,pin);
        if(isCardValid) {
            this.atm.setAtmState(new ReadingCashWithdrawalState(this.atm));
        } else{
            this.atm.setAtmState(new EjectingCardState(this.atm));
        }
        return isCardValid;
    }

    @Override
    public boolean withdrawCash(Card card,int transactionId, int amount) {
        throw new IllegalStateException("Cannot withdraw cash while Reading card Details");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        try{
            this.atm.setAtmState(new ReadyForTransactionState(this.atm));
        }catch (Exception e){
            throw new UnsupportedOperationException("Cannot cancel transaction");
        }

        return true;
    }

    @Override
    public ATMState getATMState() {
        return ATMState.READ_CARD_AND_PIN;
    }
}
