package logica;

import DAO.Categoria;
import DAO.Entrada;
import DAO.EntradaBD;
import DAO.Factory;
import DAO.FonteRenda;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeam
 */
public class EntradaControle
{
    private EntradaBD entradaBD;
    
    public EntradaControle()
    {
        try
        {
            entradaBD = Factory.criarEntrada();
        }
        catch (SQLException ex)
        {
            System.out.println("Não foi possível criar entrada. " + ex);
        }
    }
    
    public void cadastrarEntrada(String dt, double vl, String desc, Categoria cat, FonteRenda  fr )
    {
        //objeto criado para inserir os dados.
        Entrada ent = new Entrada(dt,vl, desc, cat, fr );
        
        //trata exceção SQL e argumento invalido ou nao permitido.
        try
        {
            entradaBD.inserir(ent);
            JOptionPane.showMessageDialog(null, "Entrada cadastrada");
        }
        catch (SQLException ex)
        {
            System.out.println("erro ao cadastrar a entrada "+ex);
            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente.");
        }
        catch(IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente.");
        }
    }
    
   
}
