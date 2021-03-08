/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import banco.Banco;

/**
 *
 * @author rodri
 */
public class TesteConexao {
  public static void main(String[] args) {
    Banco bd = new Banco("localhost", "3306", "root", "Nicolas13", "acervo");
    bd.realizaConexao();
    if(bd.getStatusConexao()){
      System.out.println("Conectado com sucesso!");
    }
    else{
      System.out.println("Algo deu errado "+bd.getMensagemErro());
    }
  }
}
