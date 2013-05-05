package DAO;
import java.sql.*;
import java.util.ArrayList;

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

    public void alterar(Categoria obj)
    {

    }

    public Categoria buscar(Categoria obj)
    {
            return null;
    }
    
     public ArrayList<Categoria> listarCategorias(int tipo) throws SQLException
    {   
        //conecta com o banco de dados.
        conexao.conectar();
        Statement st = conexao.getStatement();
        String buscaSql = "SELECT ctg_id, ctg_nome FROM gf_categoria WHERE ctg_tipo = '"+tipo+"'";

        //interface ResultSet permite colher os resultados da execução de nossa query no banco de dados.
        ResultSet dados = st.executeQuery(buscaSql);
           
        //Cria um ArrayList de Categoria para retornar com os dados do banco.
  
        ArrayList <Categoria> listaCat = new ArrayList<Categoria>();  
      
        // O método next() informa se houve resultados e posiciona o cursor do banco  
       // na próxima linha disponível para recuperação
        while(dados.next())
        {
            //cria um objeto para cada categoria.
            Categoria cat = new Categoria();
            
            cat.setId(dados.getInt("ctg_id"));
            cat.setNome(dados.getString("ctg_nome"));
            //cat.setTipo(dados.getInt("ctg_tipo"));
            listaCat.add(cat);
            
        }
       
        try 
        {
            conexao.desconectar();
        } 
        catch (Exception ex)
        {
            System.out.println("Erro ao desconectar do banco de dados" + ex);
        }
        return listaCat;  
    
    }
}