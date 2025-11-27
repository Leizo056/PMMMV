package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import estados.GameState;
import main.GamePanel;
import main.ManejadorTeclas;

public class SeleccionPersonaje {
	private int opcion = 0;
    private final String[] personajes = {
        "Madoka",
        "Mami",
        "Kyoko",
        "Sayaka"
    };

    public int personaje1 = -1;
    public int personaje2 = -1;
    private boolean seleccionandoJugador1 = true;

    public void dibujar(Graphics2D g2, GamePanel panel) {
        g2.setColor(Color.BLACK);
        g2.fillRect(0,0,panel.getAnchoPantalla(),panel.getAltoPantalla());

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 40));

        if(seleccionandoJugador1)
            g2.drawString("Jugador 1 selecciona", 250, 100);
        else
            g2.drawString("Jugador 2 selecciona", 250, 100);

        g2.setFont(new Font("Arial", Font.BOLD, 30));

        for(int i=0; i<personajes.length; i++) {
            if(i == opcion)
                g2.setColor(Color.YELLOW);
            else
                g2.setColor(Color.WHITE);
            
            g2.drawString(personajes[i], 400, 220 + i*60);
        }
    }

    public void arriba() {
        opcion--;
        if(opcion < 0) opcion = personajes.length - 1;
    }

    public void abajo() {
        opcion++;
        if(opcion >= personajes.length) opcion = 0;
    }

    public GameState seleccionar() {
        if(seleccionandoJugador1) {
            personaje1 = opcion;
            seleccionandoJugador1 = false;
            opcion = 0;
        } else {
            personaje2 = opcion;
            return GameState.JUEGO;
        }
        return GameState.SELECCION_PERSONAJE;
    }
    
   
    public void update(ManejadorTeclas tec, GamePanel panel) {
    	if (tec.upPressed) {
    		arriba();
    		tec.resetMenuKeys();
    	}
        if (tec.downPressed) {
        	abajo();
    		tec.resetMenuKeys();

        }
        	
        if (tec.enterPressed) {

            GameState siguiente = seleccionar();

			if (siguiente == GameState.JUEGO) {

                int p1 = personaje1;
                int p2 = personaje2;

                if (panel.juego != null) {
                	panel.juego.jugador1.setPersonaje(p1);
                	panel.juego.jugador2.setPersonaje(p2);


                	// resetear stats al iniciar la partida
                	panel.juego.jugador1.resetStats();
                	panel.juego.jugador2.resetStats();
                	}
                	}

            panel.estado = siguiente;
            tec.resetMenuKeys();
        }
    }
}
