package entidad;

import java.io.IOException;
import javax.imageio.ImageIO;

public class CreadorPer {
	public static Personaje crearPersonaje(int id) {
		switch (id) {
		case 0: return crearMadoka();
		case 1: return crearMami();
		case 2: return crearKyoko();
		case 3: return crearSayaka();
		default: return crearMadoka();
		}
	}
	private static Personaje crearMadoka() {
		Personaje p = new Personaje("Madoka", 100, 150, 10, 40);
		try {
		//p.idleD = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Still1.png"));
		//p.idleI = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Still2.png"));
		p.caminar1D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/walk1.png"));
		p.caminar2D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/walk3.png"));
		p.caminar3D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/walk5.png"));
		p.caminar1I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/walk2.png"));
		p.caminar2I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/walk4.png"));
		p.caminar3I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/walk6.png"));
		p.ataque1D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/atack1.png"));
		p.ataque1I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/atack2.png"));
		p.ataque2D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/atack3.png"));
		p.ataque2I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/atack4.png"));
		p.especial1D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot1.png"));
		p.especial2D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot3.png"));
		p.especial3D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot7.png"));
		p.especial1I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot2.png"));
		p.especial2I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot4.png"));
		p.especial3I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot6.png"));
		} catch (IOException | IllegalArgumentException e) {
		}
		return p;
		}


		private static Personaje crearMami() {
		Personaje p = new Personaje("Mami", 120, 120, 12, 35);
		try {
			p.idleD = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/Still1.png"));
			p.idleI = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/Still2.png"));
			p.caminar1D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/walk1.png"));
			p.caminar2D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/walk3.png"));
			p.caminar3D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/walk5.png"));
			p.caminar1I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/walk2.png"));
			p.caminar2I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/walk4.png"));
			p.caminar3I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/walk6.png"));
			p.ataque1D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/atack1.png"));
			p.ataque1I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/atack2.png"));
			p.ataque2D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/atack3.png"));
			p.ataque2I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/atack4.png"));
			p.especial1D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/Shot1.png"));
			p.especial2D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/Shot3.png"));
			p.especial3D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/Shot7.png"));
			p.especial1I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/Shot2.png"));
			p.especial2I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/Shot4.png"));
			p.especial3I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Mami/Shot6.png"));
		} catch (IOException | IllegalArgumentException e) {}
		return p;
		}


		private static Personaje crearKyoko() {
		Personaje p = new Personaje("Kyoko", 130, 100, 15, 50);
		try {
			p.idleD = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Kyoko/Still1.png"));
			p.idleI = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Kyoko/Still2.png"));
			p.caminar1D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Kyoko/walk1.png"));
			p.caminar2D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Kyoko/walk3.png"));
			p.caminar3D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Kyoko/walk5.png"));
			p.caminar1I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Kyoko/walk2.png"));
			p.caminar2I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Kyoko/walk4.png"));
			p.caminar3I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Kyoko/walk6.png"));
			p.ataque1D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Kyoko/atack1.png"));
			p.ataque1I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/Kyoko/atack2.png"));
			p.ataque2D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/atack3.png"));
			p.ataque2I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/atack4.png"));
			p.especial1D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot1.png"));
			p.especial2D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot3.png"));
			p.especial3D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot7.png"));
			p.especial1I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot2.png"));
			p.especial2I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot4.png"));
			p.especial3I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot6.png"));
		} catch (IOException | IllegalArgumentException e) {}
		return p;
		}


		private static Personaje crearSayaka() {
		Personaje p = new Personaje("Sayaka", 110, 170, 11, 45);
		try {
			p.idleD = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Still1.png"));
			p.idleI = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Still2.png"));
			p.caminar1D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/walk1.png"));
			p.caminar2D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/walk3.png"));
			p.caminar3D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/walk5.png"));
			p.caminar1I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/walk2.png"));
			p.caminar2I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/walk4.png"));
			p.caminar3I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/walk6.png"));
			p.ataque1D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/atack1.png"));
			p.ataque1I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/atack2.png"));
			p.ataque2D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/atack3.png"));
			p.ataque2I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/atack4.png"));
			p.especial1D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot1.png"));
			p.especial2D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot3.png"));
			p.especial3D = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot7.png"));
			p.especial1I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot2.png"));
			p.especial2I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot4.png"));
			p.especial3I = ImageIO.read(CreadorPer.class.getResourceAsStream("/personajes/madoka/Shot6.png"));
		} catch (IOException | IllegalArgumentException e) {}
		return p;
		}
}
