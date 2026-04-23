public class Store {
    private DigitalVideoDisc itemsInStore[];
    private int qtyInStore = 0;
    public static final int MAX_CAPACITY = 100;

    public Store() {
        itemsInStore = new DigitalVideoDisc[MAX_CAPACITY];
    }

    // Thêm DVD vào kho
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_CAPACITY) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The DVD " + dvd.getTitle() + " has been added to the store.");
        } else {
            System.out.println("The store is full!");
        }
    }

    // Xóa DVD khỏi kho
    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("The DVD " + dvd.getTitle() + " has been removed from the store.");
                return;
            }
        }
        System.out.println("The DVD " + dvd.getTitle() + " is not in the store.");
    }
}
