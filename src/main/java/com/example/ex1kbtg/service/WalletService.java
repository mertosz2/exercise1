package com.example.ex1kbtg.service;

import com.example.ex1kbtg.dto.WalletRequest;
import com.example.ex1kbtg.exception.NotFoundException;
import com.example.ex1kbtg.model.Wallet;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class WalletService {


    private List<Wallet> walletList = new ArrayList<>(List.of(
            new Wallet(1,"wallet1"),
            new Wallet(2,"wallet2"),
            new Wallet(3,"wallet3")
    ));
    public List<Wallet> getWalletList(){
        return  walletList;
    }

    public Wallet createWallet(WalletRequest request){
        Optional<Integer> maxId = walletList.stream()
                                            .map(Wallet::getId)
                                            .max(Integer::compareTo);
        int nextId = maxId.orElse(0) + 1;

        Wallet wallet = new Wallet();
        wallet.setId(nextId);
        wallet.setName(request.getName());
        walletList.add(wallet);
        return wallet;


    }

    public Wallet getWalletById(Integer id){
        return walletList.stream().filter(wallet -> wallet.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Wallet not found by id " + id ));
    }

}
