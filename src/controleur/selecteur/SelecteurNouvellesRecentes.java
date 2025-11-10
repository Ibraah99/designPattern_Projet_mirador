package controleur.selecteur;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import modele.Espace;

public class SelecteurNouvellesRecentes extends MixeurDonnees {

    private int jours = 3;
    private static final DateTimeFormatter RSS_FORMAT = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);

    public SelecteurNouvellesRecentes(List<Espace> nouvelles) {
        super(nouvelles);
        
    }

    @Override
    public void filtrer() {

    	nouvellesFiltrees = new ArrayList<>();

    	LocalDateTime limite = LocalDateTime.now().minusDays(jours);

    	for (Espace e : nouvellesOriginales) {
    	    try {
    	        LocalDateTime d = LocalDateTime.parse(e.getPubDate(), RSS_FORMAT);
    	        if (d.isAfter(limite)) {
    	            nouvellesFiltrees.add(e);
    	        }
    	    } catch (Exception ex) { }
    	}

    }

    @Override
    public void trier() {
        // Ici on veut trier les nouvelles du plus récent au plus ancien.
        // On va utiliser Collections.sort avec un Comparateur simple.

        Collections.sort(nouvellesFiltrees, new java.util.Comparator<Espace>() {
            @Override
            public int compare(Espace a, Espace b) {
                // On compare les dates sous forme de texte.
                // Attention : ce n'est pas la méthode la plus précise,
                // mais pour un débutant ça fonctionne si le format est toujours identique.

                String dateA = a.getPubDate();
                String dateB = b.getPubDate();

                // On met B avant A si B est "plus grand" (plus récent)
                return dateB.compareTo(dateA);
            }
        });
    }


    @Override
    public void transformer() {
        // Rien à transformer pour l'instant
    }
}
