package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
        System.out.println("������ �߰��Ǿ����ϴ�: " + book.getTitle());
    }

    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public Book findByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public boolean checkOutBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null) {
            return book.checkOut(); // Book ��ü���� ������ ����
        }
        return false;
    }

    public boolean returnBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null && !book.isAvailable()) {
            book.returnBook(); // Book ��ü���� �ݳ��� ����
            return true;
        }
        return false;
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books); // �ܺο��� �������� ���ϵ��� ���纻�� ��ȯ
    }

    public int getTotalBooks() {
        return books.size();
    }

    public int getAvailableBooksCount() {
        int count = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }

    public void displayLibraryStatus() {
        System.out.println("===== " + this.name + " =====");
        System.out.println("��ü ���� ��: " + getTotalBooks());
        System.out.println("���� ���� ���� ��: " + getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + getBorrowedBooksCount());
        System.out.println();
    }
}