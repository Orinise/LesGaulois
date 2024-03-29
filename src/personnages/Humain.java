package personnages;

public class Humain {
	protected String nom;
	protected int argent;
	protected String boisson;

	public Humain(String nom, int argent, String boisson) {
		this.nom = nom;
		this.argent = argent;
		this.boisson = boisson;
	}

	public int getArgent() {
		return argent;
	}

	public String getNom() {
		return nom;
	}

	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}

	public void direBonjour() {
		parler("Bonjour je m'appelle " + nom + " et j'aime boire du " + boisson);
	}

	public void boire() {
		parler("Mmmmmm, un bon verre de " + boisson + " ! GLOUPS !");
	}

	protected void gagnerArgent(int gain) {
		argent += gain;
	}

	protected void perdreArgent(int perte) {
		argent -= perte;
	}

	public void acheterBien(String bien, int prix) {
		if (argent >= prix) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'acheter " + bien + " à " + prix + " sous");
			perdreArgent(prix);
		} else {
			parler("Je n'ai que " + argent + " sous en poche. Je ne peux pas m'offrir " + bien + " à " + prix
					+ " sous");
		}

	}
}
