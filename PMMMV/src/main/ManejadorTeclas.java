package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import estados.GameState;

public class ManejadorTeclas implements KeyListener {
	private boolean p1Izquierda, p1Derecha, p1Saltar;
	private boolean p2Izquierda, p2Derecha, p2Saltar;
	private boolean p1Atk1, p1Atk2, p1SpAtk;
	private boolean p2Atk1, p2Atk2, p2SpAtk; 
	public boolean upPressed;
	public boolean downPressed;
	public boolean enterPressed;
	private GamePanel panel;
	private final long tiempo = 200;
	private long lastuppress = 0;
	private long lastdownpress = 0;

    
	public ManejadorTeclas(GamePanel panel) {
        this.panel = panel;
    }
	@Override	
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		long now = System.currentTimeMillis();
		switch(e.getKeyCode()) {
	        	case KeyEvent.VK_UP:
	        		if (!upPressed && now - lastuppress >= tiempo ) {
	        		upPressed = true; 
	        		lastuppress = now;
	        		}
	        		break;
	        	case KeyEvent.VK_DOWN: 
	        		if (!downPressed &&  now - lastdownpress >= tiempo ) {
	        		downPressed = true; 
	        		lastdownpress = now;
	        		}
	        		break;
	        	case KeyEvent.VK_ENTER: 
	        		enterPressed = true; 
	        		
	        	break;
		}
		
		if (panel.estado != GameState.JUEGO) return;
		
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W : p1Saltar = true;
				break;
			case KeyEvent.VK_A : p1Izquierda = true;
				break;
			case KeyEvent.VK_D : p1Derecha = true;
				break;
			case KeyEvent.VK_UP : p2Saltar = true;
				break;
			case KeyEvent.VK_LEFT : p2Izquierda = true;
				break;
			case KeyEvent.VK_RIGHT : p2Derecha = true;
				break;
			case KeyEvent.VK_J : p1Atk1 = true;
				break;
			case KeyEvent.VK_K : p1Atk2 = true;
				break;
			case KeyEvent.VK_L : p1SpAtk = true;
				break;
			case KeyEvent.VK_NUMPAD1 : p2Atk1 = true;
				break;
			case KeyEvent.VK_NUMPAD2 : p2Atk2 = true;
				break;
			case KeyEvent.VK_NUMPAD3 : p2SpAtk = true;
				break;
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
	        case KeyEvent.VK_UP: upPressed = false; 
	        	break;
	        case KeyEvent.VK_DOWN: downPressed = false; 
	        	break;
	        case KeyEvent.VK_ENTER: enterPressed = false; 
	        	break;
    }
	
		if (panel.estado != GameState.JUEGO) return;
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W : p1Saltar = false;
			break;
		case KeyEvent.VK_A : p1Izquierda = false;
			break;
		case KeyEvent.VK_D : p1Derecha = false;
			break;
		case KeyEvent.VK_UP : p2Saltar = false;
			break;
		case KeyEvent.VK_LEFT : p2Izquierda = false;
			break;
		case KeyEvent.VK_RIGHT : p2Derecha = false;
			break;
		case KeyEvent.VK_J : p1Atk1 = false;
			break;
		case KeyEvent.VK_K : p1Atk2 = false;
			break;
		case KeyEvent.VK_L : p1SpAtk = false;
			break;
		case KeyEvent.VK_NUMPAD1 : p2Atk1 = false;
			break;
		case KeyEvent.VK_NUMPAD2 : p2Atk2 = false;
			break;
		case KeyEvent.VK_NUMPAD3 : p2SpAtk = false;
			break;
		}
	}
	
	public void resetMenuKeys() {
	    upPressed = false;
	    downPressed = false;
	    enterPressed = false;
	}
	
	public boolean getp1Saltar() {
		return this.p1Saltar;
	}
	public boolean getp1Izquierda() {
		return this.p1Izquierda;
	}
	public boolean getp1Derecha() {
		return this.p1Derecha;
	}
	public boolean getp2Saltar() {
		return this.p2Saltar;
	}
	public boolean getp2Izquierda() {
		return this.p2Izquierda;
	}
	public boolean getp2Derecha() {
		return this.p2Derecha;
	}
	public boolean getp1Atk1() {
		return this.p1Atk1;
	}
	public boolean getp1Atk2() {
		return this.p1Atk2;
	}
	public boolean getp1SpAtk() {
		return this.p1SpAtk;
	}
	public boolean getp2Atk1() {
		return this.p2Atk1;
	}
	public boolean getp2Atk2() {
		return this.p2Atk2;
	}
	public boolean getp2SpAtk() {
		return this.p2SpAtk;
	}
}