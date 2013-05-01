package logica;

import DAO.Factory;
import DAO.FonteRenda;
import DAO.FonteRendaBD;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeam
 */
public class FonteRendaControle
{
    private FonteRenda fonteRenda;
    private FonteRendaBD fonteBD;
    
    public FonteRendaControle()
    {
        //isntancia dos objetos do modelo e DAO.
        fonteRenda = new FonteRenda();
        try
        {
            fonteBD = Factory.criarFonteRenda();
        }
        catch (SQLException ex)
        {
            System.out.println("Não foi possível criar a fonte de renda. " + ex);
        }
    }
    
     public void cadastrarFonteRenda(String nome) throws IllegalArgumentException
     {
         
         fonteRenda.setNome(nome);
         
        try 
        {
            fonteBD.inserir(fonteRenda);
            JOptionPane.showMessageDialog(null, "Fonte de Renda cadastrada.");
        }
        catch (SQLException ex)
        {
            System.out.println("erro ao cadastrar a Fonte de Renda "+ex);
        }
        catch(IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog(null, "Preencha o campo corretamente.");
        }
         
     }
}
