import java.text.DecimalFormat;
import java.io.BufferedReader;
import java.io.FileReader;

import outilsjava.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


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
	private DecimalFormat df = new DecimalFormat( "#0.00" );
	
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



	public void affichage() {

		double qte = 0;
		double prix = 0;
		double total;

		System.out.println( "Bienvenue chez Barette!\nFactures:" );

		for ( int i = 0; i < tabClients.length; i++ ) {

			String tempClient = tabClients[i].getNomClient();

			total = 0.00;

			for ( int y = 0; y < tabCommandes.length; y++ ) {

				if ( tabCommandes[y].getNomClient().equalsIgnoreCase( tempClient ) ) {

					qte = tabCommandes[y].getQuantité();

					String nomRepas = tabCommandes[y].getNomRepas();

					Boolean trouver = false;

					for ( int x = 0; x < tabPlats.length || trouver; x++ ) {

						if ( tabPlats[x].getNom().equalsIgnoreCase( nomRepas ) ) {
							prix = tabPlats[x].getPrix();
							trouver = true;

						}

					}

				}

				total += qte * prix;

			}

			System.out.println( tempClient + " " + df.format( total ) + "$" );

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
