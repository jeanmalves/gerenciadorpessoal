/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import DAO.SaldoInicial;
import DAO.Factory;
import DAO.SaldoInicialBD;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeam
 */
public class SaldoInicialControle
{
    private SaldoInicialBD saldoInicialBD;
    
    public SaldoInicialControle()
    {
         try
            {
                saldoInicialBD = Factory.criarSaldoInicial();
            }
            catch (SQLException ex)
            {
                System.out.println("Não foi possível criar o saldo inicial. " + ex);
            }
    }
    public void consultarSaldo()
    {    
        
        try
        {
            SaldoInicial sd = new SaldoInicial();
            sd = saldoInicialBD.buscar();
        }
        catch (SQLException ex)
        {
            System.out.println("Erro ao verificar o saldo."+ ex);
        }
        catch (NullPointerException e)
        {
            System.out.println("nao foi possivel criar o objeto SaldoInicial"+e);  
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
