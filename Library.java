package LibraryManagementSystem;

import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void showBooks() {
        System.out.println("\n--- Book List ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showUsers() {
        System.out.println("\n--- User List ---");
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        if (book != null && !book.isIssued()) {
            book.setIssued(true);
            System.out.println("Book issued to user ID " + userId);
        } else {
            System.out.println("Book not available or already issued.");
        }
    }

    public void returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book != null && book.isIssued()) {
            book.setIssued(false);
            System.out.println("Book returned.");
        } else {
            System.out.println("Invalid return attempt.");
        }
    }

    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id)
                return book;
        }
        return null;
    }
}
