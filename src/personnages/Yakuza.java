package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, int argent, String boisson, String clan) {
		super(nom, argent, boisson);
		this.clan = clan;
	}

	public int getReputation() {
		return reputation;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler("Marco, si tu tiens à la vie donne moi ta bourse !");
		int extorque = victime.seFaireExtorquer();
		gagnerArgent(extorque);
		parler("J’ai piqué les " + extorque + " sous de " + victime.getNom() + ", ce qui me fait 45 sous dans ma\n"
				+ "poche. Hi ! Hi !");
		reputation += 1;
	}

	public int perdre() {
		int perte = argent;
		argent = 0;

		reputation -= 1;

		parler("J’ai perdu mon duel et mes " + perte + " sous, snif... J'ai déshonoré le clan de\n"
				+ clan + ".");

		return perte;
	}

	public void gagner(int gain) {
		argent += gain;

		reputation += 1;

		parler("Ce ronin pensait vraiment battre " + nom + " du clan de " + clan + "?\n"
				+ "Je l'ai dépouillé de ses " + gain + " sous.");
	}
}
