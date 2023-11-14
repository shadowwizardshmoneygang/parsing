package ru.penzgtu.task;

import ru.penzgtu.user.Data;

/**
 * Вывод в консоль количества пользователей, которые используют почту gmail.com.
 */
public class OutputTheNumberOfUsersUsingGmail implements TaskRunnable {
    private final Data data;
    private final String emailDomain = "gmail.com";

    public OutputTheNumberOfUsersUsingGmail(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("[?] Output the number of users using gmail.");
        System.out.println("Quantity: " + data.data.stream()
            .filter(user -> {
                for (String email : user.getEmails()) {
                    if (email.contains(emailDomain)) {
                        return true;
                    }
                }
                return false;
            })
            .count() + "."
        );
    }
}
