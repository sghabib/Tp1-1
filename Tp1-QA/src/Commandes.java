
public class Commandes {

	private String nomClient;
	private String nomPlat;
	private int quantité;
	
	public Commandes(){
		this.nomClient="";
		this.nomPlat="";
		this.quantité=0;
	}
	
	public Commandes (String nomClient, String nomPlat, int quantité){
		this.nomClient=nomClient;
		this.nomPlat=nomPlat;
		this.quantité=quantité;
	}
	
	public String getNomClient(){
		return this.nomClient;
	}
	
	public String getNomPlat(){
		return this.nomPlat;
	}
	
	public int getQuantité(){
		return this.quantité;
	}
}
