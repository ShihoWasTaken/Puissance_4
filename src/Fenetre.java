
//package Exo1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
//import java.swing.GridLayout;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Fenetre extends JFrame implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton boutonNouvellePartie;
	private JButton boutonQuitter;
	private Panneau pan;
	private Plateau p;

	public Fenetre() {
		int a = 800;
		int b = 870;
		p = new Plateau();
		pan = new Panneau(p);
		boutonNouvellePartie = new JButton("Nouvelle Partie");
		boutonQuitter = new JButton("Quitter");
		this.setTitle("Puissance 4");
		this.setSize(a, b);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		pan.setLayout(new GridLayout(10, 3));
		pan.add(boutonNouvellePartie);
		pan.add(boutonQuitter);

		// this.add(pan);
		setContentPane(pan);
		setBackground(Color.blue);

		// repaint();
		// pack();
		this.setVisible(true);

		pan.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				System.out.println("x=" + x + " y=" + y + " col=" + p.getCol(x) + " row=" + p.getRow(y));
				int col = p.getCol(x);
				int row = p.getRow(y);

				if (col == 0) {
					p.joue(0);
					System.out.println("e.getX() =" + e.getX());
					System.out.println("a/7 =" + a / 7);
					System.out.println("Je joue dans la premiere colonne");
					// p.imprime();
				} else if (col == 1) {
					p.joue(1);
					System.out.println("Je joue dans la deuxieme colonne");
				} else if (col == 2) {
					p.joue(2);
					System.out.println("Je joue dans la troisieme colonne");
				} else if (col == 3) {
					p.joue(3);
					System.out.println("Je joue dans la quatrieme colonne");
				} else if (col == 4) {
					p.joue(4);
					System.out.println("Je joue dans la cinquieme colonne");
				} else if (col == 5) {
					p.joue(5);
					System.out.println("Je joue dans la sixieme colonne");
				} else if (col == 6) {
					p.joue(6);
					System.out.println("Je joue dans la septieme colonne");
				}
				setBackground(Color.blue);
				p.imprime();
				pan.repaint();

			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}