
public class Commandes {

	private String nomClient;
	private String nomRepas;
	private int quantité;
	
	public Commandes(){
		this.nomClient="";
		this.nomRepas="";
		this.quantité=0;
	}
	
	public Commandes(String nomClient, String nomRepas, int quantité){
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
	
	public int getQuantité(){
		return this.quantité;
	}
}
