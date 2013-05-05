/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Jeam
 */
public class CredorBD
{
    private ConexaoBD conexao;
    
    public CredorBD() throws SQLException
    {
        conexao = ConexaoBD.getInstance();
    }
    
    public void inserir(Credor obj) throws SQLException
    {
        //conecta com o banco de dados.
        conexao.conectar();
        Statement st = conexao.getStatement();
       
        try
        {
            st.executeUpdate("INSERT INTO gf_credor (crd_nome) VALUES('"+obj.getNome()+"')");
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
    
    public void alterar(Credor obj)
    {

    }

    public Credor buscar(Credor obj)
    {
            return null;
    }
    
    public ArrayList<Credor> listarCredor() throws SQLException
    {   
        //conecta com o banco de dados.
        conexao.conectar();
        Statement st = conexao.getStatement();
        String buscaSql = "SELECT * FROM gf_credor";

        //interface ResultSet permite colher os resultados da execução de nossa query no banco de dados.
        ResultSet dados = st.executeQuery(buscaSql);
           
        //Cria um ArrayList de Credores para retornar com os dados do banco.
  
        ArrayList <Credor> listaCred = new ArrayList<Credor>();  
      
        // O método next() informa se houve resultados e posiciona o cursor do banco  
       // na próxima linha disponível para recuperação
        while(dados.next())
        {
            //cria um objeto para cada fonte de renda.
            Credor cred = new Credor();
            
            cred.setId(dados.getInt("crd_id"));
            cred.setNome(dados.getString("crd_nome"));
            listaCred.add(cred);
            
        }
       
        try 
        {
            conexao.desconectar();
        } 
        catch (Exception ex)
        {
            System.out.println("Erro ao desconectar do banco de dados" + ex);
        }
        return listaCred;  
    
    }
}
