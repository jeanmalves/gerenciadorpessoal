package logica;

import DAO.Credor;
import DAO.CredorBD;
import DAO.Factory;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeam
 */
public class CredorControle
{
    private Credor credor;
    private CredorBD credorBD;
    
     public CredorControle()
    {
        //isntancia dos objetos do modelo e DAO.
        credor = new Credor();
        try
        {
            credorBD = Factory.criarCredor();
        }
        catch (SQLException ex)
        {
            System.out.println("Não foi possível criar credor. " + ex);
        }
    }
    public void cadastrarCredor(String nome) throws IllegalArgumentException
    {

        credor.setNome(nome);

        try 
        {
            credorBD.inserir(credor);
            JOptionPane.showMessageDialog(null, "Credor cadastrado");
        }
        catch (SQLException ex) 
        {
            System.out.println("erro ao cadastrar credor " + ex);
        }
        catch (IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog(null, "Preencha o campo corretamente.");
        }

    }
}
