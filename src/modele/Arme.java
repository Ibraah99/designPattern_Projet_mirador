package modele;

public class Arme {
	   private int id;
	    private String nom;
	    private String type;
	    private String paysOrigine;
	    private int annee;
	    private String calibre;
	    private int capaciteChargeur;
	    private double poidsKg;
	    
	    
	    
	    
		public Arme() {
			super();
		}
		public Arme( String nom, String type, String paysOrigine, int annee, String calibre,
				int capaciteChargeur, double poidsKg) {
		
	
			this.nom = nom;
			this.type = type;
			this.paysOrigine = paysOrigine;
			this.annee = annee;
			this.calibre = calibre;
			this.capaciteChargeur = capaciteChargeur;
			this.poidsKg = poidsKg;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getPaysOrigine() {
			return paysOrigine;
		}
		public void setPaysOrigine(String paysOrigine) {
			this.paysOrigine = paysOrigine;
		}
		public int getAnnee() {
			return annee;
		}
		public void setAnnee(int annee) {
			this.annee = annee;
		}
		public String getCalibre() {
			return calibre;
		}
		public void setCalibre(String calibre) {
			this.calibre = calibre;
		}
		public int getCapaciteChargeur() {
			return capaciteChargeur;
		}
		public void setCapaciteChargeur(int capaciteChargeur) {
			this.capaciteChargeur = capaciteChargeur;
		}
		public double getPoidsKg() {
			return poidsKg;
		}
		public void setPoidsKg(double poidsKg) {
			this.poidsKg = poidsKg;
		}
	    
	    

}
