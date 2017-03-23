
public class Joueur {

	private String nom;
	private int number;
	private boolean isIA;
	
	public Joueur(String nom)
	{
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getInitiale()
	{
		return this.nom.substring(0, 1);
	}
}
