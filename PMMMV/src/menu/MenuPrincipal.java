package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import estados.GameState;
import main.GamePanel;
import main.ManejadorTeclas;

public class MenuPrincipal {

	private int indice = 0;
    private String[] opciones = {
            "JUGAR",
            "OPCIONES",
            "SALIR"
    };
    
    public void moverArriba() {
        indice--;
        if (indice < 0) indice = opciones.length - 1;
    }

    public void moverAbajo() {
        indice++;
        if (indice >= opciones.length) indice = 0;
    }

    public int seleccionar() {
        return indice;
    }

    public void dibujar(Graphics2D g2) {

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 48));
        g2.drawString("MENU PRINCIPAL", 320, 120);

        g2.setFont(new Font("Arial", Font.PLAIN, 32));

        for (int i = 0; i < opciones.length; i++) {
            if (i == indice) {
                g2.setColor(Color.YELLOW);
            } else {
                g2.setColor(Color.WHITE);
            }

            g2.drawString(opciones[i], 420, 250 + i * 60);
        }
    }
    public void update(ManejadorTeclas tec, GamePanel panel) {
    	if (tec.upPressed) 
    	{
    		moverArriba();
        	tec.resetMenuKeys();
        }
        if (tec.downPressed)
        {
        	moverAbajo();
        	tec.resetMenuKeys();
        }
        if (tec.enterPressed) {
            int opcion = seleccionar();

            switch(opcion) {
                case 0:
                    panel.estado = GameState.SELECCION_ESCENARIO;
                    break;
                case 1:
                    System.out.println("Opciones no implementadas.");
                    break;
                case 2:
                    System.exit(0);
                    break;
            }

            tec.resetMenuKeys();
        }
    }
}
