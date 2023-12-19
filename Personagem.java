package Jogo;

import java.util.Arrays;
import java.util.List;

public class Personagem {
  private int vida;
  private int ataque;
  private String arma;

  public Personagem(String arma) {
    this.vida = 500;
    this.ataque = 0;
    this.arma = arma;
  }

  public int getVida() {
    return vida;
  }

  public void receberDano(int dano) {
    vida -= dano;
    if (vida < 0) {
      vida = 0;
    }
  }

  public boolean estaVivo() {
    return vida > 0;
  }

  public int getAtaque() {
    return ataque;
  }

  public void setAtaque(int ataque) {
    this.ataque = ataque;
  }

  public String getArma() {
    return arma;
  }

  public void setArma(String arma) {
    this.arma = arma;
  }
  public List <String> getArmas(){
	  return Arrays.asList(null);
  }
  
 public List<String> getAtaques(){
	  return Arrays.asList(null);
  }
 
 public int atacar(int ataque, Personagem alvo) {
	 return 0;
 }
 }
