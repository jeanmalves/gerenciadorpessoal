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
        conexao.conectar();
        Statement st = conexao.getStatement();
        st.executeUpdate((new StringBuilder()).append("INSERT INTO gf_categoria(ctg_nome, ctg_tipo) VALUES('").append(obj.getNome()).append(",").append(obj.getTipo()).append("')").toString());
        
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