package org.example;
import java.util.ArrayList;
public class LoanService {
    public static void displayLoans(ArrayList<Loan> loans) {
        System.out.println("\nLoan Details");
        System.out.printf("%-5s %-20s %-50s %-20s %-20s", "Member Id", "Name", "Book Name", "Issue Date", "Due Date");
        for (Loan loan : loans) {
            System.out.printf("%-10d %-20s %-50s %-20s %-20s%n", loan.getMemberId(), loan.getMember().getName(), loan.getBook().getTitle(), loan.getIssueDate(), loan.getDueDate());
        }
    }
    public static void borrowBook(ArrayList<Loan> loans,Book book,Member member) throws BookUnavailableException{
        if (book.getStatus()!=BookStatus.AVAILABLE) {
            throw new BookUnavailableException("Book is already reserved or borrowed");
        }
            loans.add(new Loan(book, member));
            book.setStatus(BookStatus.BORROWED);
            System.out.println(member.getName() + " borrowed " + book.getTitle());
        }
    public static void returnBook(ArrayList<Loan> loans,Book book){
        for(Loan loan:loans){
            if(loan.getBook().getId()== book.getId()){
                loans.remove(loan);
                book.setStatus(BookStatus.AVAILABLE);
                System.out.println(book.getTitle()+"returned successfully");
                break;
            }
        }
    }
    public static void reserveBook(Book book){
        if(book.getStatus()==BookStatus.BORROWED){
            book.setStatus(BookStatus.RESERVED);
            System.out.println(book.getTitle() + " has reserved successfully");
        }
        else{
            System.out.println("Only borrowed books can be reserved!");
        }
    }
}
