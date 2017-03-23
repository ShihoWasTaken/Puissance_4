
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
					System.out.println("e.getX() =" + e.getX());
					System.out.println("a/7 =" + a / 7);
				} 
				p.joue(col);
				System.out.println("Je joue dans la colonne N°" + (col+1));
				
				setBackground(Color.blue);
				p.imprime();
				pan.repaint();
				System.out.println("gagne = " + p.gagne());

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