public class CV {
	
	private String nom, prenom, formation;
	private int xp;
	private String[] compt;
	private String attentes;

	
		public static void main(String[] args) {
			
			System.out.println("Bienvenue chez Barette!");
			
			CV cv1 = new CV("Roy", "Luc", "Informatique", 10, "Aucune" );
			
			affiche(cv1);
			
			CV cv2 = new CV("Roy", "Luc", "Informatique", 10, "Aucune" );
			
			affiche(cv2);
			
	}
}
