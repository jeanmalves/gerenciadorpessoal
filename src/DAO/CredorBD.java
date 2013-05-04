/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;

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
    
}
