package logica;
import DAO.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import layout.ContaUI;
import layout.OuvinteSaldoInicial;
import layout.SaldoInicialUI;

/**
 * A classe Controle � respons�vel por distribuir as atividades do sistema por meio de  ouvintes. Precisa "conhecer" quem executar� as atividades. Neste caso, tem associa��o com a classe SaldoInicialBD, LancamentoBD e TipoCadastroBD.
 */
public class Controle
{
    private Factory        factor;
    private SaldoInicialBD saldoInicialBD;
    private SaldoInicial   [] saldoIni;
    private Lancamento     lancamento;
    private TipoCadastro   tipoCadastro;
    private LancamentoBD   lancamentoBD;
    private TipoCadastroBD tipoCadastroBD;
    
    //cria o objeto dos modelos (DAO).
    public Controle()
    {
        try
        {
            saldoInicialBD = Factory.criarSaldoInicial();
        }
        catch (SQLException ex)
        {
            System.out.println("Não foi possível criar o saldo inicial. " + ex);
        }
        
        //verificar 
        this.consultarSaldo();
    }
    
    public void consultarSaldo()
    {   
        SaldoInicialUI s = new SaldoInicialUI();

        try
        {
            int sd = saldoInicialBD.verificaExisteSaldoInicial();
            
            if(sd  != 0)
            {
                //this.inserirSaldoInicial(0.00);
                
                 s.setLocationRelativeTo(null);
                 s.setVisible(true);
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Erro ao verificar o saldo."+ ex);
        }
        catch (NullPointerException e)
        {
           // System.out.println(sd);
            System.out.println("controle.  "+ e);  
        }
          
    }
    public void inserirSaldoInicial(double val)
    {
       SaldoInicial saldo = new SaldoInicial(); 
       saldo.setSaldo(val); 
       try
        {
            saldoInicialBD.inserir(saldo);
            JOptionPane.showMessageDialog(null, "Saldo cadastrado.");
        } 
        catch (SQLException ex)
        {
           System.out.println("Erro ao cadastrar o saldo no banco de dados."+ex);
        }
    }
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