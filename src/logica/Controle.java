package logica;
import DAO.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import layout.ContaUI;
import ouvintes.OuvinteSaldoInicial;

/**
 * A classe Controle � respons�vel por distribuir as atividades do sistema por meio de  ouvintes. Precisa "conhecer" quem executar� as atividades. Neste caso, tem associa��o com a classe SaldoInicialBD, LancamentoBD e TipoCadastroBD.
 */
public class Controle
{
    private Factory        factor;
    private SaldoInicialBD saldoInicialBD;
    private SaldoInicial   saldoIni;
    private Lancamento     lancamento;
    private TipoCadastro   tipoCadastro;
    private LancamentoBD   lancamentoBD;
    private TipoCadastroBD tipoCadastroBD;
    
    //cria o objeto dos modelos (DAO).
    public Controle()
    {
        saldoInicialBD = Factory.criarSaldoInicial();
        
        //verificar 
        //this.consultarSaldo();
    }
    
    public void consultarSaldo()
    {
        try
        {
            saldoIni = saldoInicialBD.buscar();
            double sd = saldoIni.getSaldo();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NullPointerException e)
        {
            //this.inserirSaldoInicial(0.00);
        }
 
    }
   /* public void inserirSaldoInicial(double val)
    {
       saldoIni.setSaldo(val); 
       try
        {
            saldoInicialBD.inserir(saldoIni);
        } 
        catch (SQLException ex)
        {
           System.out.println("Erro ao cadastrar o saldo no banco de dados."+ex);
        }
    }*/
     public void alterarSaldoInicial(double val)
    {
        SaldoInicial sd = new SaldoInicial();
        sd.setSaldo(val);
        
        try
        {
            saldoInicialBD.alterar(sd);
             JOptionPane.showMessageDialog(null, "O saldo foi alterado.");
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o saldo no banco de dados.");
        }
    }
}