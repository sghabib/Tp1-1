
public class main {

	public static void main(String[] args) {
		
		System.out.println("Bienvenue chez Barette!");
		
		String[] competence = {"Java", "C#"};
		
		CV cv1 = new CV("Roy", "Luc", "Informatique", 10, competence, "Aucune" );
		
		cv1.afficher();
		
		CV cv2 = new CV("Vaillancourt", "�tienne", "Informatique", 2, competence,"Apprendre � utiliser GitHub" );
		
		cv2.afficher();
		
		}

}
