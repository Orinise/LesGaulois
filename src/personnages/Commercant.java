package personnages;

public class Commercant extends Humain{

	public Commercant(String nom, int argent) {
		super(nom, argent, "thé");
	}
	
	public int seFaireExtorquer() {
		int extorquer = argent;
		argent = 0;
		parler("J'ai tout perdu! Le monde est trop injuste...");
		return extorquer;
	}
	
	public void recevoirArgent(int argent) {
		gagnerArgent(argent);
		parler(argent + " sous! Je te remercie généreux donateur");
	}
	
}
