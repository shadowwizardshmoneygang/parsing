package ru.penzgtu.task;

import ru.penzgtu.user.Data;

import java.math.BigDecimal;

/**
 * Вывод в консоль отсортированного списка названий профессий, за
 * которые платят более 500.00.
 */
public class OutputTheHighestPayingProfessions implements TaskRunnable {
    private final Data data;
    private final BigDecimal HIGHEST_PAYING = BigDecimal.valueOf(500);

    public OutputTheHighestPayingProfessions(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("[?] Output the highest paying professions.");
        data.getData().stream()
                .filter(user -> user.getMonthlySalary().compareTo(HIGHEST_PAYING) > 0)
                .map(user -> user.getJob().getType())
                .distinct()
                .sorted()
                .forEach(type -> System.out.printf("%s.\n", type));
    }
}
