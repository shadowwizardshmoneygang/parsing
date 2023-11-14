package ru.penzgtu.parser;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    @Override
    public void write(JsonWriter output, LocalDateTime result) throws IOException {
        output.value(result == null ? null : result.format(formatter));
    }

    @Override
    public LocalDateTime read(JsonReader input) throws IOException {
        String stringDate = input.nextString();
        return LocalDateTime.parse(stringDate, formatter);
    }
}
