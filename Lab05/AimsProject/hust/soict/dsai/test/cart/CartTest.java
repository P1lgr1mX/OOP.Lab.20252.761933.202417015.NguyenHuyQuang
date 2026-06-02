package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {

        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
                "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // 3. Kiểm tra phương thức in danh sách (Print)
        cart.print();

        // 4. Kiểm tra các phương thức tìm kiếm (Search)
        
        // Test tìm kiếm theo ID
        System.out.println("\n--- Testing Search by ID ---");
        cart.searchById(1); // Tìm ID có thật
        cart.searchById(10); // Tìm ID không tồn tại


        System.out.println("\n--- Testing Search by Title ---");
        cart.searchByTitle("Star Wars"); // Khớp hoàn toàn
        cart.searchByTitle("Lion");      // Khớp một phần
        cart.searchByTitle("Titanic");   // Không tồn tại
    }
}
