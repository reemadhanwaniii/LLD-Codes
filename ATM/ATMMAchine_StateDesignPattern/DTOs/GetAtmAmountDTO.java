package DTOs;

public class GetAtmAmountDTO {
    private final String atmId;

    public GetAtmAmountDTO(String atmId) {
        this.atmId = atmId;
    }

    public String getAtmId() {
        return atmId;
    }
}
