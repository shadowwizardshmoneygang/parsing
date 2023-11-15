package ru.penzgtu.task;

import ru.penzgtu.user.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Вывод в консоль всех уникальных названий компаний.
 */
public class OutputOfUniqueCompanyNames implements TaskRunnable {
    private final Data data;

    public OutputOfUniqueCompanyNames(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("[?] Output of unique company names.");

        // Подсчёт кол-ва упоминаний той или иной компании.
        Map<String, Integer> quantityOfCompanyNames = new HashMap<>();
        data.getData().forEach(user -> {
            String company = user.getJob().getCompany();
            if (!quantityOfCompanyNames.containsKey(company)) {
                quantityOfCompanyNames.put(company, 0);
            }
            quantityOfCompanyNames.put(company, quantityOfCompanyNames.get(company) + 1);
        });

        // Вывод в консольку.
        quantityOfCompanyNames.forEach((company, quantity) -> {
            if (quantity == 1) {
                System.out.printf("%s.\n", company);
            }
        });
    }
}
