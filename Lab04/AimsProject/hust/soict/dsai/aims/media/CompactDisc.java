package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc() {}

    public CompactDisc(int id, String title, String category, float cost, String artist, String director) {
        super(id, title, category, cost, 0, director);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added: " + track.getTitle());
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    @Override
    public int getLength() {
        int total = 0;
        for (Track track : tracks) {
            total += track.getLength();
        }
        return total;
    }

    public String getArtist() { return artist; }
    public List<Track> getTracks() { return tracks; }

    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD artist: " + artist);
            System.out.println("CD length: " + this.getLength());
            for (Track track : tracks) {
                track.play();
            }
        } else {
            System.out.println("ERROR: CD length is 0 or less, cannot be played!");
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + artist + " - " + getDirector() + " - " + getLength() + " - " + getCost() + " $";
    }
}