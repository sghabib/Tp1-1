import java.io.BufferedReader;
import outilsjava.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class Facture {
	
	private BufferedReader ficSource;
	private String[] texte;
	private Clients[] tabClients;
	private Plat[] tabPlats;
	private Commandes[] tabCommandes;
	private int j=0;
	private int k=0;
	private int l=0;
	
	public Facture(String nomFichier){
					
		
		
	}
	
		
		
	public void lireFacture(){
	for(int i=0;i<texte.length;++i){
		if(texte[i].equalsIgnoreCase("Clients :")){
		while(texte[i]!="Plats :"){
				++i;
				Clients clientTemp =  new Clients(texte[i]);
				tabClients[j]= clientTemp;
				++j;
		}		

		while(texte[i]!="Commandes :"){
				++i;
				String[] textePlat = texte[i].split(" ");
				Plat platTemp = new Plat(textePlat[0],Integer.parseInt(textePlat[1]));
				tabPlats[k]= platTemp;
				++k;
			}
		while(texte[i]!="Fin"){
			++i;
			String[] texteCommandes = texte[i].split(" ");
			Commandes commandesTemp = new Commandes(texteCommandes[0],texteCommandes[1],Integer.parseInt(texteCommandes[2]));
			tabCommandes[l]= commandesTemp;
			++l;
		}
			
	}
	}
	}

}
