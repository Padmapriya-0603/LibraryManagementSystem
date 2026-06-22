package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class BookTest {
    @Test
    void testSetStatus() {
        Book book = new Book(1, "Harry Potter", 1997, "J.K.Rowling", 750, BookStatus.AVAILABLE);
        book.setStatus(BookStatus.BORROWED);
        assertEquals(BookStatus.BORROWED, book.getStatus());
    }

}
