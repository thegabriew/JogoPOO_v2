import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializa um objeto Scanner para a leitura de entrada do teclado
        Scanner scanner = new Scanner(System.in);

        // Exibe uma mensagem de boas-vindas
        System.out.println("Bem-vindo ao Jogo de Luta!");

        // Jogador 1 escolhe o personagem
        System.out.println("Jogador 1, escolha seu personagem:");
        System.out.println("1 - Assassino");
        System.out.println("2 - Samurai");
        System.out.println("3 - Cowboy");
        System.out.println("4 - Mago");
        int escolhaPersonagem1 = scanner.nextInt();

        // Cria o objeto do personagem escolhido pelo Jogador 1
        Personagem jogador1 = criarPersonagem(escolhaPersonagem1);

        // Mostra as armas disponíveis para o personagem escolhido pelo Jogador 1
        mostrarArmasDisponiveis(jogador1);

        // Jogador 2 escolhe o personagem
        System.out.println("Jogador 2, escolha seu personagem:");
        System.out.println("1 - Assassino");
        System.out.println("2 - Samurai");
        System.out.println("3 - Cowboy");
        System.out.println("4 - Mago");
        int escolhaPersonagem2 = scanner.nextInt();

        // Cria o objeto do personagem escolhido pelo Jogador 2
        Personagem jogador2 = criarPersonagem(escolhaPersonagem2);

        // Mostra as armas disponíveis para o personagem escolhido pelo Jogador 2
        mostrarArmasDisponiveis(jogador2);

        // Jogador 1 escolhe a arma
        System.out.println("Jogador 1, escolha sua arma:");
        int escolhaArma1 = scanner.nextInt();

        // Define a arma escolhida pelo Jogador 1 para o seu personagem
        definirArma(jogador1, escolhaArma1);

        // Jogador 2 escolhe a arma
        System.out.println("Jogador 2, escolha sua arma:");
        int escolhaArma2 = scanner.nextInt();

        // Define a arma escolhida pelo Jogador 2 para o seu personagem
        definirArma(jogador2, escolhaArma2);

        // Loop principal do jogo
        while (jogador1.estaVivo() && jogador2.estaVivo()) {
            // Jogador 1 realiza o ataque
            realizarAtaque(jogador1, jogador2, scanner);

            // Verifica se Jogador 2 ainda está vivo
            if (!jogador2.estaVivo()) {
                System.out.println("Jogador 1 venceu!");
                break;
            }

            // Jogador 2 realiza o ataque
            realizarAtaque(jogador2, jogador1, scanner);

            // Verifica se Jogador 1 ainda está vivo
            if (!jogador1.estaVivo()) {
                System.out.println("Jogador 2 venceu!");
                break;
            }
        }

        // Fecha o Scanner para evitar vazamento de recursos
        scanner.close();
    }

    // Método para criar um objeto do tipo Personagem com base na escolha do jogador
    private static Personagem criarPersonagem(int escolhaPersonagem) {
        if (escolhaPersonagem == 1) {
            return new Assassino("");
        } else if (escolhaPersonagem == 2) {
            return new Samurai("");
        } else if (escolhaPersonagem == 3) {
            return new Cowboy("");
        } else if (escolhaPersonagem == 4) {
            return new Mago("");
        } else {
            throw new IllegalArgumentException("Escolha de personagem inválida");
        }
    }

    // Método para mostrar as armas disponíveis para um determinado personagem
    private static void mostrarArmasDisponiveis(Personagem jogador) {
        System.out.println("Armas disponíveis para " + getNomeClasse(jogador) + ":");
        if (jogador instanceof Assassino) {
            System.out.println("1 - Adaga");
            System.out.println("2 - Soco inglês");
        } else if (jogador instanceof Samurai) {
            System.out.println("1 - Katana");
            System.out.println("2 - Foice");
        } else if (jogador instanceof Cowboy) {
            System.out.println("1 - Revólver");
            System.out.println("2 - Espingarda");
        } else if (jogador instanceof Mago) {
            System.out.println("1 - Varinha mágica");
            System.out.println("2 - Livro de feitiços");
        }
    }

    // Método para definir a arma escolhida por um jogador para o seu personagem
    private static void definirArma(Personagem jogador, int escolhaArma) {
        if (jogador instanceof Assassino && (escolhaArma == 1 || escolhaArma == 2)) {
            jogador.setArma(escolhaArma == 1 ? Assassino.ARMA_ADAGA : Assassino.ARMA_SOCO_INGLES);
        } else if (jogador instanceof Samurai && (escolhaArma == 1 || escolhaArma == 2)) {
            jogador.setArma(escolhaArma == 1 ? Samurai.ARMA_KATANA : Samurai.ARMA_FOICE);
        } else if (jogador instanceof Cowboy && (escolhaArma == 1 || escolhaArma == 2)) {
            jogador.setArma(escolhaArma == 1 ? Cowboy.ARMA_REVOLVER : Cowboy.ARMA_ESPINGARDA);
        } else if (jogador instanceof Mago && (escolhaArma == 1 || escolhaArma == 2)) {
            jogador.setArma(escolhaArma == 1 ? Mago.ARMA_VARINHA_MAGICA : Mago.ARMA_LIVRO_DE_FEITICOS);
        } else {
            throw new IllegalArgumentException("Escolha de arma inválida");
        }
    }

    // Método para realizar o ataque de um jogador ao outro
    private static void realizarAtaque(Personagem atacante, Personagem alvo, Scanner scanner) {
        // O restante do código permanece o mesmo
    }

    // Método para obter o nome da classe do personagem
    private static String getNomeClasse(Personagem jogador) {
        if (jogador instanceof Assassino) {
            return "Assassino";
        } else if (jogador instanceof Samurai) {
            return "Samurai";
        } else if (jogador instanceof Cowboy) {
            return "Cowboy";
        } else if (jogador instanceof Mago) {
            return "Mago";
        } else {
            return "Personagem inválido";
        }
    }
}
