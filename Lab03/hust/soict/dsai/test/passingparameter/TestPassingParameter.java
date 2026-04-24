package hust.soict.dsai.test.passingparameter; 
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // Gọi hàm swap mới
        swap(jungleDVD, cinderellaDVD);
        
        System.out.println("After swap - jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("After swap - cinderella dvd title: " + cinderellaDVD.getTitle());
    }

    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String tmpTitle = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tmpTitle);

    }
}
