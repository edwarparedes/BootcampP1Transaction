package com.nttdata.transaction.controller;

import com.nttdata.transaction.entity.Transaction;
import com.nttdata.transaction.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    ITransactionService service;

    @GetMapping
    public Flux<Transaction> getTransactions(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Transaction>> getTransactionById(@PathVariable("id") String id){
        return service.getTransactionById(id)
                .map(savedMessage -> ResponseEntity.ok(savedMessage))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    Mono<Transaction> postTransaction(@RequestBody Transaction transaction){
        return service.save(transaction);
    }

    @PutMapping
    Mono<Transaction> updTransaction(@RequestBody Transaction transaction){
        return service.update(transaction);
    }

    @DeleteMapping("/{id}")
    void dltTransaction(@PathVariable("id") String id){
        service.delete(id);
    }


}
