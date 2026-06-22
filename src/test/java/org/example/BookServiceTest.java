package org.example;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
public class BookServiceTest {
        @Test
        void testSearchBookById() throws BookNotFoundException {
            ArrayList<Book> books = new ArrayList<>();
            books.add(new Book(1,"Harry Potter",1997,"J.K.Rowling",750,BookStatus.AVAILABLE));
            Book book = BookService.searchBookbyId(books,1);
            assertNotNull(book);
            assertEquals("Harry Potter",book.getTitle());
            assertEquals(1997,book.getYear());
            assertEquals(BookStatus.AVAILABLE,book.getStatus());
        }
    @Test
    void testBookNotFound() {
        ArrayList<Book> books = new ArrayList<>();
        assertThrows(BookNotFoundException.class, () -> BookService.searchBookbyId(books,1));
    }
    @Test
    void testSearchBookNotFound() {
        ArrayList<Book> books = new ArrayList<>();
        assertThrows(BookNotFoundException.class,() -> BookService.searchBookbyId(books, 100));
    }
    @Test
    void testDisplayBooks() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1,"Harry Potter",1997,"J.K.Rowling",750,BookStatus.AVAILABLE));
        assertDoesNotThrow(() -> BookService.displayBooks(books));
    }
    @Test
    void testDisplayAvailableBooks() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1,"Harry Potter",1997,"J.K.Rowling",750,BookStatus.AVAILABLE));
        assertDoesNotThrow(() -> BookService.displayAvailableBooks(books));
    }
    @Test
    void testSortBooksByAuthorAndYear() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1,"Harry Potter",1997,"J.K.Rowling",750,BookStatus.AVAILABLE));
        books.add(new Book(2,"Pride and Prejudice",1813,"Jane Austen",250,BookStatus.AVAILABLE));
        assertDoesNotThrow(() -> BookService.sortBooksByAuthorAndYear(books));
    }
}

