package personnages;

import java.util.*;

public class Druide {
	private String nom;
	private int effetPotionMax;
	private int effetPotionMin;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMax, int effetPotionMin) {
		super();
		this.nom = nom;
		this.effetPotionMax = effetPotionMax;
		this.effetPotionMin = effetPotionMin;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public int getForcePotion() {
		return forcePotion;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}

	public String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public void preparerPotion() {
		Random random = new Random();
		while (forcePotion < effetPotionMin) {
			forcePotion = random.nextInt(effetPotionMax);
		}
		if (forcePotion > 7) {
			parler("J'ai préparé une super potion de force " + forcePotion);
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion);
		}
	}

	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Obélix") {
			System.out.println("Non Obélix, tu n'auras pas de potion magique !");
		} else {
			gaulois.boirePotion(forcePotion);

		}
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 10, 5);
		panoramix.preparerPotion();
	}
}
