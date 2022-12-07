package antifraud.controller;

import antifraud.dto.request.WithdrawRequest;
import antifraud.dto.response.ResultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static antifraud.dto.response.ResultResponse.Result.*;

@RestController
@RequestMapping("/api/antifraud")
public class TransactionController {

    @PostMapping("/transaction")
    public ResponseEntity<ResultResponse> transaction(@RequestBody @Valid WithdrawRequest withdrawRequest) {
        ResultResponse.Result result = null;

        if (withdrawRequest.getAmount() <= 200) {
            result = ALLOWED;
        } else if (withdrawRequest.getAmount() <= 1500) {
            result = MANUAL_PROCESSING;
        } else {
            result = PROHIBITED;
        }

        return ResponseEntity.ok(new ResultResponse(result));
    }
}
