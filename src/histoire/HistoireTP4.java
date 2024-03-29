package histoire;

import personnages.*;

public class HistoireTP4 {
	public static void main(String[] args) {
		Humain prof = new Humain("Prof", 54, "Kombucha");
		prof.direBonjour();
		prof.acheterBien("une boisson", 12);
		prof.boire();
		prof.acheterBien("un kimono", 50);
		
		Commercant marco = new Commercant("Marco", 20);
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoirArgent(15);
		marco.boire();
		
		Yakuza yaku = new Yakuza("Yuka le noir", 30, "whisky", "Warsong");
		yaku.direBonjour();
		yaku.extorquer(marco);
		
		
		Ronin roro = new Ronin("Roro", 60, "shochu");
		roro.direBonjour();
		roro.donner(marco);
		
		roro.provoquer(yaku);
		
		}
	
		
}
