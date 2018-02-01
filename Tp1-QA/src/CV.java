
public class CV {

	private String nom;
	private String prénom;
	private String formation;
	private int xp;
	private String[] comp;
	private String attente;
	
public CV (String nom, String prénom, String formation, int xp, String[] comp, String attente){
		
		this.nom = nom;
		this.prénom = prénom;
		this.formation = formation;
		this.xp = xp;
		this.comp=comp;
		this.attente= attente;
		
	}

public void afficher(){
	String temp="";
	for(int i=0;i<this.comp.length;++i){
		temp+=this.comp[i] + ", ";
	}
	System.out.println("Nom: " + this.nom + "\nPrénom: " + this.prénom + "\nFormation: " + this.formation + "\nAnnées d'expériences: " + this.xp + "\nCompétences: " + temp + "\nAttentes: " + this.attente );
}
	
}


