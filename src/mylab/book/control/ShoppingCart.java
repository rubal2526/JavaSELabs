package mylab.book.control;

import java.util.ArrayList;
import java.util.List;
import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ShoppingCart {
    private List<Publication> items; // ArrayList�� ���� ũ�� ����

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + "��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
    }

    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "��(��) ��ٱ��Ͽ��� ���ŵǾ����ϴ�.");
                return true; 
            }
        }
        System.out.println("�ش� ������ ���ǹ��� ã�� �� �����ϴ�.");
        return false; 
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (Publication item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) {
                total += item.getPrice() * 0.9; 
            } else if (item instanceof Novel) {
                total += item.getPrice() * 0.85; 
            } else if (item instanceof ReferenceBook) {
                total += item.getPrice() * 0.8; 
            } else {
                total += item.getPrice(); 
            }
        }
        return total;
    }

    public void displayCart() {
        System.out.println("====== ��ٱ��� ���� ======");
        for (int i = 0; i < items.size(); i++) {
            Publication item = items.get(i);
            System.out.println((i + 1) + ". " + item.getTitle() + " - " + item.getPrice() + "��");
        }
        System.out.println("�� ����: " + calculateTotalPrice() + "��");
        System.out.println("���� ���� ����: " + calculateDiscountedPrice() + "��");
    }

    public void printStatistics() {
        int magazineCount = 0;
        int novelCount = 0;
        int referenceBookCount = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) {
                magazineCount++;
            } else if (item instanceof Novel) {
                novelCount++;
            } else if (item instanceof ReferenceBook) {
                referenceBookCount++;
            }
        }
        System.out.println("====== ��ٱ��� ��� ======");
        System.out.println("����: " + magazineCount + "��");
        System.out.println("�Ҽ�: " + novelCount + "��");
        System.out.println("����: " + referenceBookCount + "��");
        System.out.println("�� ���ǹ�: " + items.size() + "��");
    }
    
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        Publication[] publications = {
            new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�"),
            new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�"),
            new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"),
            new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�"),
            new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������")
        };
        
        for(Publication p : publications) {
            cart.addItem(p);
        }
        
        cart.displayCart();
        cart.printStatistics();
        
        cart.removeItem("���߿�");
        cart.displayCart();
    }
}