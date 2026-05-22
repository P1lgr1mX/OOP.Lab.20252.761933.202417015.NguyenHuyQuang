package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparator {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
        Comparator.comparing(Media::getTitle, String.CASE_INSENSITIVE_ORDER)
                   .thenComparing(Media::getCost);

    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
        Comparator.comparing(Media::getCost)
                   .thenComparing(Media::getTitle, String.CASE_INSENSITIVE_ORDER);
}