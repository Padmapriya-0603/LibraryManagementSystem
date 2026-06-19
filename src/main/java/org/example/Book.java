package org.example;

public class Book {
    private int id;
    private String title;
    private int year;
    private String author;
    private double price;
    private BookStatus status;
    Book(int id,String title,int year, String author,double price,BookStatus status){
        this.id=id;
        this.title=title;
        this.year=year;
        this.author=author;
        this.price=price;
        this.status=status;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public int getYear(){
        return year;
    }
    public String getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }
    public BookStatus getStatus(){
        return status;
    }
    public void setStatus(BookStatus status){
        this.status=status;
    }
}

