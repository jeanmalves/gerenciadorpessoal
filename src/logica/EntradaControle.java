package logica;

import DAO.Entrada;
import DAO.EntradaBD;
import DAO.Factory;
import DAO.FonteRenda;
import java.sql.SQLException;

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
    
   
}
