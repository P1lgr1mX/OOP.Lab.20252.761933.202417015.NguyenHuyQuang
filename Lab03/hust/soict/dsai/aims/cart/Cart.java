package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Thêm 1 DVD (Gốc)
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }

    // 2.1. Overloading bằng mảng (Array)
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                addDigitalVideoDisc(disc);
            } else {
                System.out.println("The cart is almost full.");
                break;
            }
        }
    }

    /* // 2.1. Thử nghiệm với Varargs (Arbitrary number of arguments)
    // Bạn có thể dùng cái này thay cho mảng ở trên vì nó bao hàm cả mảng
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc disc : dvds) {
            addDigitalVideoDisc(disc);
        }
    }
    */

    // 2.2. Overloading bằng cách thay đổi số lượng tham số (2 DVD)
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 1 < MAX_NUMBERS_ORDERED) {
            addDigitalVideoDisc(dvd1);
            addDigitalVideoDisc(dvd2);
        } else {
            System.out.println("Not enough space for 2 DVDs.");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                return;
            }
        }
        System.out.println("The disc is not in the cart.");
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}
