import java.util.*;

// Abstract Class (Abstraction)
abstract class Library {
    abstract void addBook(Book b);
    abstract void showBooks();
}

// Book Class
class Book {
    int id;
    String name;
    String author;
    boolean isIssued;

    Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isIssued = false;
    }
}

// Derived Class (Inheritance)
class LibraryImpl extends Library {
    List<Book> books = new ArrayList<>();

    // Add Book
    void addBook(Book b) {
        books.add(b);
        System.out.println("Book added successfully!");
    }

    // Show Books
    void showBooks() {
        for (Book b : books) {
            System.out.println(b.id + " | " + b.name + " | " + b.author + " | Issued: " + b.isIssued);
        }
    }

    // Issue Book
    void issueBook(int id) {
        for (Book b : books) {
            if (b.id == id && !b.isIssued) {
                b.isIssued = true;
                System.out.println("Book issued!");
                return;
            }
        }
        System.out.println("Book not available!");
    }

    // Return Book
    void returnBook(int id) {
        for (Book b : books) {
            if (b.id == id && b.isIssued) {
                b.isIssued = false;
                System.out.println("Book returned!");
                return;
            }
        }
        System.out.println("Invalid return!");
    }
}

// Main Class
public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryImpl lib = new LibraryImpl();

        while (true) {
            System.out.println("\n1. Add Book\n2. Show Books\n3. Issue Book\n4. Return Book\n5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    lib.addBook(new Book(id, name, author));
                    break;

                case 2:
                    lib.showBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    lib.issueBook(issueId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    lib.returnBook(returnId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
