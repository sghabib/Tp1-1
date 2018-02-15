
public class Commandes {

	private String nomClient;
	private String nomRepas;
	private double quantité;
	
	public Commandes(){
		this.nomClient="";
		this.nomRepas="";
		this.quantité=0;
	}
	
	public Commandes(String nomClient, String nomRepas, double quantité){
		this.nomClient=nomClient;
		this.nomRepas=nomRepas;
		this.quantité=quantité;
	}
	
	public String getNomClient(){
		return this.nomClient;
	}
	
	public String getNomRepas(){
		return this.nomRepas;
	}
	
	public double getQuantité(){
		return this.quantité;
	}
}
