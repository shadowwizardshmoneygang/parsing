package ru.penzgtu.task;

import ru.penzgtu.user.Data;
import ru.penzgtu.user.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Вывод в консоль Ф. И. О. и почты тех, кто старше 30 лет,
 * с активным статусом, имеет заработок ниже 100.00,
 * использует почту example.com.
 */
public class OutputSpecificUsers implements TaskRunnable {
    private final Data data;
    private final int AGE = 30;
    private final BigDecimal SALARY = BigDecimal.valueOf(100);
    private final String EMAIL_DOMAIN = "example.com";

    public OutputSpecificUsers(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("[?] Output specific users.");

        // Если что, то поток обрабатывает элементы по одному, т. е. сначала через все фильтры пройдёт
        // первый элемент (либо не пройдёт), а потом уже начнёт проходить их второй и т. д., но не
        // первый элемент через первый фильтр, второй элемент через первый фильтр и т. д. Поэтому не
        // вижу здесь смысла лепить один огромный фильтр.
        data.getData().stream()
                .filter(user -> ChronoUnit.YEARS.between(user.getBirthday(), LocalDateTime.now()) > AGE)
                .filter(user -> user.getStatus().equals(Status.ACTIVE))
                .filter(user -> user.getMonthlySalary().compareTo(SALARY) < 0)
                .filter(user -> {
                    for (String email : user.getEmails()) {
                        if (email.contains(EMAIL_DOMAIN)) {
                            return true;
                        }
                    }
                    return false;
                })
                .map(user -> {
                    for (String email : user.getEmails()) {
                        if (email.contains(EMAIL_DOMAIN)) {
                            return user.getName() + ": " + email + ".";
                        }
                    }
                    return null; // Это вынужденный return: я его не хотел.
                })
                .forEach(System.out::println);
    }
}
