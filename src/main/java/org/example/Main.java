package org.example;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = FileRepository.loadBooks();
        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Loan> loans = new ArrayList<>();
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
        FileRepository.saveBooks(books);
    }
}
