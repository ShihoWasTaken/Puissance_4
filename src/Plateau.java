//package Exo1;

public class Plateau {
	private int colonnes = 7;
	private int rangees = 6;
	private int[][] grille;
	private int JoueurCourant;
	private int Anne = 1;
	private int Lucie = 2;
	private int NIVEAUMAX = 2;

	double di = 0;
	double dj = 0;

	public Plateau() {
		grille = new int[rangees][colonnes];
		initialiser();
		JoueurCourant = Anne;
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

	public void getJoueurCourant() {
		if (JoueurCourant == 1) {
			System.out.print("Le joueur courant est Anne");
		} else {
			System.out.print("Le joueur courant est Lucie");
		}
	}

	private void initialiser() {
		for (int i = 0; i < rangees; i++) {
			for (int j = 0; j < colonnes; j++) {
				grille[i][j] = 0;
			}
		}
	}

	void imprime() {
		for (int i = 0; i < rangees; i++) {
			for (int j = 0; j < colonnes; j++) {
				System.out.print(grille[i][j]);
			}
			System.out.println("");
		}
	}

	// faire une exception si colonne pleine au lieu d'un message
	void joue(int i) {

		int j = 0;
		while (j < rangees && grille[j][i] == 0) {
			j++;
		}
		if (j == 0) {
			System.out.println("erreur colonne pleine");
		}
		// if(j==rangees){
		if (JoueurCourant == 1) {
			grille[j - 1][i] = 1;
			JoueurCourant = 2;
		} else {
			grille[j - 1][i] = 2;
			JoueurCourant = 1;
		}
		// }
		/*
		 * else { if(JoueurCourant==1){ grille[j][i]=1; JoueurCourant=2; } else{
		 * grille[j][i]=2; JoueurCourant=1; } }
		 */
	}

	int horizontale(int i, int j) {
		int compteurA = 0;
		int compteurL = 0;
		for (int k = j; k < j + 4; k++) {
			if (grille[i][k] == 0) {
				return 0;
			}
			if (grille[i][k] == 1) {
				compteurA = compteurA + 1;
			}
			if (grille[i][k] == 2) {
				compteurL = compteurL + 1;
			}
		}
		if (compteurA == 4) {
			return 1;
		} else if (compteurL == 4) {
			return 2;
		} else {
			return 0;
		}
	}

	int verticale(int i, int j) {
		int compteurA = 0;
		int compteurL = 0;
		for (int k = i; k < i + 4; k++) {
			if (grille[k][j] == 0) {
				return 0;
			}
			if (grille[k][j] == 1) {
				compteurA = compteurA + 1;
			}
			if (grille[k][j] == 2) {
				compteurL = compteurL + 1;
			}
		}
		if (compteurA == 4) {
			return 1;
		} else if (compteurL == 4) {
			return 2;
		} else {
			return 0;
		}
	}

	int diagonaleBas(int i, int j) {
		int compteurA = 0;
		int compteurL = 0;
		int g = j;
		for (int k = i; k < i + 4; k++) {
			while (g < j + 4)
				if (grille[k][g] == 0) {
					return 0;
				}
			if (grille[k][g] == 1) {
				compteurA = compteurA + 1;
			}
			if (grille[k][g] == 2) {
				compteurL = compteurL + 1;
			}
			g++;
		}
		if (compteurA == 4) {
			return 1;
		} else if (compteurL == 4) {
			return 2;
		} else {
			return 0;
		}
	}

	int diagonaleHaut(int i, int j) {
		int compteurA = 0;
		int compteurL = 0;
		int g = j;
		for (int k = i; k < i - 4; k--) {
			while (g < j + 4)
				if (grille[k][g] == 0) {
					return 0;
				}
			if (grille[k][g] == 1) {
				compteurA = compteurA + 1;
			}
			if (grille[k][g] == 2) {
				compteurL = compteurL + 1;
			}
			g++;
		}
		if (compteurA == 4) {
			return 1;
		} else if (compteurL == 4) {
			return 2;
		} else {
			return 0;
		}
	}

	int gagne() {
		for (int i = 0; i < rangees; i++) {
			for (int j = 0; j < 4; j++) {
				if (horizontale(i, j) == 1) {
					return 1;
				}
				if (horizontale(i, j) == 2) {
					return 2;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < colonnes; j++) {
				if (verticale(i, j) == 1) {
					return 1;
				}
				if (verticale(i, j) == 2) {
					return 2;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (diagonaleBas(i, j) == 1) {
					return 1;
				}
				if (diagonaleBas(i, j) == 2) {
					return 2;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				if (diagonaleHaut(i, j) == 1) {
					return 1;
				}
				if (diagonaleHaut(i, j) == 2) {
					return 2;
				}
			}
		}
		return -1;
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

}