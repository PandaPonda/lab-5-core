package org.example.model.score;
import org.example.model.account.Account;
import org.example.model.money.Money;

import static org.example.model.constants.Constants.MAX_WITHDRAWAL;
import static org.example.model.constants.Constants.MIN_CREDIT_BALANCE;

public class DebetScore extends Score {
    private CreditScore creditScore;
    public DebetScore(Money balance, Account owner, Integer number, CreditScore creditScore) {
        super(balance, owner, number);
        this.creditScore = creditScore;
    }

    @Override
    protected boolean checkBefore(Money money) {
        if (this.creditScore.getBalance().getValue() < MIN_CREDIT_BALANCE)
        {
            throw new IllegalArgumentException("your credit account balance is less than "+MIN_CREDIT_BALANCE+ " debit account transactions are prohibited");
        }
        return true;
    }
    @Override
    public Money getMoney(double balanceLess){
        if (this.creditScore.getBalance().getValue() < MIN_CREDIT_BALANCE)
        {
            throw new IllegalArgumentException("your credit account balance is less than "+MIN_CREDIT_BALANCE+ " debit account transactions are prohibited");
        }
        else if (balanceLess > MAX_WITHDRAWAL) {
            throw new IllegalArgumentException("Wrong balance less!");
        }
        this.getBalance().setValue(this.getBalance().getValue() - balanceLess);
        return this.getBalance();
    }
}