package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import estados.GameState;
import main.GamePanel;
import main.ManejadorTeclas;

public class SeleccionEscenario {
	private int opcion = 0;
    private final String[] escenarios = { "ciudad", "bruja", "sueño" };
    public int escenarioSeleccionado = 0;

    public void dibujar(Graphics2D g2, GamePanel panel) {
        g2.setColor(Color.DARK_GRAY);
        g2.fillRect(0,0,panel.getAnchoPantalla(),panel.getAltoPantalla());

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 40));
        g2.drawString("Selecciona un escenario", 250, 100);

        g2.setFont(new Font("Arial", Font.BOLD, 30));
        for(int i=0; i<escenarios.length; i++) {
            if(i == opcion)
                g2.setColor(Color.YELLOW);
            else
                g2.setColor(Color.WHITE);
            
            g2.drawString(escenarios[i], 400, 220 + i*60);
        }
    }

    public void arriba() {
        opcion--;
        if(opcion < 0) opcion = escenarios.length - 1;
    }

    public void abajo() {
        opcion++;
        if(opcion >= escenarios.length) opcion = 0;
    }

    public int seleccionar() {
        return opcion;
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
            escenarioSeleccionado = seleccionar();
            panel.selectorPersonaje = new menu.SeleccionPersonaje();
            panel.estado = GameState.SELECCION_PERSONAJE;
            tec.resetMenuKeys();
        }
    }
}
