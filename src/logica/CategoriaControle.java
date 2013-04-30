/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import DAO.Categoria;
import DAO.CategoriaBD;
import DAO.Factory;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeam
 */
public class CategoriaControle {
    
    private Categoria cat;
    private CategoriaBD catBD; 
    public CategoriaControle()
    {
        cat = new Categoria();
        try
            {
                catBD = Factory.criarCategoria();
            }
            catch (SQLException ex)
            {
                System.out.println("Não foi possível criar o saldo inicial. " + ex);
            }
    }
    
     public void cadastrarCategoria(String nome, String tipo) throws IllegalArgumentException
     {
         
         cat.setNome(nome);
         
         if(tipo.equals("Receita"))
         {
             cat.setTipo(1);
         }
         else if(tipo.equals("Despesa"))
         {
             cat.setTipo(2);
         }
         JOptionPane.showMessageDialog(null, "Saldo cadastrado.");
     }
}
