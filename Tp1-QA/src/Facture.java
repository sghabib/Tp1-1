import java.text.DecimalFormat;
import java.io.BufferedReader;
import outilsjava.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.IOException;
import java.io.InputStreamReader;

public class Facture {

	private BufferedReader ficSource;
	private String[] texte;
	private Clients[] tabClients;
	private Plat[] tabPlats;
	private Commandes[] tabCommandes;
	private int j = 0;
	private int k = 0;
	private int l = 0;
	private Clients clientTemp;
	private String[] textePlat;
	private String[] texteCommandes;
	private DecimalFormat df = new DecimalFormat( "#0.00" );

	public Facture( String nomFichier ) {

		String ligne;
		int i = 0;
		ficSource = OutilsFichier.ouvrirFicTexteLecture( nomFichier );
		try {
			while ( ( ligne = ficSource.readLine() ) != null ) {
				texte[i] = ligne;
				++i;
			}
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void lireFacture() {
		for ( int i = 0; i < texte.length; ++i ) {
			if ( texte[i].equalsIgnoreCase( "Clients:" ) ) {
				while ( texte[i] != "Plats :" ) {
					++i;
					clientTemp = new Clients( texte[i] );
					tabClients[j] = clientTemp;
					++j;
				}

				while ( texte[i] != "Commandes:" ) {
					++i;
					textePlat = texte[i].split( " " );
					Plat platTemp = new Plat( textePlat[0], Integer.parseInt( textePlat[1] ) );
					tabPlats[k] = platTemp;
					++k;
				}
				while ( texte[i] != "Fin" ) {
					++i;
					texteCommandes = texte[i].split( " " );
					Commandes commandesTemp = new Commandes( texteCommandes[0], texteCommandes[1],
							Integer.parseInt( texteCommandes[2] ) );
					tabCommandes[l] = commandesTemp;
					++l;
				}

			}
		}
	}

	public void affichage() {

		int qte = 0;
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

}
