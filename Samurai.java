package Jogo;

import java.util.Arrays;
import java.util.List;

public class Samurai extends Personagem {

	  public static final String ARMA_KATANA = "Katana";
	  public static final String ARMA_FOICE = "Foice";
	  

	  public Samurai(String escolhaArma) {
	    super(escolhaArma);
	    inicializarArma(escolhaArma);
	  }

	  private void inicializarArma(String escolhaArma) {
	    if (ARMA_KATANA.equals(escolhaArma)) {
	  
	      setAtaque(50); 
	    } else if (ARMA_FOICE.equals(escolhaArma)) {
	      
	      setAtaque(50); 
	    }
	  }

	  // Ataques
	  public void laminaDaEscuridao() {
	    if (ARMA_KATANA.equals(getArma())) {
	      receberDano(75);
	    }
	  }

	  public void retalhador() {
	    if (ARMA_KATANA.equals(getArma())) {
	      receberDano(50);
	    }
	  }

	  public void decapitacaoADistancia() {
	    if (ARMA_FOICE.equals(getArma())) {
	      receberDano(75);
	    }
	  }

	  public void corteDoCampones() {
	    if (ARMA_FOICE.equals(getArma())) {
	      receberDano(50);
	    }
	  }
	  
	  
	  @Override
	  public List <String> getArmas(){
		  return Arrays.asList(ARMA_KATANA, ARMA_FOICE);
	  }
	  
	  @Override
	    public int atacar(int ataque, Personagem alvo) {
	        if (ARMA_KATANA.equals(getArma())) {
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
	        } else if (ARMA_FOICE.equals(getArma())) {
	            switch (ataque) {
	                case 3:
	                    alvo.receberDano(50);
	                    return 75;
	                case 4:
	                    alvo.receberDano(75);
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
	        return Arrays.asList("1- Lâmina da escuridão", "2- Retalhador", "3- Corte do camponês", "4- Decapitação a distância");
	    }
	}
