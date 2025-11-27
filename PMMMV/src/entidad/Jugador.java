package entidad;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.ManejadorTeclas;

public class Jugador {
	private GamePanel gP;
	private ManejadorTeclas mT;
	private final int id;
	private final int ancho, alto;
	
	private int vida = 0;
	private int mana = 0;
	private int maxVida = 0;
	private int maxMana = 0;
	
	private Personaje personaje;
	
	private boolean puedeAtacar = true;
	private long timeUltimoAtq = 0;
	private long cooldownAtq = 500;
	
	private boolean puedeAtaqueEspecial = true;
	private long timeUltimoEspecial = 0;
	private long cooldownEspecial = 1200; 
	protected int mundoX, mundoY, velocidad;
	private boolean enElAire = false;
	private double velocidadY = 0;
	private final double gravedad = 0.8;
	private final double fuerzaSalto = -14;
	BufferedImage sprite = null;
	
	public Jugador(GamePanel gP, ManejadorTeclas mT, int id, int posXInicial, int posYInicial) {
		this.gP = gP;
		this.mT = mT;
		this.id = id;
		this.ancho  = gP.getTamanioTile() *3;
		this.alto = gP.getTamanioTile()* 3;
		this.mundoX = posXInicial;
		this.mundoY = posYInicial;
		this.velocidad = 6; 
		setPersonaje(0);
	}
	
	public void setPersonaje(int idPersonaje) {
		this.personaje = CreadorPer.crearPersonaje(idPersonaje);
		this.maxVida = personaje.vidaBase;
		this.maxMana = personaje.manaBase;
		this.vida = maxVida;
		this.mana = maxMana;
		}

		public Personaje getPersonaje() {
		return this.personaje;
		}
	
	public void atacar(Jugador enemigo) {
		long ahora = System.currentTimeMillis();
		
		// atq 1
		if(id == 1 && mT.getp1Atk1() || id == 2 && mT.getp2Atk1()) {
			
			if(puedeAtacar && estaCerca(enemigo)) {
				enemigo.recibirDano(10);
				puedeAtacar = false;
				timeUltimoAtq = ahora;
			}
				
		}
		
		// atq 2
		if(id == 1 && mT.getp1Atk2() || id == 2 && mT.getp2Atk2()) {
			if(puedeAtacar && estaCerca(enemigo)) {
				enemigo.recibirDano(16);
				puedeAtacar = false;
				timeUltimoAtq = ahora;
			}
		}
		
		// atq 3
		if(id == 1 && mT.getp1SpAtk() || id == 2 && mT.getp2SpAtk()) {
			if(puedeAtaqueEspecial && estaCerca(enemigo) && mana >= 20) {
				enemigo.recibirDano(40);
				mana -= 20;
				puedeAtaqueEspecial = false;
				timeUltimoEspecial = ahora;
			}
		}
		
		if(!puedeAtacar && ahora - timeUltimoAtq > cooldownAtq) 
			puedeAtacar = true;
		
		if(!puedeAtaqueEspecial && ahora - timeUltimoEspecial > cooldownEspecial) 
			puedeAtaqueEspecial = true;
		
	}
	
	private boolean estaCerca(Jugador enemigo) {
		return Math.abs(this.getX() - enemigo.getX()) < this.ancho + 20d;
	}
	
	private void recibirDano(int cantidad) {
		vida -= cantidad;
		if(vida < 0) vida = 0;
	}
	
	public void update() {
		if(id == 1) {
			if(mT.getp1Izquierda()) {
				setX(getX() - getVelocidad());
				personaje.setEstado("izquierda");
				personaje.contadorSprites++;
			}
			if(mT.getp1Derecha()) {
				setX(getX() + getVelocidad());
				personaje.setEstado("derecha");
				personaje.contadorSprites++;
			}
			if(mT.getp1Saltar()  && !enElAire) {
				velocidadY = fuerzaSalto;
				enElAire = true;
				
			}
		} else { 
			if(mT.getp2Izquierda()) {
				setX(getX() - getVelocidad());
				personaje.setEstado("izquierda");
				personaje.contadorSprites++;
			}
			if(mT.getp2Derecha()) {
				setX(getX() + getVelocidad());
				personaje.setEstado("derecha");
				personaje.contadorSprites++;
			}
			if(mT.getp2Saltar() && !enElAire) {
				velocidadY = fuerzaSalto;
				enElAire = true;
			}
		}
		
		if (personaje.contadorSprites > personaje.cambiaSprite) {
		    personaje.numeroSprite++;
		    if (personaje.numeroSprite > 3) {
		        personaje.numeroSprite = 1;
		    }
		    personaje.contadorSprites = 0;
		}

		
		if(enElAire) {
			velocidadY += gravedad;
			double nuevaY = getY() + velocidadY;
			setY((int)nuevaY);
			int suelo = gP.getGroundY();
			if(getY() >= suelo) {
				setY(suelo);
				enElAire = false;
				velocidadY = 0;
			}
		} else {
			int suelo = gP.getGroundY();
			if(getY() > suelo) 
				setY(suelo);
		}
				if(getX() < 0) setX(0);
					if(getX() > gP.getAnchoPantalla() - ancho) 
						setX(gP.getAnchoPantalla() - ancho);
	}
	
	public void draw(Graphics2D g2) {
		
		/*
		 * if(personaje.estado == "derecha") {
					sprite = personaje.ataque1D;
				} else {
					sprite = personaje.ataque1I;
				}
				
		if (personaje.getEstado() == "quieto") {
			sprite = personaje.idle;
			}
		
		if (personaje.getEstado() != "quieto") {
			g2.drawImage(sprite, getX(), getY(), ancho, alto, null);
			g2.setColor(Color.BLACK);
			g2.drawRect(getX(), getY(), ancho, alto);
			} else {
			if (id == 1)
			g2.setColor(new Color(66, 135, 245));
			else
			g2.setColor(new Color(245, 66, 66));
			g2.fillRect(getX(), getY(), ancho, alto);
			g2.setColor(Color.BLACK);
			g2.drawRect(getX(), getY(), ancho, alto);
			}
		*/
		switch(personaje.estado) {
			case "quieto" :
				sprite = personaje.caminar1D;
			break;
			case "izquierda" : sprite = personaje.caminar1I;
				if(personaje.numeroSprite == 1)
					sprite = this.personaje.caminar1I;
				if(personaje.numeroSprite == 2)
					sprite = this.personaje.caminar2I;
				if(personaje.numeroSprite == 3)
					sprite = this.personaje.caminar3I;
			break;
			case "derecha" : sprite = personaje.caminar1D;
			if(personaje.numeroSprite == 1)
				sprite = this.personaje.caminar1D;
			if(personaje.numeroSprite == 2)
				sprite = this.personaje.caminar2D;
			if(personaje.numeroSprite == 3)
				sprite = this.personaje.caminar3D;
			break;
		}
		g2.drawImage(sprite, getX(), getY(), ancho, alto, null);
	}
		
	public int getX() {
		return this.mundoX;
	}
	public int getY() {
		return this.mundoY;
	}
	public int getVelocidad() {
		return this.velocidad;
	}
	public void setX(int valor) {
		this.mundoX = valor;
	}
	public void setY(int valor) {
		this.mundoY = valor;
	}
	public int getVida() {
		return vida;
	}
	public int getMana() {
		return mana;
	}
	public int getMaxVida() {
		return maxVida;
	}
	public int getMaxMana() {
		return maxMana;
	}

	public void resetStats() {
		vida = maxVida;
		mana = maxMana;
	}
}
