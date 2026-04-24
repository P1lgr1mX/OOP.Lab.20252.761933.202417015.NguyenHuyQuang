package hust.soict.dsai.aims.disc; 

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private static int nbDigitalVideoDiscs = 0;
    private int id;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // --- CÁC PHƯƠNG THỨC BỔ SUNG ---

    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + (director != null ? director : "Unknown") 
               + " - " + length + " mins: " + cost + " $";
    }

    public boolean isMatch(String title) {
        if (this.title == null || title == null) return false;
        return this.title.toLowerCase().contains(title.toLowerCase());
    }


    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public float getCost() { return cost; }
    public int getId() { return id; }
}
