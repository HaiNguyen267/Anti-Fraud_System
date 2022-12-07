package antifraud.dto.request;


import javax.validation.constraints.Min;

public class WithdrawRequest {
    @Min(value = 1, message = "value must be greater than 0")
    private long amount;

    public WithdrawRequest(int amount) {
        this.amount = amount;
    }

    public WithdrawRequest() {
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
