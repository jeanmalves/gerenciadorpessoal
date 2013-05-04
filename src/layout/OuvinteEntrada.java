/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import DAO.Categoria;
import DAO.CategoriaBD;
import DAO.Entrada;
import DAO.Factory;
import DAO.FonteRenda;
import DAO.FonteRendaBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import logica.EntradaControle;

/**
 *
 * @author Jeam
 */
public class OuvinteEntrada implements ActionListener
{
    private EntradaControle ctrl;
    private EntradaUI entradaUI;
    
    public OuvinteEntrada(EntradaUI ent)
    {
        entradaUI = ent;
        ctrl      = new EntradaControle();
        this.carregarJComboboxFonteRenda();
        this.carregarJComboboxCategoria();
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
    }
    public void carregarJComboboxFonteRenda()
     {
        //referencia para o objeto DAO. 
        FonteRendaBD fr = null; 
       
        try
        {
            //Cria o DAO FonteRenda
            fr = Factory.criarFonteRenda();
        }
        catch (SQLException ex)
        {
            System.out.println("Não foi possível criar fonte de renda. " + ex);
        }
        
        //cria um ArrayList para trabalhar os dados vindo do banco.
        ArrayList <FonteRenda> dados = new ArrayList<FonteRenda>(); 
        
        try
        {
           //Metodo que retorna a consulta das fontes de renda cadastradas.
           dados = fr.listarFonteRenda();
            
           DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            //Carrega com os dados o JComboBox.
           for(int i = 0; i < dados.size(); i++)
           {
               //adiciona os dados no model.
               modelo.addElement(dados.get(i).getId()+" - "+dados.get(i).getNome());
           }
           
           entradaUI.jcbFonteRenda.setModel(modelo);
           
        }
        catch (SQLException ex)
        {
            System.out.println("Não foi possível listar fonte de renda. " + ex);
        }
     }
     
     public void carregarJComboboxCategoria()
     {
        //referencia para o objeto DAO. 
        CategoriaBD cat = null; 
       
        try
        {
            //Cria o DAO Categoria.
            cat = Factory.criarCategoria();
        }
        catch (SQLException ex)
        {
            System.out.println("Não foi possível criar categoria. " + ex);
        }
        
        //cria um ArrayList para trabalhar os dados vindo do banco.
        ArrayList <Categoria> dados = new ArrayList<Categoria>(); 
        
        try
        {
           //Metodo que retorna a consulta das categorias cadastradas.
           dados = cat.listarCategorias();
            
           DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            //Carrega com os dados o JComboBox.
           for(int i = 0; i < dados.size(); i++)
           {
               //adiciona os dados no model.
               modelo.addElement(dados.get(i).getId()+" - "+dados.get(i).getNome());
           }
           
           entradaUI.jcbCategoria.setModel(modelo);
           
        }
        catch (SQLException ex)
        {
            System.out.println("Não foi possível listar categoria. " + ex);
        }
     }
}
