package Jogo;

import java.util.Arrays;
import java.util.List;

public class Cowboy extends Personagem {

    public static final String ARMA_REVOLVER = "Revólver";
    public static final String ARMA_ESPINGARDA = "Espingarda";

    public Cowboy(String escolhaArma) {
        super(escolhaArma);
        inicializarArma(escolhaArma);
    }

    private void inicializarArma(String escolhaArma) {
        if (ARMA_REVOLVER.equals(escolhaArma) || ARMA_ESPINGARDA.equals(escolhaArma)) {
            setAtaque(50); 
        }
    }

    // Métodos específicos para cada ataque
    public void tiroRapido() {
        if (ARMA_REVOLVER.equals(getArma())) {
            receberDano(50);
        }
    }

    public void chuvaDeBalas() {
        if (ARMA_REVOLVER.equals(getArma())) {
            receberDano(75);
        }
    }

    public void tiroFrontal() {
        if (ARMA_ESPINGARDA.equals(getArma())) {
            receberDano(75);
        }
    }

    public void tiroADistancia() {
        if (ARMA_ESPINGARDA.equals(getArma())) {
            receberDano(50);
        }
    }
    @Override
	  public List <String> getArmas(){
		  return Arrays.asList(ARMA_ESPINGARDA, ARMA_REVOLVER);
	  }
    
    @Override
    public int atacar(int ataque, Personagem alvo) {
        if (ARMA_ESPINGARDA.equals(getArma())) {
            switch (ataque) {
                case 1:
                    alvo.receberDano(75);
                    return 75;
                case 2:
                    alvo.receberDano(50);
                    return 50;
                default:
                    throw new IllegalArgumentException("Ataque inválido");
            }
        } else if (ARMA_REVOLVER.equals(getArma())) {
            switch (ataque) {
                case 3:
                    alvo.receberDano(75);
                    return 75;
                case 4:
                    alvo.receberDano(50);
                    return 50;
                default:
                    throw new IllegalArgumentException("Ataque inválido");
            }
        } else {
            throw new IllegalStateException("Arma não reconhecida");
        }
    }

    @Override
    public List<String> getAtaques() {
        return Arrays.asList("Tiro frontal", "Tiro a distância", "Chuva de balas", "Tiro rápido");
    }
}
