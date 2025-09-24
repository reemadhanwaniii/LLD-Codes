package factories;

import enums.CardType;
import services.CardManagerServices;
import services.CreditCardManagerService;
import services.DebitCardManagerService;

public class CardManagerFactory {
    public static CardManagerServices getCardManagerServices(CardType cardType) {
        CardManagerServices cardManagerServices = null;
        switch (cardType) {
            case DEBIT:
                cardManagerServices = new DebitCardManagerService();
                break;
            case CREDIT:
                cardManagerServices = new CreditCardManagerService();
                break;
            default:
                throw new IllegalArgumentException("Invalid card type");
        }
        return cardManagerServices;
    }
}
