
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
		System.arraycopy(this.comp, 0, comp, 0, comp.length);
		this.attente= attente;
		
	}

public void afficher(CV cvTemp){
	String temp="";
	for(int i=0;i<cvTemp.comp.length;++i){
		temp+=this.comp[i] + ", ";
	}
	System.out.println("Nom: " + cvTemp.nom + "\nPrénom: " + cvTemp.prénom + "\nFormation: " + cvTemp.formation + "\nAnnées d'expériences: " + cvTemp.xp + "\nCompétences: " + temp + "\nAttentes: " + cvTemp.attente );
}
	
}

	
	
	
