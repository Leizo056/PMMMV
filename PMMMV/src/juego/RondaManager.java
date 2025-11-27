package juego;

public class RondaManager {
	public int rondasP1 = 0;
    public int rondasP2 = 0;

    public boolean rondaTerminada = false;
    public boolean partidaTerminada = false;

    public void jugador1PierdeRonda() {
        rondasP2++;
        rondaTerminada = true;
        if(rondasP2 == 2) partidaTerminada = true;
    }

    public void jugador2PierdeRonda() {
        rondasP1++;
        rondaTerminada = true;
        if(rondasP1 == 2) partidaTerminada = true;
    }

    public void resetRonda() {
        rondaTerminada = false;
    }
    public int getR1() {
        return rondasP1;
    }
    public int getR2() {
        return rondasP2;
    }

    public void setRondasP1(int value) {
    	rondasP1 = value;
    }
    public void setRondasP2(int value) {
    	rondasP1 = value;
    }
    public void setPartidaT(boolean value) {
    	rondaTerminada = value;
    }
}
