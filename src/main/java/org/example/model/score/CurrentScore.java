package org.example.model.score;
import org.example.model.account.Account;
import org.example.model.money.Money;
import static org.example.model.constants.Constants.BONUS_BORDER;
import static org.example.model.constants.Constants.BONUS_VALUE;

public class CurrentScore extends Score {
    private DebetScore debetScore;

    public CurrentScore(Money balance, Account owner, Integer number, DebetScore debetScore) {
        super(balance, owner, number);
        this.debetScore = debetScore;
    }

    @Override
    protected boolean checkBefore(Money money) {
        double usdValueIn = money.getValue() * money.getCurrency().getUsdCource();
        if (usdValueIn > BONUS_BORDER) {
            this.debetScore.addMoney(new Money(BONUS_VALUE, "GMС"));
        }
        return true;
    }
}
