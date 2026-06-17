package org.example;
import java.time.LocalDate;
public class Loan {private int memberId;
    private Member member;
    private Book book;
    private LocalDate issueDate;
    private LocalDate dueDate;
    public Loan(Book book,Member member){
        this.memberId= member.getMemberId();
        this.member=member;
        this.book=book;
        this.issueDate=LocalDate.now();
        this.dueDate=LocalDate.now().plusDays(14);
    }
    public int getMemberId(){
        return memberId;
    }
    public Book getBook(){
        return book;
    }
    public Member getMember(){
        return member;
    }
    public LocalDate getIssueDate() {
        return issueDate;
    }
    public LocalDate getDueDate(){
        return dueDate;
    }
}
