package controleur.selecteur;

import java.util.ArrayList;
import java.util.List;

import modele.Espace;

public class SelecteurNouvellesParMotsCles extends MixeurDonnees {

    private List<String> motsCles;

    public SelecteurNouvellesParMotsCles(List<Espace> nouvelles, List<String> motsCles) {
        super(nouvelles);
        this.motsCles = motsCles;
    }

   
    
    @Override
    public void filtrer() {

        nouvellesFiltrees = new ArrayList<Espace>();

      
        for (Espace e : nouvellesOriginales) {

            boolean contientMotCles = false;

            for (String mot : motsCles) {

                if (e.getTitle() != null && e.getTitle().toLowerCase().contains(mot.toLowerCase())) {
                    contientMotCles = true;
                }

                if (e.getDescription() != null && e.getDescription().toLowerCase().contains(mot.toLowerCase())) {
                    contientMotCles = true;
                }
            }

            if (contientMotCles) {
                nouvellesFiltrees.add(e);
            }
        }
    }

    @Override
    public void trier() {
       
    }

    
    public static final String ROUGE = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    @Override
    public void transformer() {

        for (Espace e : nouvellesFiltrees) {

            String texte = e.getDescription();

            if (texte == null) continue;

            for (String mot : motsCles) {

                String motRouge = ROUGE + mot + RESET;

                texte = texte.replace(mot, motRouge);
                texte = texte.replace(mot.toLowerCase(), motRouge);
                texte = texte.replace(mot.toUpperCase(), motRouge);
            }

            e.setDescription(texte);
        }
    }

}
