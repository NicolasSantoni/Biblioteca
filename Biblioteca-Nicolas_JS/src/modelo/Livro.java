
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rodri
 */
public class Livro {
  private int idLivro;
  private String titulo;
  private int anoLancamento;
  private int numeroPaginas;
  private String resumo;
  private String paisOrigem;
  private String idioma;
  private Connection conexao;

  public Livro() {
  }
  
  public Livro(Connection conexao){
    this.conexao = conexao;
  }

  public int getIdLivro() {
    return idLivro;
  }

  public void setIdLivro(int idLivro) {
    this.idLivro = idLivro;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public int getAnoLancamento() {
    return anoLancamento;
  }

  public void setAnoLancamento(int anoLancamento) {
    this.anoLancamento = anoLancamento;
  }

  public int getNumeroPaginas() {
    return numeroPaginas;
  }

  public void setNumeroPaginas(int numeroPaginas) {
    this.numeroPaginas = numeroPaginas;
  }

  public String getResumo() {
    return resumo;
  }

  public void setResumo(String resumo) {
    this.resumo = resumo;
  }

  public String getPaisOrigem() {
    return paisOrigem;
  }

  public void setPaisOrigem(String paisOrigem) {
    this.paisOrigem = paisOrigem;
  }

  public String getIdioma() {
    return idioma;
  }

  public void setIdioma(String idioma) {
    this.idioma = idioma;
  }
  
  public void setConexao(Connection conexao) {
    this.conexao = conexao;
  }
  
  public ResultSet obterListaLivros() throws SQLException{
    String sql = "select idLivro, titulo, anoLancamento, numeroPaginas, resumo, idioma, paisOrigem from livro";
    PreparedStatement requisicao = this.conexao.prepareStatement(sql);
    return requisicao.executeQuery();
  }
  
  public void incluiLivro() throws SQLException{
    String sql = "insert into livro (titulo, anoLancamento, numeroPaginas, resumo, idioma, paisOrigem) values(?, ?, ?, ?, ?, ?)";
    PreparedStatement requisicao = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    requisicao.setString(1, this.titulo);
    requisicao.setInt(2, this.anoLancamento);
    requisicao.setInt(3, this.numeroPaginas);
    requisicao.setString(4, this.resumo);
    requisicao.setString(5, this.idioma);
    requisicao.setString(6, this.paisOrigem);
    requisicao.executeUpdate();
    //Recuperando o id gerado...
    ResultSet resutltado = requisicao.getGeneratedKeys();
    if(resutltado.next())
      this.idLivro = resutltado.getInt(1);
  }
  
  public void atualizaLivro(int id) throws SQLException{
    String sql = "update livro set titulo = ?, anoLancamento = ?, numeroPaginas = ?, resumo = ?, idioma = ?, paisOrigem =? where idLivro="+id;
    PreparedStatement requisicao = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    requisicao.setString(1, this.titulo);
    requisicao.setInt(2, this.anoLancamento);
    requisicao.setInt(3, this.numeroPaginas);
    requisicao.setString(4, this.resumo);
    requisicao.setString(5, this.idioma);
    requisicao.setString(6, this.paisOrigem);
    requisicao.executeUpdate();
    ResultSet resutltado = requisicao.getGeneratedKeys();
    if(resutltado.next())
      this.idLivro = resutltado.getInt(1);
  }
  
  public void deletaLivro(int id) throws SQLException{
    String sql = "delete from livro where idLivro="+id;
    PreparedStatement requisicao = this.conexao.prepareStatement(sql);
    requisicao.executeUpdate();
  }
  
  
}
