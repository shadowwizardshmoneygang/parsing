package ru.penzgtu;

import ru.penzgtu.parser.JsonParser;
import ru.penzgtu.task.*;
import ru.penzgtu.user.Data;

import java.io.IOException;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        try (JsonParser parser = new JsonParser("src/main/java/ru/penzgtu/data.json")) {
            Data data = parser.parse(Data.class);
            Stream.of(
                    new OutputOfAllActiveUsers(data),
                    new OutputTheNumberOfUsersUsingGmail(data),
                    new OutputCreditCardUsageStatistics(data),
                    new OutputTheHighestPayingProfessions(data),
                    new OutputSpecificUsers(data),
                    new OutputOfStateStatisticsOnTheNumberOfInactiveUsers(data),
                    new OutputOfTheHighestPaidAndYoungestUser(data),
                    new OutputOfUniqueCompanyNames(data)
            ).forEach(TaskRunnable::run);
        } catch (IOException exception) {
            System.out.println(exception.toString());
        }
    }
}
