/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import DAO.Categoria;
import DAO.CategoriaBD;
import DAO.Factory;
import DAO.FonteRenda;
import DAO.FonteRendaBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
         //Obtem a fonte do evento.
        JButton ent = (javax.swing.JButton)(ae.getSource());
        
        //variaveis locais e referências de objetos.
        String      data = null;
        Date        dt = null;
        String      descricao = null;
        FonteRenda  fonteRenda = null ;
        Categoria   tipoCategoria = null;
        BigDecimal  val = null;
        double      valor = 0;

         //testa se é o evento do botão correto.
        if(ae.getSource() == ent)
        {
            //instancia de classe para formatar datas.
            SimpleDateFormat data1 = new SimpleDateFormat( "dd/MM/yyyy" );  
            data          = entradaUI.jtfData.getText();
            try
            {
                dt = data1.parse(data);
                SimpleDateFormat data2 = new SimpleDateFormat( "yyyy-MM-dd" );   
                data = data2.format(dt);
            }
            catch (ParseException ex)
            {
                System.out.println("Erro ao converte a data"+ex);
                 JOptionPane.showMessageDialog(null, "É preciso preencher o campo Data.");
            }
            
            try
            {
                    //atribuo a variavel os campos do formulario.
                 
                fonteRenda    = (FonteRenda) entradaUI.jcbFonteRenda.getSelectedItem();
                tipoCategoria = (Categoria) entradaUI.jcbCategoria.getSelectedItem();
                descricao     = entradaUI.jtfDescricao.getText();
                val           = entradaUI.jnfValor.getValue();
                //Faz o cast para double.
                valor = val.doubleValue();
                
            }
            catch(NullPointerException e)
            {
                //exibe ao usuario a mensagem de restrição caso haja algum valor vazio.
                JOptionPane.showMessageDialog(null, "É preciso preencher os campos.");
            }
            catch(IllegalArgumentException e)
            {
                //exibe ao usuario a mensagem de restrição caso haja algum valor não permitido pelos campos.
                JOptionPane.showMessageDialog(null, "Informe um valor válido.");
            }
            
            ctrl.cadastrarEntrada(data, valor, descricao, tipoCategoria, fonteRenda);
            
             //limpa os campos do formulario.
            entradaUI.jtfData.setText("");
            entradaUI.jcbFonteRenda.setSelectedIndex(0);
            entradaUI.jcbCategoria.setSelectedIndex(0);
            entradaUI.jtfDescricao.setText("");
            entradaUI.jnfValor.setText("");
        }
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
               FonteRenda fonte = dados.get(i);
               
               //adiciona os dados no model.
              // modelo.addElement(dados.get(i).getId()+" - "+dados.get(i).getNome());
               modelo.addElement(fonte);
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
        CategoriaBD catBD = null; 
       
        try
        {
            //Cria o DAO Categoria.
            catBD = Factory.criarCategoria();
        }
        catch (SQLException ex)
        {
            System.out.println("Não foi possível criar categoria. " + ex);
        }
        
        //cria um ArrayList para trabalhar os dados vindo do banco.
        ArrayList <Categoria> dados = new ArrayList<Categoria>(); 
        
        try
        {
           //Metodo que retorna a consulta das categorias cadastradas passando 
           //@parametro: tipo 1: Entrada .
           dados = catBD.listarCategorias(1);
            
           DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            //Carrega com os dados o JComboBox.
           for(int i = 0; i < dados.size(); i++)
           {
               Categoria cat;
               cat = dados.get(i);
               //adiciona os dados no model.
               modelo.addElement(cat);
               //modelo.addElement(dados.get(i).getId()+" - "+dados.get(i).getNome());
           }
           
           entradaUI.jcbCategoria.setModel(modelo);
           
        }
        catch (SQLException ex)
        {
            System.out.println("Não foi possível listar categoria. " + ex);
        }
     }
}
