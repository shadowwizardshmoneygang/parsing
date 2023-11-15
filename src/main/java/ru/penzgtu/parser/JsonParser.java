package ru.penzgtu.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Парсинг json-файла.
 */
public class JsonParser {
    private final String path;
    // Небольшая настройка, которая исправит ошибку с парсингом LocalDateTime.
    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    /**
     * Создать экземпляр класса.
     *
     * @param path путь к json-файлу.
     */
    public JsonParser(String path) {
        this.path = path;
    }

    /**
     * Парсит json-файл в соответствии с POJO-классом.
     *
     * @param classOfType POJO-класс, в соответсвии с которым происходит парсинг.
     *                    Необходимо передать класс в метод таким образом:
     *                    {@code POJO.class}.
     * @return заполненый значениями из json-файла POJO-класс.
     * @param <T> тип POJO-класса.
     * @throws IOException реализация остаётся на плечах пользователя.
     */
    public <T> T parse(Class<T> classOfType) throws IOException {
        FileReader reader = new FileReader(path);
        return gson.fromJson(reader, classOfType);
    }
}
