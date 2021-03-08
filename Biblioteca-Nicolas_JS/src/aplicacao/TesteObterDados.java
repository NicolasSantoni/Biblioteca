/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import banco.Banco;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Livro;

/**
 *
 * @author rodri
 */
public class TesteObterDados {
  public static void main(String[] args) {
    Banco bd = new Banco("localhost", "3306", "root", "Nicolas13", "acervo");
    bd.realizaConexao();
    if(bd.getStatusConexao()){
      System.out.println("Conectado com sucesso!");
      Livro livro = new Livro(bd.getConexao());
      try{
        ResultSet listaLivros = livro.obterListaLivros();
        while(listaLivros.next()){
          System.out.println("Id do livro: "+listaLivros.getInt("idLivro"));
          System.out.println("Título do livro: "+listaLivros.getString("titulo"));
          System.out.println("Ano de lançamento: "+listaLivros.getInt("anoLancamento"));
          System.out.println("Número de páginas: "+listaLivros.getInt("numeroPaginas"));
          System.out.println("Resumo: "+listaLivros.getString("resumo"));
          System.out.println("Idioma: "+listaLivros.getString("idioma"));
          System.out.println("Pais: "+listaLivros.getString("paisOrigem"));
          System.out.println("---------------------------------------------------------");
        }
      }
      catch(SQLException e){
        System.out.println("Houve um erro ao obter a lista de livros");
      }
    }
    else{
      System.out.println("Algo deu errado "+bd.getMensagemErro());
    }
  }
}
