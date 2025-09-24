package states;

import enums.ATMState;
import factories.CardManagerFactory;
import models.ATM;
import models.Card;
import services.CardManagerServices;
import services.DebitCardManagerService;

public class ReadingCashWithdrawalState implements State{

    private final ATM atm;

    public  ReadingCashWithdrawalState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot init transaction");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card");
    }

    @Override
    public int dispenseCash(Card card,int amount,int transactionId) {
        throw new IllegalStateException("Cannot dispense cash");
    }

    @Override
    public boolean readCardAndPin(Card card, String pin) {
        throw new IllegalStateException("Cannot read card and pin");
    }

    @Override
    public boolean withdrawCash(Card card,int transactionId, int amount) {
        CardManagerServices manager = CardManagerFactory.getCardManagerServices(card.getCardType());
        boolean isValid = manager.validateWithdrawal(card,transactionId,amount);
        if(isValid){
            this.atm.setAtmState(new DispensingCashState(this.atm));
        } else{
            this.atm.setAtmState(new EjectingCardState(this.atm));
        }
        return isValid;
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
        return ATMState.READING_CASH_WITHDRAW_DETAILS;
    }
}
