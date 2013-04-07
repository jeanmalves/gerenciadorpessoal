/*
 * Classe para se conectar com a base de dados. Ao criar a conex�o, ela retorna uma inst�ncia da conex�o.
 */

package DAO;
import java.sql.*;

public class ConexaoBD
{
    private static ConexaoBD  instance = null;
    private        Connection conn;
    private        Statement  st;

    public static ConexaoBD getInstance()
    {
        if (instance == null) {
            instance = new ConexaoBD();
        }
        return instance;
    }

    public ConexaoBD()
    {
        try
        {
            //carrega o driverdo mysql
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Driver nao carregado " + e.getMessage());
            System.exit(0);
        }
        
        this.conn = null;
        this.st   = null;       
    }

    /*Método que cria um Statement
     * @return objeto da classe Statement    
     */
    private Statement criarStatement() throws SQLException
    {
        return conn.createStatement();
    }

    /*Método que retorna um Statement
     * @return objeto da classe Statement    
     */
    public Statement getStatement() throws SQLException
    {    
        return st;
    }

    //  Método que conecta ao banco de dados
    public void conectar() throws SQLException
    {
        try
        {   
            String dbUrl = "jdbc:mysql://localhost/gerenciadorpessoal";
            String user  = "root";
            String senha = "";

             // obter conexao
                conn = DriverManager.getConnection(dbUrl, user, senha);
                  st = criarStatement();
        }
        catch(SQLException e)
        {   
            System.out.println("A conexão falhou, verifique!");
            System.out.println(e.getMessage());
        }       
    }
    
    //Desconecta do banco de dados.
    public void desconectar() throws Exception
    {        
        try
        {
              st.close();
            conn.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
