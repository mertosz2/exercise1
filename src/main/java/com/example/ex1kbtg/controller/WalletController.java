package com.example.ex1kbtg.controller;

import com.example.ex1kbtg.dto.WalletRequest;
import com.example.ex1kbtg.model.Wallet;
import com.example.ex1kbtg.service.WalletService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletController {
    private final WalletService walletService =new WalletService();

    @GetMapping("/api/wallets")
    public List<Wallet> listOfWallet(){
        return walletService.getWalletList();
    }

    @GetMapping("/api/wallets/{id}")
    public Wallet getWalletById(@PathVariable Integer id){
        return walletService.getWalletById(id);
    }

    @PostMapping("/api/wallets")
    public Wallet createWallet(@RequestBody WalletRequest request){
        return  walletService.createWallet(request);
    }
}