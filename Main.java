import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Bem-vindo ao Jogo de Luta!");

    System.out.println("Jogador 1, escolha seu personagem:");
    System.out.println("1 - Assassino");
    System.out.println("2 - Samurai");
    int escolhaPersonagem1 = scanner.nextInt();

    Personagem jogador1 = criarPersonagem(escolhaPersonagem1);
    mostrarArmasDisponiveis(jogador1);

    System.out.println("Jogador 2, escolha seu personagem:");
    System.out.println("1 - Assassino");
    System.out.println("2 - Samurai");
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
    } else {
      throw new IllegalArgumentException("Escolha de personagem inválida");
    }
  }

  private static void mostrarArmasDisponiveis(Personagem jogador) {
    System.out.println("Armas disponíveis para " + (jogador instanceof Assassino ? "Assassino" : "Samurai") + ":");
    if (jogador instanceof Assassino) {
      System.out.println("1 - Adaga");
      System.out.println("2 - Soco inglês");
    } else if (jogador instanceof Samurai) {
      System.out.println("1 - Katana");
      System.out.println("2 - Foice");
    }
  }

  private static void definirArma(Personagem jogador, int escolhaArma) {
    if (jogador instanceof Assassino && (escolhaArma == 1 || escolhaArma == 2)) {
      jogador.setArma(escolhaArma == 1 ? Assassino.ARMA_ADAGA : Assassino.ARMA_SOCO_INGLES);
    } else if (jogador instanceof Samurai && (escolhaArma == 1 || escolhaArma == 2)) {
      jogador.setArma(escolhaArma == 1 ? Samurai.ARMA_KATANA : Samurai.ARMA_FOICE);
    } else {
      throw new IllegalArgumentException("Escolha de arma inválida");
    }
  }

  private static void realizarAtaque(Personagem atacante, Personagem alvo, Scanner scanner) {
    // O restante do código permanece o mesmo
  }
}
