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
}
