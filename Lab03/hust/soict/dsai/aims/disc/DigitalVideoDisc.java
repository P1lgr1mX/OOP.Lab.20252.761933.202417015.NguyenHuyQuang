package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    
    private static int nbDigitalVideoDiscs = 0;
    private int id;

    // Constructor 1 tham số
    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor 3 tham số (Để sửa lỗi cho dvd3)
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor đầy đủ (Để sửa lỗi cho dvd1, dvd2)
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Phương thức kiểm tra tiêu đề khớp
    public boolean isMatch(String title) {
        if (this.title == null) return false;
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
    }

    // Getters cần thiết cho class khác package
    public String getTitle() { return title; }
    public float getCost() { return cost; }
    public int getId() { return id; }
}
