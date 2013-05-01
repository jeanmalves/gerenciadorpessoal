package DAO;
import java.sql.*;

/**
 * Classe para cadastrar, alterar e buscar os tipos de cadastro(FonteRenda, Credor e Categoria ). Existe uma associa��o pois seus m�todos recebem como par�metro o objeto do tipo TipoCadastro.
 */
public class CategoriaBD
{
    private ConexaoBD conexao;
    
    public CategoriaBD() throws SQLException
    {
        conexao = ConexaoBD.getInstance();
    }
    
    public void inserir(Categoria obj) throws SQLException
    {
        //conecta com o banco de dados.
        conexao.conectar();
        Statement st = conexao.getStatement();
       
        try
        {
            st.executeUpdate("INSERT INTO gf_categoria(ctg_nome, ctg_tipo) VALUES('"+obj.getNome()+"','"+obj.getTipo()+"')");
        }
        catch(SQLSyntaxErrorException e)
        {
            System.out.println("erro desintax mysql ");
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

    public void alterar(Categoria obj)
    {

    }

    public Categoria buscar(Categoria obj)
    {
            return null;
    }
}