package com.nttdata.transaction.service;

import com.nttdata.transaction.entity.Transaction;
import com.nttdata.transaction.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    ITransactionRepository repository;

    @Override
    public Flux<Transaction> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Transaction> getTransactionById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Transaction> save(Transaction transaction) {

        return repository.save(transaction);
    }

    @Override
    public Mono<Transaction> update(Transaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id).subscribe();
    }

}
