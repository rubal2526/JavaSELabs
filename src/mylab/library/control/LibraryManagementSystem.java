package mylab.library.control;

import java.util.List;
import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library("�߾� ������");

        addSampleBooks(library);
        System.out.println();

        library.displayLibraryStatus();

        testFindBook(library);
        testCheckOutAndReturn(library);

        displayAvailableBooks(library);
    }

    private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
    }

    private static void testFindBook(Library library) {
        System.out.println("===== ���� �˻� �׽�Ʈ =====");
        System.out.println("�������� �˻� ���:");
        Book foundByTitle = library.findByTitle("�ڹ��� ����");
        System.out.println(foundByTitle);

        System.out.println("\n���ڷ� �˻� ���:");
        List<Book> foundByAuthor = library.findByAuthor("Robert C. Martin");
        for (Book book : foundByAuthor) {
            System.out.println(book);
        }
        System.out.println();
    }
   
    private static void testCheckOutAndReturn(Library library) {
        String testIsbn = "978-89-01-14077-4";

        System.out.println("===== ���� ���� �׽�Ʈ =====");
        boolean successCheckOut = library.checkOutBook(testIsbn);
        if (successCheckOut) {
            System.out.println("���� ���� ����!");
            System.out.println("����� ���� ����:");
            System.out.println(library.findByISBN(testIsbn));
        }
        System.out.println("\n������ ���� ����:");
        library.displayLibraryStatus();

        // --- �ݳ� �׽�Ʈ ---
        System.out.println("===== ���� �ݳ� �׽�Ʈ =====");
        boolean successReturn = library.returnBook(testIsbn);
        if (successReturn) {
            System.out.println("���� �ݳ� ����!");
            System.out.println("�ݳ��� ���� ����:");
            System.out.println(library.findByISBN(testIsbn));
        }
        System.out.println("\n������ ���� ����:");
        library.displayLibraryStatus();
    }

    private static void displayAvailableBooks(Library library) {
        System.out.println("===== ���� ������ ���� ��� =====");
        List<Book> availableBooks = library.getAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println(book);
            System.out.println("------------------------");
        }
    }
}