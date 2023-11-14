package ru.penzgtu.task;

import ru.penzgtu.user.Data;

import java.math.BigDecimal;

/**
 * Вывод в консоль отсортированного списка названий профессий, за
 * которые платят более 500.00.
 */
public class OutputTheHighestPayingProfessions implements TaskRunnable {
    private final Data data;
    private final BigDecimal highestPaying = BigDecimal.valueOf(500);

    public OutputTheHighestPayingProfessions(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("[?] Output the highest paying professions.");
        data.data.stream()
                .filter(user -> user.getMonthlySalary().compareTo(highestPaying) > 0)
                .map(user -> user.getJob().getType())
                .distinct()
                .sorted()
                .forEach(type -> System.out.printf("%s.\n", type));
    }
}
