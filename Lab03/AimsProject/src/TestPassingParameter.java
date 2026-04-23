public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // Thử swap - Sẽ thất bại vì Java chỉ copy tham chiếu vào biến cục bộ
        swap(jungleDVD, cinderellaDVD);
        System.out.println("After swap - jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("After swap - cinderella dvd title: " + cinderellaDVD.getTitle());

        // Thử changeTitle - Sẽ thành công vì tác động trực tiếp vào nội dung đối tượng
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("After changeTitle - jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        // Lệnh dưới này tạo object mới cho biến cục bộ 'dvd', không ảnh hưởng main
        dvd = new DigitalVideoDisc(oldTitle); 
    }
}
