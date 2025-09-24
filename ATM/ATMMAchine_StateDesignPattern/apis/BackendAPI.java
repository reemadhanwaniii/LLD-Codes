package apis;

import DTOs.CreateTransactionDTO;
import DTOs.UpdateStateDTO;

public interface BackendAPI {
    int createTransaction(CreateTransactionDTO atmId);

    boolean updateState(UpdateStateDTO updateStateDTO);
}
