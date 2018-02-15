import java.text.DecimalFormat;

public class Facture {

	public void affichage( Commandes[] cmd, Plat[] platTableau, Clients[] clients ) {

		int qte = 0;
		double prix = 0;
		double total;

		DecimalFormat df = new DecimalFormat( "#0.00" );

		System.out.println( "Bienvenue chez Barette!\nFactures:" );

		for ( int i = 0; i < clients.length; i++ ) {

			String clientTemp = clients[i].getNomClient();

			total = 0.00;

			for ( int y = 0; y < cmd.length; y++ ) {

				if ( cmd[y].getNomClient().equalsIgnoreCase( clientTemp )) {

					qte = cmd[y].getQuantité();

					String nomRepas = cmd[y].getNomRepas();

					Boolean trouver = false;

					for ( int x = 0; x < platTableau.length || trouver; x++ ) {

						if ( platTableau[x].getNom().equalsIgnoreCase( nomRepas )  ) {
							prix = platTableau[x].getPrix();
							trouver = true;

						}

					}
				}

				total += qte * prix;

			}

			System.out.println( "clientTemp " + df.format( total ) + "$" );

		}

	}

}
