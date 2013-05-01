package DAO;

import java.sql.*;

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

    public Categoria buscar(FonteRenda obj)
    {
            return null;
    }
    
}
