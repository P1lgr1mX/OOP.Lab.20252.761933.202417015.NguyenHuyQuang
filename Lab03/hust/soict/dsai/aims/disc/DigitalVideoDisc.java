package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0;
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;



    // 1. Giữ hàm isMatch của nhánh Search
    public boolean isMatch(String title) {
        if (this.title == null || title == null) return false;
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

    // 2. Giữ hàm toString của nhánh Main
    @Override
    public String toString() {
        return "DVD - " + title + " - " + (category != null ? category : "N/A") + 
               " - " + (director != null ? director : "N/A") + 
               " - " + length + ": " + cost + " $";
    }

    // 3. Giữ đầy đủ Getters/Setters để không lỗi logic hệ thống
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }
    
    public void setTitle(String title) { this.title = title; }
}