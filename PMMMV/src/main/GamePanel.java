package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import estados.GameState;
import juego.Juego;
import menu.MenuPrincipal;
import menu.SeleccionEscenario;
import menu.SeleccionPersonaje;

public class GamePanel extends JPanel implements Runnable {

    final int tamanioOriginalTile = 16;
    final int escala = 3;
    final int tamanioTile = tamanioOriginalTile * escala;
    final int maxRenPantalla = 15;
    final int maxColPantalla = 26;
    final int anchoPantalla = tamanioTile * maxColPantalla;
    final int altoPantalla = tamanioTile * maxRenPantalla;
    final int alturapiso = 100;
    public BufferedImage fondo = null;
    public BufferedImage fondo0;
    public BufferedImage fondo1;
    public BufferedImage fondo2;

    Thread hebraJuego;
    ManejadorTeclas mT = new ManejadorTeclas(this);

    public GameState estado = GameState.MENU;
    public MenuPrincipal menu = new MenuPrincipal();
    public SeleccionEscenario selectorEscenario = new SeleccionEscenario();
    public SeleccionPersonaje selectorPersonaje = new SeleccionPersonaje();
    public Juego juego;

    private int FPS = 60;

    public GamePanel() {
        this.setPreferredSize(new Dimension(anchoPantalla, altoPantalla));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(mT);
        this.setFocusable(true);

        juego = new Juego(this, mT);
    }

    public void iniciaHebraJuego() {
        hebraJuego = new Thread(this);
        hebraJuego.start();
    }

    @Override
    public void run() {
        double intervaloDibujo = 1000000000.0 / FPS;
        double delta = 0;
        long ultimaVez = System.nanoTime();
        long tiempoActual;

        while (hebraJuego != null) {
            tiempoActual = System.nanoTime();
            delta += (tiempoActual - ultimaVez) / intervaloDibujo;
            ultimaVez = tiempoActual;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        switch (estado) {
            case MENU:
                menu.update(mT, this);
                break;

            case SELECCION_ESCENARIO:
                selectorEscenario.update(mT, this);
                break;

            case SELECCION_PERSONAJE:
                selectorPersonaje.update(mT, this);
                break;

            case JUEGO:
                juego.update();
                if (juego.partidaTerminada())
                    estado = GameState.RESULTADO;
                break;
            case RESULTADO:
            	
                break;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        switch (estado) {

            case MENU:
                menu.dibujar(g2);
                break;

            case SELECCION_ESCENARIO:
                selectorEscenario.dibujar(g2, this);
                break;

            case SELECCION_PERSONAJE:
                selectorPersonaje.dibujar(g2, this);
                break;

            case JUEGO:
                dibujarFondo(g2);
                juego.draw(g2);
                break;

            case RESULTADO:
            	dibujarFondo(g2);
                juego.draw(g2);

                g2.setColor(Color.WHITE);
                g2.drawString("PARTIDA TERMINADA", anchoPantalla / 2 - 80, 50);
                if(juego.ganoP1())
                	g2.drawString("Gano el Prayer 1", anchoPantalla / 2 - 60, 80);
                else
                	g2.drawString("Gano el Prayer 2", anchoPantalla / 2 - 60, 80);
                g2.drawString("Presiona ENTER para regresar al menú", anchoPantalla / 2 - 100,110);
                if(mT.enterPressed) {
                	
                	estado = GameState.MENU;
                }
                break;
        }

        g2.dispose();
    }
    
    

    private void dibujarFondo(Graphics2D g2) {
    	try {
	        switch (selectorEscenario.escenarioSeleccionado) {
	            case 0: fondo = ImageIO.read(getClass().getResource("/escenarios/escenario1.jpg"));; break;
	            case 1: g2.setColor(new Color(100,50,50)); break;
	            case 2: g2.setColor(new Color(20,100,50)); break;
	        }
	        } catch (Exception e) {
	        	 e.printStackTrace();
	        }
        if (fondo != null) {
            g2.drawImage(fondo, 0, 0, anchoPantalla, altoPantalla, null);
        } else {
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, anchoPantalla, altoPantalla);
        }
    }

    // Getters
    public int getTamanioTile() { return tamanioTile; }
    public int getMaxRenPantalla() { return maxRenPantalla; }
    public int getMaxColPantalla() { return maxColPantalla; }
    public int getAnchoPantalla() { return anchoPantalla; }
    public int getAltoPantalla() { return altoPantalla; }

    public int getGroundY() {
        return altoPantalla - alturapiso - tamanioTile;
    }
}
