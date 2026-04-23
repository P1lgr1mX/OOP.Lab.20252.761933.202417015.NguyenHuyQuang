public class Aims {
    public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // Print total cost of the items in the cart
        System.out.print("Total Cost is: ");
        System.out.println(anOrder.totalCost());

	// --- Test Removing items from the cart ---
        // Thử xóa đĩa dvd2 (Star Wars)
        anOrder.removeDigitalVideoDisc(dvd2);
        
        // In lại tổng tiền sau khi xóa để kiểm tra
        System.out.print("Total Cost after removing one disc is: ");
        System.out.println(anOrder.totalCost());
        
        // Thử xóa một đĩa không có trong giỏ (ví dụ tạo mới một đĩa chưa add)
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Cinderella");
        anOrder.removeDigitalVideoDisc(dvd4);
    }
}
