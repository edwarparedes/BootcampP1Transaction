package com.nttdata.transaction.repository;

import com.nttdata.transaction.entity.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ITransactionRepository extends ReactiveMongoRepository<Transaction, String> {

}
