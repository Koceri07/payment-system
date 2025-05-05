package springboot.paymentsystem.paymentsystem.controller;

import springboot.paymentsystem.paymentsystem.model.request.CreateTransferRequest;
import springboot.paymentsystem.paymentsystem.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/transfers")
@RequiredArgsConstructor
public class TransferController {
    private final TransferService transferService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void doTransfer(@RequestBody CreateTransferRequest createTransferRequest) {
        transferService.doTransfer(createTransferRequest);
    }
}
