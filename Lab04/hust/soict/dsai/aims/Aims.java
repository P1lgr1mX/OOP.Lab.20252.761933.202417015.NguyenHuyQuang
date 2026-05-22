package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private Store store = new Store();
    private Cart cart = new Cart();
    private Scanner scanner = new Scanner(System.in);

    public Aims() {
        initializeStore();
    }

    private void initializeStore() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Matrix", "Sci-Fi", "Wachowski", 136, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Inception", "Sci-Fi", "Nolan", 148, 24.99f);
        Book book1 = new Book(3, "Clean Code", "Programming", 45.00f);
        book1.addAuthor("Robert C. Martin");
        Book book2 = new Book(4, "Design Patterns", "Programming", 55.00f);
        book2.addAuthor("Erich Gamma");
        CompactDisc cd1 = new CompactDisc(5, "Greatest Hits", "Music", 15.99f, "Various Artists", "Various");
        cd1.addTrack(new Track("Song 1", 180));
        cd1.addTrack(new Track("Song 2", 240));
        CompactDisc cd2 = new CompactDisc(6, "Jazz Collection", "Music", 19.99f, "Jazz Artists", "Jazz Director");
        cd2.addTrack(new Track("Jazz Track 1", 300));
        cd2.addTrack(new Track("Jazz Track 2", 360));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(cd1);
        store.addMedia(cd2);
    }

    public static void main(String[] args) {
        Aims aims = new Aims();
        aims.showMenu();
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nAIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public void viewStore() {
        while (true) {
            System.out.println("\nStore Items:");
            System.out.println("--------------------------------");
            for (Media media : store.getAllMedia()) {
                System.out.println(media.toString());
            }
            System.out.println("--------------------------------");

            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public void seeMediaDetails() {
        System.out.println("Enter media title: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media not found!");
            return;
        }

        System.out.println("\n" + media.toString());

        mediaDetailsMenu(media);
    }

    public void mediaDetailsMenu(Media media) {
        while (true) {
            System.out.println("\nOptions: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            if (media instanceof DigitalVideoDisc || media instanceof CompactDisc) {
                System.out.println("2. Play");
            }
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1" + ((media instanceof DigitalVideoDisc || media instanceof CompactDisc) ? "-2" : ""));

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof DigitalVideoDisc || media instanceof CompactDisc) {
                        ((Playable) media).play();
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
            if (choice == 0 || choice == 1 || (choice == 2 && (media instanceof DigitalVideoDisc || media instanceof CompactDisc))) {
                break;
            }
        }
    }

    public void addMediaToCart() {
        System.out.println("Enter media title: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media not found!");
            return;
        }

        cart.addMedia(media);
    }

    public void playMedia() {
        System.out.println("Enter media title: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media not found!");
            return;
        }

        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played!");
        }
    }

    public void updateStore() {
        while (true) {
            System.out.println("\nUpdate Store:");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media to store");
            System.out.println("2. Remove a media from store");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMediaToStore();
                    break;
                case 2:
                    removeMediaFromStore();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public void addMediaToStore() {
        System.out.println("Enter media type (DVD/Book/CD): ");
        String type = scanner.nextLine();

        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter title: ");
        String title = scanner.nextLine();

        System.out.println("Enter category: ");
        String category = scanner.nextLine();

        System.out.println("Enter cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();

        Media media = null;

        switch (type.toUpperCase()) {
            case "DVD":
                System.out.println("Enter director: ");
                String director = scanner.nextLine();
                System.out.println("Enter length: ");
                int length = scanner.nextInt();
                scanner.nextLine();
                media = new DigitalVideoDisc(id, title, category, director, length, cost);
                break;
            case "BOOK":
                media = new Book(id, title, category, cost);
                System.out.println("Enter number of authors: ");
                int numAuthors = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < numAuthors; i++) {
                    System.out.println("Enter author name: ");
                    String author = scanner.nextLine();
                    ((Book) media).addAuthor(author);
                }
                break;
            case "CD":
                System.out.println("Enter artist: ");
                String artist = scanner.nextLine();
                System.out.println("Enter director: ");
                String cdDirector = scanner.nextLine();
                media = new CompactDisc(id, title, category, cost, artist, cdDirector);
                break;
            default:
                System.out.println("Invalid media type!");
                return;
        }

        store.addMedia(media);
    }

    public void removeMediaFromStore() {
        System.out.println("Enter media title to remove: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media not found!");
            return;
        }

        store.removeMedia(media);
    }

    public void seeCurrentCart() {
        while (true) {
            System.out.println("\nCurrent Cart:");
            System.out.println("--------------------------------");
            for (Media media : cart.getItemsOrdered()) {
                System.out.println(media.toString());
            }
            System.out.println("--------------------------------");
            System.out.println("Total cost: " + cart.totalCost() + " $");
            System.out.println("Number of items: " + cart.getItemsOrdered().size());

            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    filterMedias();
                    break;
                case 2:
                    sortMedias();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaFromCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public void filterMedias() {
        System.out.println("\nFilter by:");
        System.out.println("1. By id");
        System.out.println("2. By title");
        System.out.println("--------------------------------");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter value: ");
        String value = scanner.nextLine();

        System.out.println("\nFiltered results:");
        System.out.println("--------------------------------");
        for (Media media : cart.getItemsOrdered()) {
            boolean match = false;
            if (choice == 1) {
                match = String.valueOf(media.getId()).equals(value);
            } else if (choice == 2) {
                match = media.getTitle().toLowerCase().contains(value.toLowerCase());
            }
            if (match) {
                System.out.println(media.toString());
            }
        }
    }

    public void sortMedias() {
        System.out.println("\nSort by:");
        System.out.println("1. By title (A-Z), then cost (high first)");
        System.out.println("2. By cost (high first), then title (A-Z)");
        System.out.println("--------------------------------");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            cart.sortByTitleCost();
        } else if (choice == 2) {
            cart.sortByCostTitle();
        }
        System.out.println("Sorted successfully!");
    }

    public void removeMediaFromCart() {
        System.out.println("Enter media title to remove: ");
        String title = scanner.nextLine();

        Media mediaToRemove = null;
        for (Media media : cart.getItemsOrdered()) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                mediaToRemove = media;
                break;
            }
        }

        if (mediaToRemove == null) {
            System.out.println("Media not found in cart!");
            return;
        }

        cart.removeMedia(mediaToRemove);
    }

    public void playMediaFromCart() {
        System.out.println("Enter media title to play: ");
        String title = scanner.nextLine();

        Media mediaToPlay = null;
        for (Media media : cart.getItemsOrdered()) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                mediaToPlay = media;
                break;
            }
        }

        if (mediaToPlay == null) {
            System.out.println("Media not found in cart!");
            return;
        }

        if (mediaToPlay instanceof Playable) {
            ((Playable) mediaToPlay).play();
        } else {
            System.out.println("This media cannot be played!");
        }
    }

    public void placeOrder() {
        System.out.println("Order is created!");
        cart.getItemsOrdered().clear();
        System.out.println("Cart is now empty.");
    }
}