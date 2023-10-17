package com.example.h2repository;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeTest {
    @Test
    void zonedDateTimeFormat() {
        ZoneId zoneId = ZoneId.of("America/New_York");
        ZonedDateTime zdt = ZonedDateTime.of(
                2023, 11, 15, 23, 50, 55, 0, zoneId);
        assertEquals("2023-11-15T23:50:55-05:00[America/New_York]", zdt.toString());
        assertEquals("2023-11-15T23:50:55", zdt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
    }
}
