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
        data.data.forEach(user -> {
            // Отдельно созданные переменные я использую для того, чтобы не превышать
            // длинну строки в 100 символов.
            String issuer = user.getCreditCard().getIssuer();
            if (!creditCardUsageStatistics.containsKey(issuer)) {
                creditCardUsageStatistics.put(issuer, 0);
            }
            int quantity = creditCardUsageStatistics.get(issuer);
            creditCardUsageStatistics.put(issuer, quantity + 1);
        });

        // Более-менее красивый вывод.
        for (String creditCard : creditCardUsageStatistics.keySet()) {
            System.out.printf("%s: %d.\n", creditCard, creditCardUsageStatistics.get(creditCard));
        }
    }
}
