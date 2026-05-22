package hust.soict.dsai.test.toString;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import java.util.ArrayList;

public class PolymorphismTest {
    public static void main(String[] args) {
        ArrayList<Media> mediaList = new ArrayList<Media>();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Matrix", "Sci-Fi", "Wachowski", 136, 19.99f);
        Book book1 = new Book(2, "Clean Code", "Programming", 45.00f);
        book1.addAuthor("Robert C. Martin");

        CompactDisc cd1 = new CompactDisc(3, "Greatest Hits", "Music", 15.99f, "Various Artists", "Various");
        cd1.addTrack(new Track("Song 1", 180));
        cd1.addTrack(new Track("Song 2", 240));

        mediaList.add(dvd1);
        mediaList.add(book1);
        mediaList.add(cd1);

        System.out.println("=== Polymorphism with toString() ===\n");
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }

        System.out.println("\n=== Explanation ===");
        System.out.println("Even though all objects are stored as Media type in the ArrayList,");
        System.out.println("when toString() is called, Java dynamically binds to the actual");
        System.out.println("class's implementation (Book, DVD, or CD) due to polymorphism.");
        System.out.println("Each subclass overrides toString() to provide its specific format.");
    }
}