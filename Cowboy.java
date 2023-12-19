public class Cowboy extends Personagem {

    public static final String ARMA_REVOLVER = "Revólver";
    public static final String ARMA_ESPINGARDA = "Espingarda";

    public Cowboy(String escolhaArma) {
        super(escolhaArma);
        inicializarArma(escolhaArma);
    }

    private void inicializarArma(String escolhaArma) {
        if (ARMA_REVOLVER.equals(escolhaArma) || ARMA_ESPINGARDA.equals(escolhaArma)) {
            setAtaque(50); // Ataque padrão para ambas as armas
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
}
