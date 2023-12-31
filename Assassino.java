package Jogo;

import java.util.Arrays;
import java.util.List;

public class Assassino extends Personagem {

	  public static final String ARMA_ADAGA = "Adaga";
	  public static final String ARMA_SOCO_INGLES = "Soco inglês";

	  public Assassino(String escolhaArma) {
	    super(escolhaArma);
	    inicializarArma(escolhaArma);
	  }

	  private void inicializarArma(String escolhaArma) {
	    if (ARMA_ADAGA.equals(escolhaArma)) {
	      // Configura ataques para Adaga
	      setAtaque(75); // Ataque padrão
	    } else if (ARMA_SOCO_INGLES.equals(escolhaArma)) {
	      // Configura ataques para Soco Inglês
	      setAtaque(50); // Ataque padrão
	    }
	  }

	  // Métodos específicos para cada ataque
	  public void corteProfundo() {
	    if (ARMA_ADAGA.equals(getArma())) {
	      receberDano(75);
	    }
	  }

	  public void perfuracao() {
	    if (ARMA_ADAGA.equals(getArma())) {
	      receberDano(50);
	    }
	  }

	  public void cruzadoDeEspinhos() {
	    if (ARMA_SOCO_INGLES.equals(getArma())) {
	      receberDano(75);
	    }
	  }

	  public void socoFantasma() {
	    if (ARMA_SOCO_INGLES.equals(getArma())) {
	      receberDano(50);
	    }
	  }
	  
	    @Override
	    public int atacar(int ataque, Personagem alvo) {
	        if (ARMA_ADAGA.equals(getArma())) {
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
	        } else if (ARMA_SOCO_INGLES.equals(getArma())) {
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
	        return Arrays.asList("Corte Profundo", "Perfuração", "Cruzado de Espinhos", "Soco Fantasma");
	    }


	  @Override
	  public List <String> getArmas(){
		  return Arrays.asList(ARMA_SOCO_INGLES, ARMA_ADAGA);
	  }
	}
