
public class Plat {

	private String nom;
	private double prix;
	
	public Plat(String x){
		this.nom = x;
		this.prix = 0;
	}
	
	public Plat(String x, double y){
		this.nom = x;
		this.prix = y;
	}
	public String getNom() {
		return nom;
	}


	public void setNom( String nom ) {
		this.nom = nom;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix( double prix ) {
		this.prix = prix;
	}



}
