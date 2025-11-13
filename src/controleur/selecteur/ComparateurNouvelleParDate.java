package controleur.selecteur;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Locale;

import modele.Espace;

public class ComparateurNouvelleParDate implements Comparator<Espace> {

    private static final DateTimeFormatter RSS_FORMAT = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);

    @Override
    public int compare(Espace a, Espace b) {
        try {
            ZonedDateTime dateA = ZonedDateTime.parse(a.getPubDate(), RSS_FORMAT);
            ZonedDateTime dateB = ZonedDateTime.parse(b.getPubDate(), RSS_FORMAT);

            return dateA.compareTo(dateB);  //ancien au recent
        } catch (Exception e) {
            return 0;
        }
    }
}
