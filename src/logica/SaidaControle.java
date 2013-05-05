/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import DAO.Categoria;
import DAO.Credor;
import DAO.Factory;
import DAO.Saida;
import DAO.SaidaBD;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeam
 */
public class SaidaControle
{
    private SaidaBD saidaBD;
    
    public SaidaControle()
    {
         try
        {
            saidaBD = Factory.criarSaida();
        }
        catch (SQLException ex)
        {
            System.out.println("Não foi possível criar saida. " + ex);
        }       
    }
    
    public void cadastrarSaida(String dt, double vl, String desc, Categoria cat, Credor cd )
    {
        //objeto criado para inserir os dados.
        Saida sd = new Saida(dt, vl, desc, cat, cd );
        
        //trata exceção SQL e argumento invalido ou nao permitido.
        try
        {
            saidaBD.inserir(sd);
            JOptionPane.showMessageDialog(null, "Saida cadastrada");
        }
        catch (SQLException ex)
        {
            System.out.println("erro ao cadastrar a saida "+ex);
            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente.");
        }
        catch(IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente.");
        }
    }
}
