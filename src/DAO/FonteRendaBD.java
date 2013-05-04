package DAO;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Jeam
 */
public class FonteRendaBD
{
    private ConexaoBD conexao;
    
    public FonteRendaBD() throws SQLException
    {
        conexao = ConexaoBD.getInstance();
    }
    
    public void inserir(FonteRenda obj) throws SQLException
    {
        //conecta com o banco de dados.
        conexao.conectar();
        Statement st = conexao.getStatement();
       
        try
        {
            st.executeUpdate("INSERT INTO gf_fonte_renda (fre_nome) VALUES('"+obj.getNome()+"')");
        }
        catch(SQLSyntaxErrorException e)
        {
            System.out.println("erro de sintax mysql ");
        }
         try 
        {
            conexao.desconectar();
        }
        catch (Exception ex)
        {
            System.out.println("Erro ao desconectar do banco de dados" + ex);
        }
    }
    
    public void alterar(FonteRenda obj)
    {

    }
    
    public FonteRenda buscar(FonteRenda obj)
    {
            return null;
    }
    
    public ArrayList<FonteRenda> listarFonteRenda() throws SQLException
    {   
        //conecta com o banco de dados.
        conexao.conectar();
        Statement st = conexao.getStatement();
        String buscaSql = "SELECT * FROM gf_fonte_renda";

        //interface ResultSet permite colher os resultados da execução de nossa query no banco de dados.
        ResultSet dados = st.executeQuery(buscaSql);
           
        //Cria um ArrayList de FonteRenda para retornar com os dados do banco.
  
        ArrayList <FonteRenda> listaFr = new ArrayList<FonteRenda>();  
      
        // O método next() informa se houve resultados e posiciona o cursor do banco  
       // na próxima linha disponível para recuperação
        while(dados.next())
        {
            //cria um objeto para cada fonte de renda.
            FonteRenda fr = new FonteRenda();
            
            fr.setId(dados.getInt("fre_id"));
            fr.setNome(dados.getString("fre_nome"));
            listaFr.add(fr);
            
        }
       
        try 
        {
            conexao.desconectar();
        } 
        catch (Exception ex)
        {
            System.out.println("Erro ao desconectar do banco de dados" + ex);
        }
        return listaFr;  
    
    }
    
}
