public class Mago extends Personagem {

    public static final String ARMA_VARINHA_MAGICA = "Varinha mágica";
    public static final String ARMA_LIVRO_DE_FEITICOS = "Livro de feitiços";

    public Mago(String escolhaArma) {
        super(escolhaArma);
        inicializarArma(escolhaArma);
    }

    private void inicializarArma(String escolhaArma) {
        if (ARMA_VARINHA_MAGICA.equals(escolhaArma) || ARMA_LIVRO_DE_FEITICOS.equals(escolhaArma)) {
            setAtaque(50); // Ataque padrão para ambas as armas
        }
    }

    // Métodos específicos para cada ataque
    public void raioDeChamas() {
        if (ARMA_VARINHA_MAGICA.equals(getArma())) {
            receberDano(75);
        }
    }

    public void levitacao() {
        if (ARMA_VARINHA_MAGICA.equals(getArma())) {
            receberDano(50);
        }
    }

    public void cemAnosDeMaldicao() {
        if (ARMA_LIVRO_DE_FEITICOS.equals(getArma())) {
            receberDano(50);
        }
    }

    public void invocacaoInfernal() {
        if (ARMA_LIVRO_DE_FEITICOS.equals(getArma())) {
            receberDano(75);
        }
    }
}
