package ru.penzgtu.task;

import ru.penzgtu.user.Data;
import ru.penzgtu.user.Status;

import java.util.HashMap;
import java.util.Map;

/**
 * Вывод в консоль статистики по штатам с количеством неактивных пользователей,
 * отсортированной по убыванию (выводятся первые пять).
 */
public class OutputOfStateStatisticsOnTheNumberOfInactiveUsers implements TaskRunnable {
    private final Data data;
    private final int limit = 5;

    public OutputOfStateStatisticsOnTheNumberOfInactiveUsers(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("[?] Output of state statistics on the number of inactive users.");

        // Подсчёт неактивных пользователей по штатам.
        Map<String, Integer> stateStatisticsOnTheNumberOfInactiveUsers = new HashMap<>();
        data.data.stream()
                .filter(user -> user.getStatus().equals(Status.DISABLED))
                .forEach(user -> {
                    // Отдельно созданные переменные я использую для того, чтобы не превышать
                    // длинну строки в 100 символов.
                    String state = user.getLocation().getState();
                    if (!stateStatisticsOnTheNumberOfInactiveUsers.containsKey(state)) {
                        stateStatisticsOnTheNumberOfInactiveUsers.put(state, 0);
                    }
                    int quantity = stateStatisticsOnTheNumberOfInactiveUsers.get(state);
                    stateStatisticsOnTheNumberOfInactiveUsers.put(state, quantity + 1);
                });

        // Более-менее нормальный вывод.
        stateStatisticsOnTheNumberOfInactiveUsers.entrySet().stream()
                .sorted((first, second) -> second.getValue().compareTo(first.getValue()))
                .limit(limit)
                .map(state -> state.getKey() + ": " + state.getValue() + ".")
                .forEach(System.out::println);
    }
}
