/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import DAO.Categoria;
import DAO.CategoriaBD;
import DAO.Credor;
import DAO.CredorBD;
import DAO.Factory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import logica.SaidaControle;

/**
 *
 * @author Jeam
 */
public class OuvinteSaida  implements ActionListener
{
    private SaidaControle ctrl;
    private SaidaUI       saidaUI;
    
    public OuvinteSaida(SaidaUI sd)
    {
        saidaUI = sd;
        ctrl      = new SaidaControle();
        this.carregarJComboboxCredor();
        this.carregarJComboboxCategoria();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
         //Obtem a fonte do evento.
        JButton sd = (javax.swing.JButton)(ae.getSource());
        
        //variaveis locais e referências de objetos.
        String      data = null;
        Date        dt = null;
        String      descricao = null;
        Credor      credor = null ;
        Categoria   tipoCategoria = null;
        BigDecimal  val = null;
        double      valor = 0;

        //instancia de classe para formatar datas.
        SimpleDateFormat data1 = new SimpleDateFormat( "dd/MM/yyyy" );  
         data          = saidaUI.jtfData.getText();
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
          
       
         //testa se é o evento do botão correto.
        if(ae.getSource() == sd)
        {
            try
            {
                    //atribuo a variavel os campos do formulario.
                 
                credor        = (Credor) saidaUI.jcbCredor.getSelectedItem();
                tipoCategoria = (Categoria) saidaUI.jcbCategoria.getSelectedItem();
                descricao     = saidaUI.jtfDescricao.getText();
                val           = saidaUI.jnfValor.getValue();
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
            
            ctrl.cadastrarSaida(data, valor, descricao, tipoCategoria, credor);
            
             //limpa os campos do formulario.
            saidaUI.jtfData.setText("");
            saidaUI.jcbCredor.setSelectedIndex(0);
            saidaUI.jcbCategoria.setSelectedIndex(0);
            saidaUI.jtfDescricao.setText("");
            saidaUI.jnfValor.setText("");
        }
    }
    
     public void carregarJComboboxCredor()
     {
        //referencia para o objeto DAO. 
        CredorBD credBD = null; 
       
        try
        {
            //Cria o DAO FonteRenda
            credBD = Factory.criarCredor();
        }
        catch (SQLException ex)
        {
            System.out.println("Não foi possível criar credor. " + ex);
        }
        
        //cria um ArrayList para trabalhar os dados vindo do banco.
        ArrayList <Credor> dados = new ArrayList<Credor>(); 
        
        try
        {
           //Metodo que retorna a consulta das fontes de renda cadastradas.
           dados = credBD.listarCredor();
            
           DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            //Carrega com os dados o JComboBox.
           for(int i = 0; i < dados.size(); i++)
           {
               Credor cred = dados.get(i);
               
               //adiciona os dados no model.
              // modelo.addElement(dados.get(i).getId()+" - "+dados.get(i).getNome());
               modelo.addElement(cred);
           }
           
           saidaUI.jcbCredor.setModel(modelo);
        }
        catch (SQLException ex)
        {
            System.out.println("Não foi possível listar credores. " + ex);
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
           //Metodo que retorna a consulta das categorias cadastradas.
           //@parametro: tipo 2: Saida . 
           dados = catBD.listarCategorias(2);
            
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
           
           saidaUI.jcbCategoria.setModel(modelo);
           
        }
        catch (SQLException ex)
        {
            System.out.println("Não foi possível listar categoria. " + ex);
        }
     }
}
