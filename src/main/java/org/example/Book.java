package org.example;

public record Book(
        int Id,
        String Title,
        String Author,
        double Price,
        BookStatus Status
) {}

