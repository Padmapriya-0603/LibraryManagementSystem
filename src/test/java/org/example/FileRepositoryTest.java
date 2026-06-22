package org.example;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
public class FileRepositoryTest {
    @Test
    void testSaveBooks() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "Harry Potter", 1997, "J.K.Rowling", 750, BookStatus.AVAILABLE));
        assertDoesNotThrow(() -> FileRepository.saveBooks(books));
    }
    @Test
    void testLoadBooks() {
        ArrayList<Book> books = FileRepository.loadBooks();
        assertNotNull(books);
    }
    @Test
    void testLoanConstructor() {
        Book book = new Book(1,"Harry Potter",1997, "J.K.Rowling", 750, BookStatus.AVAILABLE);
        Member member = new Member(1,"Hannah");
        Loan loan = new Loan(book,member);
        assertEquals(book,loan.getBook());
        assertEquals(member,loan.getMember());
    }
    @Test
    void testSaveAndLoadBooks() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "Harry Potter", 1997, "J.K.Rowling", 750, BookStatus.AVAILABLE));
        FileRepository.saveBooks(books);
        ArrayList<Book> loadedBooks = FileRepository.loadBooks();
        assertEquals(1, loadedBooks.size());
        assertEquals("Harry Potter", loadedBooks.get(0).getTitle());
    }
}
