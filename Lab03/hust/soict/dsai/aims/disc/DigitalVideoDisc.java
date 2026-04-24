package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    // Biến static: Dùng chung cho cả lớp để đếm tổng số đĩa đã tạo
    private static int nbDigitalVideoDiscs = 0;
    
    // Biến instance: ID riêng biệt cho từng đối tượng
    private int id;
    
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // --- CONSTRUCTORS ---
    // Tất cả các constructor đều phải tăng nbDigitalVideoDiscs và gán id

    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // --- GETTERS & SETTERS ---

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // Cần thêm Setter cho title để phục vụ bài Pass-by-value lúc nãy
    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }
}
