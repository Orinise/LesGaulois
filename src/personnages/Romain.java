package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		super();
		this.nom = nom;
		assert force > 0;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}

	public String prendreParole() {
		return "Le romaine " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert force > 0;
		int forcedebut = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert forcedebut > force;
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
	}
}
