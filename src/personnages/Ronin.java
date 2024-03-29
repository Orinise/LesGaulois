package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, int argent, String boisson) {
		super(nom, argent, boisson);

	}

	public void donner(Commercant beneficiaire) {
		int don = argent / 10;
		parler(beneficiaire.getNom() + "prends ces " + don + " sous");
		beneficiaire.recevoirArgent(don);
		perdreArgent(don);
	}

	public void provoquer(Yakuza adversaire) {
		int force = 2 * honneur;
		
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre\n"
				+ "marchand!");
		
		if (force >= adversaire.getReputation()) {
			parler("Je t’ai eu petit yakusa!");
			int gain = adversaire.perdre();
			argent += gain;
			honneur += 1;
		} else {
			honneur -= 1;
			adversaire.gagner(argent);
			argent = 0;
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
		}
	}
}
