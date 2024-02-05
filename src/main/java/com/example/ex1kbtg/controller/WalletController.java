package com.example.ex1kbtg.controller;

import com.example.ex1kbtg.dto.WalletRequest;
import com.example.ex1kbtg.model.Wallet;
import com.example.ex1kbtg.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;


    @GetMapping("/api/wallets")
    public List<Wallet> listOfWallet(){
        return this.walletService.getWalletList();
    }
    @GetMapping("/api/wallets/{id}")
    public Wallet getWalletById(@PathVariable Integer id){
        return walletService.getWalletById(id);
    }

    @PostMapping("/api/wallets")
    public Wallet createWallet(@RequestBody WalletRequest request){
        return  walletService.createWallet(request);
    }

    @PutMapping("{id}")
    public Wallet updateWallet(@RequestBody WalletRequest request ,@PathVariable Integer id){
        return walletService.updateWallet(request, id);
    }

    @DeleteMapping("{id}")
    public void deleteWalletById(@PathVariable Integer id){
        walletService.deleteWalletById(id);
    }
}
