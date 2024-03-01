package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;

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

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0: {
			extracted(equipement);
			break;
		}
		case 1: {
			if (this.equipement[0] == equipement) {
				System.out.println("Le soldat " + nom + " à déjà " + equipement);
			}else {
				extracted(equipement);
			}
			break;
		}
		default:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");;
		}
	}

	private void extracted(Equipement equipement) {
		this.equipement[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement);
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
}
