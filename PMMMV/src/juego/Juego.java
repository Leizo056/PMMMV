package juego;

import java.awt.Graphics2D;
import entidad.Jugador;
import main.GamePanel;
import main.ManejadorTeclas;

public class Juego {

    public Jugador jugador1;
    public Jugador jugador2;
    private RondaManager rondas;
    private HUD hud;
    private GamePanel panel;

    public Juego(GamePanel panel, ManejadorTeclas mT) {
        this.panel = panel;
        rondas = new RondaManager();
        hud = new HUD(panel);

        jugador1 = new Jugador(panel, mT, 1, panel.getTamanioTile() * 6, panel.getGroundY());
        jugador2 = new Jugador(panel, mT, 2, panel.getAnchoPantalla() - panel.getTamanioTile() * 7, panel.getGroundY());
    }

    public void update() {
        jugador1.update();
        jugador2.update();

        jugador1.atacar(jugador2);
        jugador2.atacar(jugador1);

        colisiones();

        // Verificar fin de ronda
        if (!rondas.rondaTerminada) {
            if (jugador1.getVida() <= 0) {
                rondas.jugador1PierdeRonda();
                reiniciarRonda();
            } else if (jugador2.getVida() <= 0) {
                rondas.jugador2PierdeRonda();
                reiniciarRonda();
            }
        }
    }

    private void reiniciarRonda() {
        rondas.rondaTerminada = true;

        // Resetear vida y mana
        jugador1.resetStats();
        jugador2.resetStats();

        // Reposicionar
        jugador1.setX(panel.getTamanioTile() * 6);
        jugador1.setY(panel.getGroundY());

        jugador2.setX(panel.getAnchoPantalla() - panel.getTamanioTile() * 7);
        jugador2.setY(panel.getGroundY());

        if (!rondas.partidaTerminada)
            rondas.resetRonda();
    }

    private void colisiones() {
        java.awt.Rectangle r1 = new java.awt.Rectangle(jugador1.getX(), jugador1.getY(), panel.getTamanioTile(), panel.getTamanioTile());
        java.awt.Rectangle r2 = new java.awt.Rectangle(jugador2.getX(), jugador2.getY(), panel.getTamanioTile(), panel.getTamanioTile());

        if (r1.intersects(r2)) {
            java.awt.Rectangle inter = r1.intersection(r2);
            int push = inter.width / 2 + 1;

            if (jugador1.getX() < jugador2.getX()) {
                jugador1.setX(jugador1.getX() - push);
                jugador2.setX(jugador2.getX() + push);
            } else {
                jugador1.setX(jugador1.getX() + push);
                jugador2.setX(jugador2.getX() - push);
            }
        }
    }

    public void draw(Graphics2D g2) {
        jugador1.draw(g2);
        jugador2.draw(g2);
        hud.draw(g2, jugador1, jugador2, rondas);
    }

    public boolean partidaTerminada() {
        return rondas.partidaTerminada;
    }
    public boolean ganoP1() {
    	if(rondas.getR1() == 2) 
    		return true;
		return false;
    }
    public RondaManager getRondas(){
    	return this.rondas;
    }
    
    public void resetJuego() {
    	rondas.setRondasP1(0);
    	rondas.setRondasP2(0);
    	rondas.setPartidaT(false);
    }
}
