package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // 1. Khởi tạo Store
        Store myStore = new Store();

        // 2. Tạo các đĩa DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // 3. Test thêm đĩa vào kho
        System.out.println("--- Testing Add DVD ---");
        myStore.addDVD(dvd1);
        myStore.addDVD(dvd2);
        myStore.addDVD(dvd3);

        // 4. Test xóa đĩa khỏi kho
        System.out.println("\n--- Testing Remove DVD ---");
        myStore.removeDVD(dvd2);    // Xóa đĩa đang có
        myStore.removeDVD(dvd2);    // Thử xóa lại đĩa vừa xóa (để test thông báo không tìm thấy)
    }
}
