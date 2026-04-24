package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0;
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // ... (Giữ nguyên các Constructor của bạn ở trên) ...

    // --- PHẦN KẾT HỢP SAU KHI FIX CONFLICT ---

    @Override
    public String toString() {
        return "DVD - " + title + " - " + (category != null ? category : "N/A") + 
               " - " + (director != null ? director : "N/A") + 
               " - " + length + ": " + cost + " $";
    }

    // Giữ đầy đủ Getters để các lớp khác (Cart, Store) không bị lỗi
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }
    
    // Setter cho title phục vụ bài test
    public void setTitle(String title) { this.title = title; }
}
