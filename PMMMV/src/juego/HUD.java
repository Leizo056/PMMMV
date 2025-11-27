package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import entidad.Jugador;
import main.GamePanel;

public class HUD {
	private GamePanel gp;
	
	public HUD(GamePanel gp) {
		this.gp = gp;
	}
	
	public void draw(Graphics2D g2, Jugador p1, Jugador p2, RondaManager rondas) {
		g2.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		FontMetrics fm = g2.getFontMetrics();
		
		String nombreP1 = p1.getPersonaje().getnombre();
        int anchoNombreP1 = fm.stringWidth(nombreP1);
        int barraX1 = 20 + anchoNombreP1 + 20;
		//P1
		g2.setColor(Color.WHITE);
		g2.drawString(nombreP1, 20, 23);
		g2.setColor(Color.WHITE);
		g2.drawString(String.valueOf(rondas.getR1()), 20, 50);
		
		g2.setColor(Color.GRAY);
		g2.fillRect(barraX1, 10, p1.getMaxVida() * 3, 15);
		g2.setColor(Color.RED);
		g2.fillRect(barraX1, 10, p1.getVida() * 3, 15);
		
		g2.setColor(Color.GRAY);
		g2.fillRect(barraX1, 30, p1.getMaxMana(), 15);
		g2.setColor(Color.BLUE);
		g2.fillRect(barraX1, 30, p1.getMana(), 15);
		
		//P2
        String nombreP2 = p2.getPersonaje().getnombre();
        int anchoNombreP2 = fm.stringWidth(nombreP2);
		int baseX = gp.getAnchoPantalla() - 20 - anchoNombreP2;
		int barraX2 = baseX - (p2.getMaxVida() * 3) - 20;
		
		g2.setColor(Color.WHITE);
		g2.drawString(nombreP2, baseX , 23);
		g2.setColor(Color.WHITE);
		g2.drawString(String.valueOf(rondas.getR2()), baseX + 50, 50);
		
		g2.setColor(Color.GRAY);
		g2.fillRect(barraX2, 10, p2.getMaxVida() * 3, 15);
		g2.setColor(Color.RED);
		g2.fillRect(barraX2, 10, p2.getVida() * 3, 15);
		
		g2.setColor(Color.GRAY);
		g2.fillRect(barraX2, 30, p2.getMaxMana(), 15);
		g2.setColor(Color.BLUE);
		g2.fillRect(barraX2, 30, p2.getMana(), 15);
		
	}
}
