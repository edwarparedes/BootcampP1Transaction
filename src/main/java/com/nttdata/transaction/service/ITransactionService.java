package com.nttdata.transaction.service;

import com.nttdata.transaction.entity.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionService {

    Flux<Transaction> getAll();

    Mono<Transaction> getTransactionById(String id);

    Mono<Transaction> save(Transaction transaction);

    Mono<Transaction> update(Transaction transaction);

    void delete(String id);



}