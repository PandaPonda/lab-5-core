package org.example.model.score;
import org.example.model.account.Account;
import org.example.model.money.Money;

public class CreditScore extends Score {
    public CreditScore(Money balance, Account owner, Integer number) {
        super(balance, owner, number);
    }

    @Override
    protected boolean checkBefore(Money money) {
        return true;
    }
}