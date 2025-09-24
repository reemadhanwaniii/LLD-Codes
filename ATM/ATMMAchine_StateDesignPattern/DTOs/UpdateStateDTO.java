package DTOs;

import enums.ATMState;

public class UpdateStateDTO {
    private final String atmId;
    private final ATMState state;
    public UpdateStateDTO(String atmId, ATMState state) {
        this.atmId = atmId;
        this.state = state;
    }
    public String getAtmId() {
        return atmId;
    }
    public ATMState getState() {
        return state;
    }
}
