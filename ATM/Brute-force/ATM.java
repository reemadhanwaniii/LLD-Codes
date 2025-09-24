class ATM {

    public int startTransaction() {
        int transactionId = generateTransactionId();
        System.out.println("Start transaction with Transaction ID: " + transactionId);
        return transactionId;
    }

    public boolean cancelTransaction(int transactionId) {
        System.out.println("Cancel transaction with Transaction ID: " + transactionId);
        return true;
    }
    public boolean readCard(String cardType,double cardNumber,int pin) {
        System.out.println("Reading card with Card Type: " + cardType + " CardNumber : " + cardNumber);
        boolean isValid = validateCardDetails(cardType,cardNumber);
        if(isValid) {
            System.out.println("Card Details Valid");
        }else{
            System.out.println("Card Details Invalid");
        }
        return isValid;
    }

    public boolean withdrawAmount(int transactionId, double amount) {
        System.out.println("Withdrawing amount from transaction with Transaction ID: " + transactionId);
        boolean canWithdraw = checkWithdrawLimit(amount);
        if(canWithdraw) {
            System.out.println("Withdrawing amount Successful");
        }else{
            System.out.println("Withdrawing amount Failed");
        }
        return canWithdraw;
    }

    public void dispenseCash(double amount) {
        System.out.println("Dispensing cash of: " + amount);
        deductCashFromAtm(amount);
    }


    public void ejectCard() {
        System.out.println("Ejecting Card Successful");
    }
    private boolean validateCardDetails(String cardType,double cardNumber) {
        return true;
    }
    private int generateTransactionId() {
        return (int)(Math.random()*100000);
    }

    private  boolean checkWithdrawLimit(double amount) {
        return amount <= 10000;
    }

    private void deductCashFromAtm(double amount) {
        System.out.println("Deducting cash of: " + amount);
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        int transactionId = atm.startTransaction();
        boolean valid = atm.readCard("VISA",12345606,5253);
        if(valid) {
            boolean canWithdraw = atm.withdrawAmount(transactionId, 5000);
            if(canWithdraw) {
                atm.dispenseCash(5000);
            }else {
                atm.cancelTransaction(transactionId);
            }
        }else{
            atm.ejectCard();
        }
    }
}