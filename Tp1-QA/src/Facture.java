import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import outilsjava.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Facture {
	
	private BufferedReader ficSource;
	private String[] texte;
	private Clients[] tabClients;
	private Plat[] tabPlats;
	private Commandes[] tabCommandes;
	private int j=0;
	private int k=0;
	private int l=0;
	private int compteurC=0;
	private int compteurP=0;
	private int compteurCommandes=0;
	private Clients clientTemp;
	private String[] textePlat;
	private String[] texteCommandes;
	
	public Facture(String nomFichier){

		try {
			texte=lectureFichier(nomFichier);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<texte.length;++i){
			System.out.println(texte[i]);
		}
		int i=0;
			if(texte[i].equalsIgnoreCase("Clients:")){
			while(!texte[i].equalsIgnoreCase("Plats:")){
					++i;
					compteurC++;
			}		

			while(!texte[i].equalsIgnoreCase("Commandes:")){
					++i;
					compteurP++;
				}
			while(!texte[i].equalsIgnoreCase("Fin")){
				++i;
				compteurCommandes++;
			}
				
		}
		
		tabClients= new Clients[compteurC];
		tabPlats = new Plat[compteurP];
		tabCommandes = new Commandes[compteurCommandes];
	}
	
		
		
	public void lireFacture(){
		int i=0;
		if(texte[i].equalsIgnoreCase("Clients:")){
			++i;
		while(!texte[i].equalsIgnoreCase("Plats:")){				
				clientTemp =  new Clients(texte[i]);
				tabClients[j]= clientTemp;
				++i;
				++j;
		}		
			++i;
		while(!texte[i].equalsIgnoreCase("Commandes:")){
				
				textePlat = texte[i].split("\\s+");
				Plat platTemp = new Plat(textePlat[0],Double.parseDouble(textePlat[1]));
				tabPlats[k]= platTemp;
				++i;
				++k;
			}
			++i;
		while(!texte[i].equalsIgnoreCase("Fin")){
			
			texteCommandes = texte[i].split("\\s+");
			Commandes commandesTemp = new Commandes(texteCommandes[0],texteCommandes[1],Double.parseDouble(texteCommandes[2]));
			tabCommandes[l]= commandesTemp;
			++i;
			++l;
		}
			
	}

	}

	Plat[] platTableau = new Plat[10];

	
	public void affichage(Commandes[] cmd){
		
	String clientTemp;
	String nomRepas;
	double qte;
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
	
	private String[] lectureFichier(String nomFichier) throws IOException{
		
		FileReader fileReader;
			fileReader = new FileReader(nomFichier);
	
        
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
         

			while ((line = bufferedReader.readLine()) != null) 

			    lines.add(line);

         
        bufferedReader.close();
         
        return lines.toArray(new String[lines.size()]);
	}

}
