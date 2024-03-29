package personnages;

public class Musee {
	private Trophee[] trophee = new Trophee[100];
	private int nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophee[nbTrophee] = new Trophee(gaulois, equipement);
		nbTrophee++;
	}

	public String extraireInstructionOCaml() {
		String texte;
		texte = "let musee = [\n";
		for (Trophee trophee2 : trophee) {
			if (trophee2 != null) {
				texte += "\t\"" + trophee2.donnerNom() + "\", \"" + trophee2.getEquipement() + "\";\n";
			}
		}
		texte += "]";
		return texte;
	}

	public static void main(String[] args) {
		
		// test des fonctions faireDonation, donnerTrophees et extraireInstructionOCaml
		Romain minus = new Romain("Minus",1);
		Musee musee = new Musee();
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		Gaulois asterix = new Gaulois("Astérix",100);
		do {
			asterix.frapper(minus);
			
		} while (minus.getForce() > 0);
		asterix.faireDonation(musee);
		System.out.println(musee.extraireInstructionOCaml());
	}
}
