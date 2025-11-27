package entidad;


import java.awt.image.BufferedImage;


public class Personaje {
	public String nombre;
	
	public int vidaBase;
	public int manaBase;
	public int danoBasico;
	public int danoEspecial;
	
	protected String estado;
	protected int contadorSprites = 0;
	protected int numeroSprite = 1;
	protected int cambiaSprite = 10;
	public BufferedImage idleD;
	public BufferedImage idleI;
	public BufferedImage caminar1D;
	public BufferedImage caminar2D;
	public BufferedImage caminar3D;
	public BufferedImage caminar1I;
	public BufferedImage caminar2I;
	public BufferedImage caminar3I;
	public BufferedImage ataque1D;
	public BufferedImage ataque1I;
	public BufferedImage ataque2D;
	public BufferedImage ataque2I;
	public BufferedImage especial1D;
	public BufferedImage especial2D;
	public BufferedImage especial3D;
	public BufferedImage especial1I;
	public BufferedImage especial2I;
	public BufferedImage especial3I;
	
	
	public Personaje(String nombre, int vidaBase, int manaBase, int danoBasico, int danoEspecial) {
		this.nombre = nombre;
		this.vidaBase = vidaBase;
		this.manaBase = manaBase;
		this.danoBasico = danoBasico;
		this.danoEspecial = danoEspecial;
		this.estado = "quieto";
	}
	public String getnombre() {
		return this.nombre;
	}
	public String getEstado() {
		return this.estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}