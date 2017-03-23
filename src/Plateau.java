//package Exo1;

public class Plateau {
	
	public static final int COLONNES = 7;
	public static final int RANGEES = 6;
	
	private int[][] grille;
	private int joueurCourant;
	private static final int ANNE = 1;
	private static final int LUCIE = 2;
	private static final int NIVEAUMAX = 2;

	double di = 0;
	double dj = 0;

	public Plateau() {
		grille = new int[RANGEES][COLONNES];
		initialiser();
		joueurCourant = ANNE;
	}

	public void setDi(double di) {
		this.di = di;
	}

	public void setDj(double dj) {
		this.dj = dj;
	}

	public int getRow(int y) {
		return (int) ((y - 170) / di);
	}

	public int getCol(int x) {
		return (int) ((x) / dj);
	}

	public int getPion(int i, int j) {
		return grille[i][j];
	}

	public void getjoueurCourant() {
		if (joueurCourant == 1) {
			System.out.print("Le joueur courant est ANNE");
		} else {
			System.out.print("Le joueur courant est LUCIE");
		}
	}

	private void initialiser() {
		for (int i = 0; i < RANGEES; i++) {
			for (int j = 0; j < COLONNES; j++) {
				grille[i][j] = 0;
			}
		}
	}

	void imprime() {
		for (int i = 0; i < RANGEES; i++) {
			for (int j = 0; j < COLONNES; j++) {
				System.out.print(grille[i][j]);
			}
			System.out.println("");
		}
	}

	// faire une exception si colonne pleine au lieu d'un message
	void joue(int i) {

		int j = 0;
		while (j < RANGEES && grille[j][i] == 0) {
			j++;
		}
		if (j == 0) {
			System.out.println("erreur colonne pleine");
		}
		else
		{
			if (joueurCourant == 1) {
				grille[j - 1][i] = 1;
				joueurCourant = 2;
			} else {
				grille[j - 1][i] = 2;
				joueurCourant = 1;
			}
		}
	}

	public Plateau copiePlateau(Plateau p) {
		Plateau p2 = new Plateau();
		p2.grille = p.grille;
		return p2;
	}

	public int evaluation(Plateau p) {
		if (p.gagne() == 1) {
			return (100000);
		} else if (p.gagne() == 2) {
			return (-100000);
		} else {
			return 0;
		}
	}

	public Plateau simulation(int i) {
		// si la colonne est pleine faire exception
		Plateau p2 = new Plateau();
		p2 = copiePlateau(this);
		p2.joue(i);
		return p2;
	}

	public int ami(Plateau p, int niveau) {
		int[] Listecoup = new int[7];
		Plateau p2 = new Plateau();
		p2 = copiePlateau(this);
		int eval;
		if (niveau == NIVEAUMAX) {
			eval = evaluation(p2.simulation(Listecoup[1]));
		} else {
		}
		return 0;
	}
	
	/**
	 * 
	 * @return le numéro du joueur qui a gagné, si personne n'a encore gagné renvoie -1
	 */
	public int gagne()
	{
		boolean isAligne;
		for(int i = 0; i < RANGEES; i++)
		{
			for(int j = 0; j < COLONNES; j++)
			{
				// Si la case n'est pas 0 c'est à dire qu'elle est occupée par un pion
				if(grille[i][j] != 0)
				{
					// On vérifie si le pion réalise un alignement
					isAligne = verifierAlignement(i, j);
					// Si c'est le cas, on renvoie le numéro du joueur
					if(isAligne)
					{
						return grille[i][j];
					}
				}
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @param i La rangée
	 * @param j La colonne
	 * @return Vrai si le pion à la position grille[i][j]est aligné, Faux sinon
	 */
	public boolean verifierAlignement(int i, int j)
	{
		// Alignement en ligne à droite
		if(j < (COLONNES - 3))
		{
			if( (grille[i][j] == grille[i][j+1]) && (grille[i][j] == grille[i][j+2]) && (grille[i][j] == grille[i][j+3]) )
			{
				return true;
			}
		}
		// Alignement à gauche
		if(j > 2)
		{
			if( (grille[i][j] == grille[i][j-1]) && (grille[i][j] == grille[i][j-2]) && (grille[i][j] == grille[i][j-3]) )
			{
				return true;
			}
		}
		// Alignement en bas
		if(i < (RANGEES - 3))
		{
			if( (grille[i][j] == grille[i+1][j]) && (grille[i][j] == grille[i+2][j]) && (grille[i][j] == grille[i+3][j]) )
			{
				return true;
			}
		}
		// Alignement en haut
		if(i > 2)
		{
			if( (grille[i][j] == grille[i-1][j]) && (grille[i][j] == grille[i-2][j]) && (grille[i][j] == grille[i-3][j]) )
			{
				return true;
			}
		}
		// Alignement en haut à gauche
		if( (i > 2) && (j > 2) )
		{
			if( (grille[i][j] == grille[i-1][j-1]) && (grille[i][j] == grille[i-2][j-2]) && (grille[i][j] == grille[i-3][j-3]) )
			{
				return true;
			}
		}
		// Alignement en haut à droite
		if( (i > 2) && (j < (COLONNES - 3)) )
		{
			if( (grille[i][j] == grille[i-1][j+1]) && (grille[i][j] == grille[i-2][j+2]) && (grille[i][j] == grille[i-3][j+3]) )
			{
				return true;
			}
		}
		// Alignement en bas à gauche
		if( (i < (RANGEES - 3)) && (j > 2) )
		{
			if( (grille[i][j] == grille[i+1][j-1]) && (grille[i][j] == grille[i+2][j-2]) && (grille[i][j] == grille[i+3][j-3]) )
			{
				return true;
			}
		}
		// Alignement en bas à droite
		if( (i < (RANGEES - 3)) && (j < (COLONNES - 3)) )
		{
			if( (grille[i][j] == grille[i+1][j+1]) && (grille[i][j] == grille[i+2][j+2]) && (grille[i][j] == grille[i+3][j+3]) )
			{
				return true;
			}
		}
		// Aucun alignement trouvé en ligne ou diagonale, on renvoie faux
		return false;
	}

}