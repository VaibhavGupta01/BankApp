package Service;

import model.Transaction;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransactionService {
    public List<Transaction> getTransactions() {
        return transactions;
    }
    List<Transaction> transactions = new ArrayList<>();

    public Transaction create(int amount, String reference){
        String id = UUID.randomUUID().toString();
        ZonedDateTime timestamp = ZonedDateTime.now();
        Transaction transaction =  new Transaction(id,amount,timestamp,reference);
        transactions.add(transaction);
        return transaction;
    }
}
