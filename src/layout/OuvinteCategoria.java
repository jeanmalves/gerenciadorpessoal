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
    
    private CategoriaUI categoria;
    
    public OuvinteCategoria(CategoriaUI c)
    {
        categoria = c;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        //Obtem a fonte do evento.
        JButton cat          = (javax.swing.JButton)(ae.getSource());
        
        //Declaração de variáveis e objetos.
        String nome          = null;
        String tipoCategoria = null;
        CategoriaControle ctrl  = new CategoriaControle();
        
         //testa se é o evento do botão correto.
        if(ae.getSource() == cat)
        {
            try
            {
                nome          = categoria.jtfNomeCategoria.getText();
                tipoCategoria = categoria.jcbTipoCategoria.getSelectedItem().toString();
            }
            catch(NullPointerException e)
            {
                JOptionPane.showMessageDialog(null, "É preciso preencher os campos.");
            }
            catch(IllegalArgumentException e)
            {
                JOptionPane.showMessageDialog(null, "Informe um valor válido.");
            }
            ctrl.cadastrarCategoria(nome, tipoCategoria);
        }
    }

    
}
