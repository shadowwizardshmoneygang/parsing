package ru.penzgtu.task;

import ru.penzgtu.user.Data;
import ru.penzgtu.user.Status;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Вывод в консоль самого высокооплачиваемого активного пользователя в
 * возрасте до 21 года.
 */
public class OutputOfTheHighestPaidAndYoungestUser implements TaskRunnable {
    private final Data data;
    private final int age = 21;
    private final int limit = 1;

    public OutputOfTheHighestPaidAndYoungestUser(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("[?] Output of the highest paid and youngest user.");
        data.data.stream()
                .filter(user -> user.getStatus().equals(Status.ACTIVE))
                .filter(user -> ChronoUnit.YEARS.between(user.getBirthday(), LocalDateTime.now()) < age)
                .sorted((first, second) -> second.getMonthlySalary().compareTo(first.getMonthlySalary()))
                .limit(limit)
                .forEach(System.out::println);
    }
}
