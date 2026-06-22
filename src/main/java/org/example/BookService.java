package org.example;
import java.util.ArrayList;
import java.util.Comparator;
public class BookService {
    public static void displayBooks(ArrayList<Book> books) {
        System.out.println("\nBook Details\n");
        System.out.printf("%-5s %-50s %-10s %-30s %-10s %-10s%n", "Id","Book Name","Year", "Author", "Price","Status");
        for(Book book:books) {
            System.out.printf("%-5d %-50s %-10s %-30s %-10.2f %-10s%n", book.getId(), book.getTitle(),book.getYear(), book.getAuthor(), book.getPrice(),book.getStatus());
        }
    }
    public static Book searchBookbyId(ArrayList<Book> books,int id) throws BookNotFoundException{
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        throw new BookNotFoundException("Book with Id " + id + " not found");
    }
    public static void sortBooksByAuthorAndYear(ArrayList<Book> books) {
        System.out.printf("%-30s %-5s %-40s%n","Author","Year","Book Name");
        books.stream().sorted(Comparator.comparing(Book::getAuthor).thenComparing(Book::getYear)).forEach(book ->
                System.out.printf("%-30s %-5d %-40s%n", book.getAuthor(), book.getYear(), book.getTitle()));
    }
    public static void displayAvailableBooks(ArrayList<Book> books){
        System.out.println("\nAvailable Books\n");
        System.out.printf("%-20s %-10s %-5s %-50s%n","Author","Year","Id","Book Name");
        for(Book book:books){
            if(book.getStatus()==BookStatus.AVAILABLE){
                System.out.printf("%-20s %-10d %-5d %-50s%n",book.getAuthor(),book.getYear(),book.getId(),book.getTitle());
            }
        }
    }
}
