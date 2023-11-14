package ru.penzgtu.task;

import ru.penzgtu.user.Data;
import ru.penzgtu.user.Status;

/**
 * Вывод в консоль краткого Ф. И. О. всех активных пользователей.
 */
public class OutputOfAllActiveUsers implements TaskRunnable {
    private final Data data;

    public OutputOfAllActiveUsers(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("[?] Output of all active users.");
        data.data.stream()
                .filter(user -> user.getStatus().equals(Status.ACTIVE))
                .map(user -> user.getName().getFirst() + " "
                        + user.getName().getMiddle().charAt(0) + ". "
                        + user.getName().getLast() + ".")
                .forEach(System.out::println);
    }
}
