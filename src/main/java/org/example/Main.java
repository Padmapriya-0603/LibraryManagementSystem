package org.example;
public class Main {
    public static void main(String[] args) {
        Book[] books= new Book[10];
        books[0]=new Book(1,"Harry Potter and The Philosopher's Stone","J.K.Rowling",750.00);
        books[1]=new Book(2,"Pride and Prejudice","Jane Austen",250.00);
        books[2]=new Book(3,"Fantastic Beasts and Where to Find Them","J.K.Rowling",450.00);
        books[3]=new Book(4,"The Guide","R.K.Narayanan",300.00);
        books[4]=new Book(5,"War and Peace","Leo Tolstoy",1050.00);
        books[5]=new Book(6,"The Alchemist","Paulo Coelho",1985.00);
        books[6]=new Book(7,"Hamlet","William Shakespeare",1200.00);
        books[7]=new Book(8,"The Blue Umbrella ","Ruskin Bond",800.50);
        books[8]=new Book(9,"Wonder","R.J.Palacio",560.00);
        books[9]=new Book(10,"The Wild Robot","Peter Brown",400.00);
        System.out.printf("%-5s %-50s %-30s %-10s%n","ID","Book Name","Author","Price");
        for(int i=0;i<10;i++){
        System.out.printf("%-5d %-50s %-30s %-10.2f%n",books[i].Id(),books[i].Title(),books[i].Author(),books[i].Price());
        }
    }}
