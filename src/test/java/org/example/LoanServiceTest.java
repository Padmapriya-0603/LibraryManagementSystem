package org.example;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
public class LoanServiceTest {
    @Test
    void testBorrowUnavailableBook() {
        ArrayList<Loan> loans = new ArrayList<>();
        Book book = new Book(1, "Harry Potter", 1997, "J.K.Rowling", 750, BookStatus.BORROWED);
        Member member = new Member(1, "Hannah");
        assertThrows(BookUnavailableException.class, () -> LoanService.borrowBook(loans, book, member));
    }
    @Test
    void testBorrowBook() throws BookUnavailableException {
        ArrayList<Loan> loans = new ArrayList<>();
        Book book = new Book(1, "Harry Potter", 1997, "J.K.Rowling", 750, BookStatus.AVAILABLE);
        Member member = new Member(1, "Hannah");
        LoanService.borrowBook(loans, book, member);
        assertEquals(BookStatus.BORROWED, book.getStatus());
        assertEquals(1, loans.size());
    }
    @Test
    void testReturnBook() throws BookUnavailableException {
        ArrayList<Loan> loans = new ArrayList<>();
        Book book = new Book(1, "Harry Potter", 1997, "J.K.Rowling", 750.0, BookStatus.AVAILABLE);
        Member member = new Member(1, "Hannah");
        LoanService.borrowBook(loans, book, member);
        LoanService.returnBook(loans, book);
        assertEquals(BookStatus.AVAILABLE, book.getStatus());
        assertEquals(0, loans.size());
    }
    @Test
    void testReserveBook() {
        Book book = new Book(1, "Harry Potter", 1997, "J.K.Rowling", 750.0, BookStatus.BORROWED);
        LoanService.reserveBook(book);
        assertEquals(BookStatus.RESERVED, book.getStatus());
    }
    @Test
    void testReserveAvailableBook() {
        Book book = new Book(1, "Harry Potter", 1997, "J.K.Rowling", 750.0, BookStatus.AVAILABLE);
        LoanService.reserveBook(book);
        assertEquals(BookStatus.AVAILABLE, book.getStatus());
    }
}
