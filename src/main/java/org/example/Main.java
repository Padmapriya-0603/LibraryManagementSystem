package org.example;
public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[10];
        Member[] members = new Member[5];
        Loan[] loans = new Loan[5];
        books[0] = new Book(1, "Harry Potter and The Philosopher's Stone", "J.K.Rowling", 750.00, BookStatus.AVAILABLE);
        books[1] = new Book(2, "Pride and Prejudice", "Jane Austen", 250.00, BookStatus.AVAILABLE);
        books[2] = new Book(3, "Fantastic Beasts and Where to Find Them", "J.K.Rowling", 450.00, BookStatus.AVAILABLE);
        books[3] = new Book(4, "The Guide", "R.K.Narayanan", 300.00, BookStatus.AVAILABLE);
        books[4] = new Book(5, "War and Peace", "Leo Tolstoy", 1050.00, BookStatus.AVAILABLE);
        books[5] = new Book(6, "The Alchemist", "Paulo Coelho", 1985.00, BookStatus.AVAILABLE);
        books[6] = new Book(7, "Hamlet", "William Shakespeare", 1200.00, BookStatus.AVAILABLE);
        books[7] = new Book(8, "The Blue Umbrella ", "Ruskin Bond", 800.50, BookStatus.AVAILABLE);
        books[8] = new Book(9, "Wonder", "R.J.Palacio", 560.00, BookStatus.AVAILABLE);
        books[9] = new Book(10, "The Wild Robot", "Peter Brown", 400.00, BookStatus.AVAILABLE);
        members[0] = new Member(1, "Hannah");
        members[1] = new Member(2, "David");
        members[2] = new Member(3, "Leoni");
        members[3] = new Member(4, "Arun");
        members[4] = new Member(5, "Priya");
        loans[0] = new Loan(books[0], members[3]);
        loans[1] = new Loan(books[3], members[0]);
        loans[2] = new Loan(books[7], members[1]);
        loans[3] = new Loan(books[9], members[4]);
        loans[4] = new Loan(books[5], members[2]);
        System.out.printf("%-5s %-50s %-30s %-10s%n", "Id", "Book Name", "Author", "Price");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-5d %-50s %-30s %-10.2f%n", books[i].Id(), books[i].Title(), books[i].Author(), books[i].Price());
        }
        System.out.printf("%-5s %-20s%n", "Member Id", "Name");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%-5d %-20s%n", members[i].getMemberId(), members[i].getName());
        }
        System.out.printf("%-5s %-20s %-50s %-20s %-20s", "Member Id", "Name", "Book Name", "Issue Date", "Due Date");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%-10d %-20s %-50s %-20s %-20s%n", loans[i].getMemberId(), loans[i].getMember().getName(), loans[i].getBook().Title(), loans[i].getIssueDate(), loans[i].getDueDate());
        }
    }}
