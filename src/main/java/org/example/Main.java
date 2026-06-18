package org.example;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Loan> loans = new ArrayList<>();
        books.add(new Book(1, "Harry Potter and The Philosopher's Stone", "J.K.Rowling", 750.00, BookStatus.AVAILABLE));
        books.add(new Book(2, "Pride and Prejudice", "Jane Austen", 250.00, BookStatus.AVAILABLE));
        books.add(new Book(3, "Fantastic Beasts and Where to Find Them", "J.K.Rowling", 450.00, BookStatus.BORROWED));
        books.add(new Book(4, "The Guide", "R.K.Narayanan", 300.00, BookStatus.AVAILABLE));
        books.add(new Book(5, "War and Peace", "Leo Tolstoy", 1050.00, BookStatus.RESERVED));
        books.add(new Book(6, "The Alchemist", "Paulo Coelho", 1985.00, BookStatus.AVAILABLE));
        books.add(new Book(7, "Hamlet", "William Shakespeare", 1200.00, BookStatus.AVAILABLE));
        books.add(new Book(8, "The Blue Umbrella ", "Ruskin Bond", 800.50, BookStatus.BORROWED));
        books.add(new Book(9, "Wonder", "R.J.Palacio", 560.00, BookStatus.AVAILABLE));
        books.add(new Book(10, "The Wild Robot", "Peter Brown", 400.00, BookStatus.RESERVED));
        members.add(new Member(1, "Hannah"));
        members.add(new Member(2, "David"));
        members.add(new Member(3, "Leoni"));
        members.add(new Member(4, "Arun"));
        members.add(new Member(5, "Priya"));
        loans.add(new Loan(books.get(0), members.get(3)));
        loans.add(new Loan(books.get(3), members.get(0)));
        loans.add(new Loan(books.get(7), members.get(1)));
        loans.add(new Loan(books.get(9), members.get(4)));
        loans.add(new Loan(books.get(5), members.get(2)));
        displayBooks(books);
        displayMembers(members);
        displayLoans(loans);
        try{
        Book book=searchBookbyId(books,11);
        if (book==null) {
            throw new Exception("Book not found");
        }
            System.out.println("Book Title:" +book.Title());
            System.out.println("Author     :" +book.Author());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        Member member=searchMemberbyId(members,2);
        if(member!=null) {
            System.out.println("\nMember Found");
            System.out.println("Member Name :" +member.getName());
        } else {
            System.out.println("Member not found");
        }
    }
    public static void displayBooks(ArrayList<Book> books){
        System.out.println("\nBook Details\n");
        System.out.printf("%-5s %-50s %-30s %-10s %-10s%n", "Id", "Book Name", "Author", "Price","Status");
        for(Book book:books) {
            System.out.printf("%-5d %-50s %-30s %-10.2f %-10s%n", book.Id(), book.Title(), book.Author(), book.Price(),book.Status());
        }
    }
    public static void displayMembers(ArrayList<Member> members){
        System.out.println("\nMember Details\n");
        System.out.printf("%-5s %-20s%n", "Member Id", "Name");
        for(Member member:members) {
            System.out.printf("%-5d %-20s%n", member.getMemberId(), member.getName());
        }
    }
    public static void displayLoans(ArrayList<Loan> loans){
        System.out.println("\nLoan Details");
        System.out.printf("%-5s %-20s %-50s %-20s %-20s", "Member Id", "Name", "Book Name", "Issue Date", "Due Date");
        for(Loan loan:loans) {
            System.out.printf("%-10d %-20s %-50s %-20s %-20s%n", loan.getMemberId(), loan.getMember().getName(), loan.getBook().Title(), loan.getIssueDate(), loan.getDueDate());
        }
    }
    public static Book searchBookbyId(ArrayList<Book> books,int id){
        for (Book book : books) {
            if (book.Id() == id) {
                return book;
            }
        }
        return null;
    }
    public static Member searchMemberbyId(ArrayList<Member>members,int id){
        for(Member member:members){
            if(member.getMemberId()==id){
                return member;
            }
        }
        return null;
    }
}
