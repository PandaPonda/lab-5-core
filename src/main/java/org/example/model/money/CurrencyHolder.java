package org.example.model.money;

import java.util.HashMap;
import java.util.Map;

public class CurrencyHolder {
    private static final Map<String,Currency> currencies = new HashMap<String, Currency>();
    static {
        currencies.put("USD",new Currency("USD", 1));
        currencies.put("RUR",new Currency("RUR", 65.5f));
        currencies.put("GMС",new Currency("GMС", 77));
    }
    public static Currency getCurrencyByName(String name) {
        return currencies.get(name);
    }
}
