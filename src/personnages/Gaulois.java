package personnages;


public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}

//
//	public String prendreParole() {
//		return "Le Gaulois " + nom + " : ";
//	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup(force * effetPotion / 3);
//	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophee = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophee != null && i < trophee.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophee[i];
		}
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";

	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		System.out.println("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée");
	}

	public void faireDonation(Musee musee) {
		if (nbTrophees > 0) {
			parler("Je donne au musée tous mes trophées : ");
			for (int i = 0; i < nbTrophees; i++){
				System.out.println("- " + trophees[i]);
				musee.donnerTrophees(this, trophees[i]);
				trophees[i] = null;
			}
			
				
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain romain = new Romain("romain", 8);
		System.out.println(asterix);
		asterix.boirePotion(3);
//		asterix.parler("ceci est un test");
		asterix.frapper(romain);
//		romain.parler("Je vais te tuer !");

	}
}
