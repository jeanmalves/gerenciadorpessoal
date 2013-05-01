package layout;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import logica.CategoriaControle;


/**
 *
 * @author Jeam
 */
public class OuvinteCategoria implements ActionListener
{
    private CategoriaControle ctrl;
    private CategoriaUI categoria;
    
    //Passa o objeto da interface gráfica de Categorias.
    //e instancia o objeto que controla a categoria.
    public OuvinteCategoria(CategoriaUI c)
    {
        categoria = c;
        ctrl      = new CategoriaControle();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        //Obtem a fonte do evento.
        JButton cat          = (javax.swing.JButton)(ae.getSource());
        
        //Declaração de variáveis e objetos.
        String nome          = null;
        String tipoCategoria = null;
               
         //testa se é o evento do botão correto.
        if(ae.getSource() == cat)
        {
            try
            {
                //atribuo a variavel, nome os valores nome e tipo d acategoria,dos campos do formulario.
                nome          = categoria.jtfNomeCategoria.getText();
                tipoCategoria = categoria.jcbTipoCategoria.getSelectedItem().toString();
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
            
            //instancia o metodo para cadastrar a categoria.
            ctrl.cadastrarCategoria(nome, tipoCategoria);
            
            //limpa os campos do formulario.
            categoria.jtfNomeCategoria.setText("");
            categoria.jcbTipoCategoria.setSelectedIndex(0);
        }
    }

    
}
