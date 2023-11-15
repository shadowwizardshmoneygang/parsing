package ru.penzgtu.task;

import ru.penzgtu.user.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Вывод в консоль статистики использования кредитных карт.
 */
public class OutputCreditCardUsageStatistics implements TaskRunnable {
    private final Data data;

    public OutputCreditCardUsageStatistics(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("[?] Output credit card usage statistics.");

        // Подсчёт кол-ва пользователей той или иной карты.
        Map<String, Integer> creditCardUsageStatistics = new HashMap<>();
        data.getData().forEach(user -> {
            String issuer = user.getCreditCard().getIssuer();
            if (!creditCardUsageStatistics.containsKey(issuer)) {
                creditCardUsageStatistics.put(issuer, 0);
            }
            creditCardUsageStatistics.put(issuer, creditCardUsageStatistics.get(issuer) + 1);
        });

        // Более-менее красивый вывод.
        for (String creditCard : creditCardUsageStatistics.keySet()) {
            System.out.printf("%s: %d.\n", creditCard, creditCardUsageStatistics.get(creditCard));
        }
    }
}
