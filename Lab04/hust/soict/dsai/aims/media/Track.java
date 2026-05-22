package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track() {}

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            System.out.println("ERROR: Track length is 0 or less, cannot be played!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Track)) return false;
        Track other = (Track) obj;
        if (this.title == null || other.title == null) return false;
        return this.title.equalsIgnoreCase(other.title) && this.length == other.length;
    }

    @Override
    public int hashCode() {
        return title != null ? title.toLowerCase().hashCode() + length : length;
    }
}