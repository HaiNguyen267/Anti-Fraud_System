package antifraud.dto.response;


public class ResultResponse {

    public enum Result{
        ALLOWED, MANUAL_PROCESSING, PROHIBITED
    }

    private Result result;

    public ResultResponse(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
