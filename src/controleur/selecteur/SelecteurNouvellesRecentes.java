package controleur.selecteur;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    	for (Espace espace : nouvellesOriginales) {
    	    try {
    	        LocalDateTime d = LocalDateTime.parse(espace.getPubDate(), RSS_FORMAT);
    	        if (d.isAfter(limite)) {
    	            nouvellesFiltrees.add(espace);
    	        }
    	    } catch (Exception ex) { }
    	}

    }

    @Override
    public void trier() {
        Comparator<Espace> comparateur = new ComparateurNouvelleParDate();
        Collections.sort(nouvellesFiltrees, comparateur);
    }


    @Override
    public void transformer() {
        
    }
}
