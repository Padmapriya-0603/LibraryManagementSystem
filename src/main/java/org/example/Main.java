package org.example;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Loan> loans = new ArrayList<>();
        books.add(new Book(1, "Harry Potter and The Philosopher's Stone", 1997,"J.K.Rowling", 750.00, BookStatus.AVAILABLE));
        books.add(new Book(2, "Pride and Prejudice",1813, "Jane Austen", 250.00, BookStatus.AVAILABLE));
        books.add(new Book(3, "Fantastic Beasts and Where to Find Them",2001, "J.K.Rowling", 450.00, BookStatus.AVAILABLE));
        books.add(new Book(4, "The Guide",1958, "R.K.Narayanan", 300.00, BookStatus.AVAILABLE));
        books.add(new Book(5, "War and Peace",1869, "Leo Tolstoy", 1050.00, BookStatus.AVAILABLE));
        books.add(new Book(6, "The Alchemist",1988, "Paulo Coelho", 1985.00, BookStatus.AVAILABLE));
        books.add(new Book(7, "Hamlet",1603, "William Shakespeare", 1200.00, BookStatus.AVAILABLE));
        books.add(new Book(8, "The Blue Umbrella ",1980, "Ruskin Bond", 800.50, BookStatus.AVAILABLE));
        books.add(new Book(9, "Wonder",2012, "R.J.Palacio", 560.00, BookStatus.AVAILABLE));
        books.add(new Book(10, "The Wild Robot",2016, "Peter Brown", 400.00, BookStatus.AVAILABLE));
        BookService.displayBooks(books);
        members.add(new Member(1, "Hannah"));
        members.add(new Member(2, "David"));
        members.add(new Member(3, "Leoni"));
        members.add(new Member(4, "Arun"));
        members.add(new Member(5, "Priya"));
        MemberService.displayMembers(members);
        BookService.sortBooksByAuthorAndYear(books);
        try{
        LoanService.borrowBook(loans,books.get(0), members.get(3));
        LoanService.borrowBook(loans,books.get(3), members.get(0));
        LoanService.borrowBook(loans,books.get(7), members.get(1));
        LoanService.borrowBook(loans,books.get(9), members.get(4));
        LoanService.borrowBook(loans,books.get(5), members.get(2));}
        catch(BookUnavailableException e){
            System.out.println(e.getMessage());
        }
        LoanService.displayLoans(loans);
        BookService.displayAvailableBooks(books);
        try {
            LoanService.borrowBook(loans, books.get(0), members.get(0));
        } catch(BookUnavailableException e){
            System.out.println(e.getMessage());
        }
        LoanService.returnBook(loans, books.get(0));
        LoanService.reserveBook(books.get(3));
        try {
            Book book = BookService.searchBookbyId(books, 11);
            System.out.println("\nBook Found");
            System.out.println("Book Title : " + book.getTitle());
            System.out.println("Author     : " + book.getAuthor());
        }catch(BookNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
        Member member=MemberService.searchMemberbyId(members,2);
        System.out.println("\nMember Found");
        System.out.println("Member Name : " + member.getName());
        } catch(MemberNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
