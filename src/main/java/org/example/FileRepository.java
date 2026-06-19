package org.example;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
    public class FileRepository {
        public static void saveBooks(ArrayList<Book> books) {
            Path path = Paths.get("books.csv");
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                for (Book book : books) {
                    writer.write(book.getId() + "," + book.getTitle() + "," + book.getYear() + "," + book.getAuthor() + "," + book.getPrice() + "," + book.getStatus());
                    writer.newLine();
                }
                System.out.println("Books saved successfully.");
            } catch (IOException e) {
                System.out.println("Error saving file "+e.getMessage());
            }
        }
        public static ArrayList<Book>loadBooks(){
            ArrayList<Book> books=new ArrayList<>();
            Path path=Paths.get("books.csv");
            try {
                if (!Files.exists(path)) {
                    Files.createFile(path);
                    return books;
                }
                try (BufferedReader reader = Files.newBufferedReader(path)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split(",");
                        Book book = new Book(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), data[3], Double.parseDouble(data[4]), BookStatus.valueOf(data[5]));
                        books.add(book);
                    }
                }
            }catch(IOException e){
                System.out.println("Error Reading File "+e.getMessage());
            }
            return books;
        }
    }
