package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;
	private boolean vainqueur = false;

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

//	public void recevoirCoup(int forceCoup) {
//		assert force > 0;
//		int forcedebut = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert forcedebut > force;
//	}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		if (forceCoup > 0) {
			force -= forceCoup;
			if (force > 0) {
				parler("Aïe");

			} else {
				equipementEjecte = ejecterEquipement();
				parler("J'abandonne...");
			}
			// post condition la force a diminuée
			assert force < oldForce;
		} else {
			vainqueur = true;
			parler("Je suis le vainqueur !");
		}
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grâce à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipement[i] != null && equipement[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipement[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipement[i];
				nbEquipementEjecte++;
				equipement[i] = null;
			}
		}

		return equipementEjecte;
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
			} else {
				extracted(equipement);
			}
			break;
		}
		default:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			;
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

	public int getForce() {
		return force;
	}

	public boolean getVainqueur() {
		return vainqueur;
	}
}
