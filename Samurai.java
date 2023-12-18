public class Samurai extends Personagem {

  public static final String ARMA_KATANA = "Katana";
  public static final String ARMA_FOICE = "Foice";

  public Samurai(String escolhaArma) {
    super(escolhaArma);
    inicializarArma(escolhaArma);
  }

  private void inicializarArma(String escolhaArma) {
    if (ARMA_KATANA.equals(escolhaArma)) {
      // Configura ataques para Katana
      setAtaque(75); // Ataque padrão
    } else if (ARMA_FOICE.equals(escolhaArma)) {
      // Configura ataques para Foice
      setAtaque(50); // Ataque padrão
    }
  }

  // Métodos específicos para cada ataque
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
}
