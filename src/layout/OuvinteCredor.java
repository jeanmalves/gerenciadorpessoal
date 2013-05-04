package layout;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import layout.CredorUI;
import logica.CredorControle;

/**
 *
 * @author Jeam
 */
public class OuvinteCredor implements ActionListener
{

    private CredorControle ctrl;
    private CredorUI credorUI;
    
    public OuvinteCredor(CredorUI cr)
    {
        ctrl    = new CredorControle(); 
        credorUI = cr;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       //Obtem a fonte do evento.
        JButton credor  = (JButton)(e.getSource());
        
        //Declaração de variáveis e objetos.
        String nome = null;
               
         //testa se é o evento do botão correto.
        if(e.getSource() == credor)
        {
            try
            {
                //atribuo a variavel nome os valores do jTextField do formulario.
                nome = credorUI.jtfNomeCredor.getText();
            }
            catch(NullPointerException n)
            {
                //exibe ao usuario a mensagem de restrição caso haja algum valor vazio.
                JOptionPane.showMessageDialog(null, "É preciso preencher os campos.");
            }
            catch(IllegalArgumentException i)
            {
                //exibe ao usuario a mensagem de restrição caso haja algum valor não permitido pelos campos.
                JOptionPane.showMessageDialog(null, "Informe um valor válido.");
            }
            
            //Cadastra a fonte de renda no banco de dados.
            ctrl.cadastrarCredor(nome);
            
            //limpa os dados do formulario.
            credorUI.jtfNomeCredor.setText("");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        
    }

    //Métodos Interface MouseListener .
    @Override
    public void mouseClicked(MouseEvent me)
    {
         // Obtem a fonte do evento;  
        javax.swing.JMenu cred = (javax.swing.JMenu)(me.getSource());   
        
        //instancia do objeto da janela CredorUI  
         CredorUI credor = new CredorUI();
         
        //Verfica se a fonte do evento é o atributo do menu credores.  
        if(me.getSource() == cred)
            credor.setLocationRelativeTo(null);
            credor.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}
    */
}
