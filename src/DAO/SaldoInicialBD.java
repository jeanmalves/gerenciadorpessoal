package DAO;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.SaldoInicial;
/**
 * Classe para cadastrar, zerar, alterar e buscar o saldo inicial que o sistema iniciar�. Existe uma associa��o pois seus m�todos recebem como par�metro o objeto do tipo SaldoIncial.
 */
public class SaldoInicialBD
{
    private ConexaoBD conexao;
    
    public SaldoInicialBD() throws SQLException
    {
        conexao = ConexaoBD.getInstance();
    }

    public void inserir(SaldoInicial obj) throws SQLException
    {
        conexao.conectar();
        Statement st = conexao.getStatement();
        st.executeUpdate((new StringBuilder()).append("INSERT INTO gf_saldoinicial(sld_valor) VALUES('").append(obj.getSaldo()).append("')").toString());
        try 
        {
            conexao.desconectar();
        }
        catch (Exception ex)
        {
            System.out.println("Erro ao desconectar do banco de dados" + ex);
        }
    }

    public void zerarSaldo(SaldoInicial obj)
    {

    }

    public void alterar(SaldoInicial obj) throws SQLException
    {          
        conexao.conectar();
        Statement st = conexao.getStatement();
        st.executeUpdate((new StringBuilder()).append("UPDATE gf_saldoinicial SET sld_valor = ").append(obj.getSaldo()).toString());
        try 
        {
            conexao.desconectar();
        }
        catch (Exception ex)
        {
           System.out.println("Erro ao desconectar do banco de dados" + ex);
        }
    }

    public SaldoInicial buscar() throws SQLException
    {
        Statement st = conexao.getStatement();
        String buscaSql = "SELECT sld_valor FROM gf_saldoinicial LIMIT 1";

        //interface ResultSet permite colher os resultados da execução de nossa query no banco de dados.
        ResultSet dados = st.executeQuery(buscaSql);
        
        //instanciamos o objeto SaldoInicial para retornar com os dados do banco.
        SaldoInicial sd = new SaldoInicial();
        
        // O método next() informa se houve resultados e posiciona o cursor do banco  
       // na próxima linha disponível para recuperação
        if(dados.next())
        {
            sd.setSaldo(dados.getDouble("sld_valor"));
            
            try {
                conexao.desconectar();
            } 
            catch (Exception ex)
            {
                System.out.println("Erro ao desconectar do banco de dados" + ex);
            }
            
            return sd;
        }
        else
        {
            try 
            {
                conexao.desconectar();
            } 
            catch (Exception ex)
            {
                System.out.println("Erro ao desconectar do banco de dados" + ex);
            }
            return null;  
        }
    }
}
