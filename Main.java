import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo de Luta!");

        System.out.println("Jogador 1, escolha seu personagem:");
        System.out.println("1 - Assassino");
        System.out.println("2 - Samurai");
        System.out.println("3 - Cowboy");
        System.out.println("4 - Mago");
        int escolhaPersonagem1 = scanner.nextInt();
        Personagem jogador1 = criarPersonagem(escolhaPersonagem1);
        mostrarArmasDisponiveis(jogador1);

        System.out.println("Jogador 2, escolha seu personagem:");
        System.out.println("1 - Assassino");
        System.out.println("2 - Samurai");
        System.out.println("3 - Cowboy");
        System.out.println("4 - Mago");
        int escolhaPersonagem2 = scanner.nextInt();
        Personagem jogador2 = criarPersonagem(escolhaPersonagem2);
        mostrarArmasDisponiveis(jogador2);

        System.out.println("Jogador 1, escolha sua arma:");
        int escolhaArma1 = scanner.nextInt();
        definirArma(jogador1, escolhaArma1);

        System.out.println("Jogador 2, escolha sua arma:");
        int escolhaArma2 = scanner.nextInt();
        definirArma(jogador2, escolhaArma2);

        while (jogador1.estaVivo() && jogador2.estaVivo()) {
            realizarAtaque(jogador1, jogador2, scanner);
            if (!jogador2.estaVivo()) {
                System.out.println("Jogador 1 venceu!");
                break;
            }

            realizarAtaque(jogador2, jogador1, scanner);
            if (!jogador1.estaVivo()) {
                System.out.println("Jogador 2 venceu!");
                break;
            }
        }

        scanner.close();
    }

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

    private static void definirArma(Personagem jogador, int escolhaArma) {
        if (jogador instanceof Assassino) {
            if (escolhaArma == 1) {
                jogador.setArma(Assassino.ARMA_ADAGA);
            } else if (escolhaArma == 2) {
                jogador.setArma(Assassino.ARMA_SOCO_INGLES);
            } else {
                throw new IllegalArgumentException("Escolha de arma inválida");
            }
        } else if (jogador instanceof Samurai) {
            if (escolhaArma == 1) {
                jogador.setArma(Samurai.ARMA_KATANA);
            } else if (escolhaArma == 2) {
                jogador.setArma(Samurai.ARMA_FOICE);
            } else {
                throw new IllegalArgumentException("Escolha de arma inválida");
            }
        } else if (jogador instanceof Cowboy) {
            if (escolhaArma == 1) {
                jogador.setArma(Cowboy.ARMA_REVOLVER);
            } else if (escolhaArma == 2) {
                jogador.setArma(Cowboy.ARMA_ESPINGARDA);
            } else {
                throw new IllegalArgumentException("Escolha de arma inválida");
            }
        } else if (jogador instanceof Mago) {
            if (escolhaArma == 1) {
                jogador.setArma(Mago.ARMA_VARINHA_MAGICA);
            } else if (escolhaArma == 2) {
                jogador.setArma(Mago.ARMA_LIVRO_DE_FEITICOS);
            } else {
                throw new IllegalArgumentException("Escolha de arma inválida");
            }
        } else {
            throw new IllegalArgumentException("Tipo de jogador desconhecido");
        }
    }

    private static void realizarAtaque(Personagem atacante, Personagem alvo, Scanner scanner) {
    // Obtém a lista de ataques disponíveis para o atacante
    List<Ataque> ataquesDisponiveis = atacante.getAtaques();

    // Mostra os ataques disponíveis para o jogador
    System.out.println("Ataques disponíveis para " + atacante.getNome() + ":");
    for (int i = 0; i < ataquesDisponiveis.size(); i++) {
        System.out.println((i + 1) + " - " + ataquesDisponiveis.get(i).getNome());
    }

    // Jogador escolhe um ataque
    System.out.println("Escolha um ataque:");
    int escolhaAtaque = scanner.nextInt();

    // Obtém o ataque escolhido
    Ataque ataqueEscolhido = ataquesDisponiveis.get(escolhaAtaque - 1);

    // Executa o ataque no alvo
    int danoCausado = atacante.atacar(ataqueEscolhido, alvo);

    // Exibe o resultado do ataque
    System.out.println(atacante.getNome() + " usou " + ataqueEscolhido.getNome() +
            " causando " + danoCausado + " de dano. Vida restante de " + alvo.getNome() + ": " + alvo.getVida());
}

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
