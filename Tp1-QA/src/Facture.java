import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Facture {

	Plat[] platTableau = new Plat[10];

	
	public void affichage(Commandes[] cmd){
		
	String clientTemp;
	String nomRepas;
	int qte;
	double prix = 0;
	double total;
	
	
	System.out.println("Bienvenue chez Barette!\nFactures:");
	
	
	for (int i = 0; i < cmd.length; i++){
		
		clientTemp = cmd[i].getNomClient();
		
		total= 0.00;
		
		for (int y = 0; y < cmd.length; y++){
			
			if (cmd[y].getNomClient() == clientTemp);
			
			qte=cmd[y].getQuantité();
			
			nomRepas=cmd[y].getNomRepas();
			
			Boolean trouver = false;
			
			for (int x = 0; x < cmd.length || trouver; x++){
				
				if (platTableau[x].getNom() == nomRepas){
					prix = platTableau[x].getPrix();
					trouver= true;
					
				}
				
			}
			
			total += qte*prix; 
			
		}
		
		
		System.out.println("clientTemp "+ total+"$");
		
	}
	
	
		
		
		
	}

}
