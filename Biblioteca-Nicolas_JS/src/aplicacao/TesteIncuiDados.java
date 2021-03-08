/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import banco.Banco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import modelo.Livro;

/**
 *
 * @author rodri
 */
public class TesteIncuiDados {
  public static void main(String[] args) {
    Banco bd = new Banco("localhost", "3306", "root", "123456", "acervo");
    Scanner ler = new Scanner(System.in);
    bd.realizaConexao();
    if(bd.getStatusConexao()){
      System.out.println("Conectado com sucesso!");
      Livro livro = new Livro(bd.getConexao());
      //titulo, anoLancamento, numeroPaginas, resumo, idioma, paisOrigem
      System.out.print("Entre com o título do livro: ");
      String titulo = ler.nextLine();
      System.out.print("Entre com o resumo do livro: ");
      String resumo = ler.nextLine();
      System.out.print("Entre com o idioma do livro: ");
      String idioma = ler.nextLine();
      System.out.print("Pais de origem: ");
      String paisOrigem = ler.nextLine();
      System.out.print("Entre com o ano de lançamento do livro: ");
      int anoLancamento = ler.nextInt();
      System.out.print("Entre com o número de páginas do livro: ");
      int numeroPaginas = ler.nextInt();
      livro.setTitulo(titulo);
      livro.setResumo(resumo);
      livro.setPaisOrigem(paisOrigem);
      livro.setNumeroPaginas(numeroPaginas);
      livro.setIdioma(idioma);
      livro.setAnoLancamento(anoLancamento);
      
      try{
        livro.incluiLivro();
        System.out.println("Livro cadastrado com sucesso e obteve o id "+livro.getIdLivro());
      }
      catch(SQLException e){
        System.out.println("Houve um erro ao salvar o livro");
      }
    }
    else{
      System.out.println("Algo deu errado "+bd.getMensagemErro());
    }
  }
}
