public class CartTest {
    public static void main(String[] args) {
        // 1. Tạo giỏ hàng
        Cart cart = new Cart();

        // 2. Tạo DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // 3. Thêm vào giỏ
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        // 4. Test hàm print
        cart.print();

        // 5. Test hàm search
        System.out.println("\n--- Testing Search ---");
        // Theo ID
        cart.searchById(1); 
        cart.searchById(10); // Không tồn tại
        
        // Theo Title
        cart.searchByTitle("Star Wars");
        cart.searchByTitle("lion"); // Tìm kiếm linh hoạt
    }
}
