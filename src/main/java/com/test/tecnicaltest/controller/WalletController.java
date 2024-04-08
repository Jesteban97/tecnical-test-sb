package com.test.tecnicaltest.controller;
import com.test.tecnicaltest.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/wallet/")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @CrossOrigin(origins = "*")
    @PostMapping("/recharge")
    public ResponseEntity<String> rechargeWallet(@RequestBody Map<String, Object> requestData) {
        String document = (String) requestData.get("document");
        String cell = (String) requestData.get("cell");
        String amount = (String) requestData.get("amount");
        double amountP = Double.parseDouble(amount);
        String response = walletService.rechargeWallet(document, cell, amountP);
        return ResponseEntity.ok(response);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/balance")
    public ResponseEntity<String> getWalletBalance(@RequestParam String document,
                                                   @RequestParam String cell) {
        String response = walletService.getWalletBalance(document, cell);
        return ResponseEntity.ok(response);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/purchase")
    public ResponseEntity<String> confirmPurchase(@RequestBody Map<String, Object> requestData) {
        String document = (String) requestData.get("document");
        String cell = (String) requestData.get("cell");
        String confirmationCode = (String) requestData.get("confirmationCode");
        double amount = (double) requestData.get("amount");
        String response = walletService.confirmPurchase(document,cell, confirmationCode, amount);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
