package presentation;

import application.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    ResponseEntity AddTransaction(@RequestBody TransactionInput t) {
        if ((System.currentTimeMillis() - t.timestamp) > (60 * 1000)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        this.transactionService.SaveTransaction(t);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}