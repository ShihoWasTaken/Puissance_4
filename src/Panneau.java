
//package Exo1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Panneau extends JPanel {
	Plateau p;

	public Panneau(Plateau p) {
		this.p = p;
	}

	// public int getPion2(int i, int j){
	// return p.getPion(i, j);
	// }

	public void paintComponent(Graphics g) {
		// super.paintComponent(g);;
		int u = 0;
		int v = 0;
		double h = this.getSize().getHeight();
		double w = this.getSize().getWidth();
		double di = w / 7;
		double dj = (h - 55) / 7 + 10;

		p.setDi(di);
		p.setDj(dj);

		while (v < 7) {
			u = 0;
			while (u < 6) {
				int i = (int) (di * u + 170);
				int j = (int) (dj * v + 0);

				// System.out.println("u"+u+"v"+v+"-->"+p.getPion(u, v));
				if (p.getPion(u, v) == 0) {
					g.setColor(Color.white);
				} else if (p.getPion(u, v) == 1) {
					g.setColor(Color.red);
				} else if (p.getPion(u, v) == 2) {
					g.setColor(Color.yellow);
				}
				g.fillOval(j, i, 750 / 7, 750 / 7);
				u++;
			}
			v++;
		}

	}

}