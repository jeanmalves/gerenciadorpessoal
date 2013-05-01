package layout;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import logica.FonteRendaControle;
/**
 *
 * @author Jeam
 */
public class OuvinteFonteRenda implements ActionListener
{
    private FonteRendaControle ctrl;
    private FonteRendaUI fonteUI;
    
    public OuvinteFonteRenda(FonteRendaUI fr)
    {
        ctrl    = new FonteRendaControle(); 
        fonteUI = fr;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       //Obtem a fonte do evento.
        JButton fonteRenda  = (JButton)(e.getSource());
        
        //Declaração de variáveis e objetos.
        String nome = null;
               
         //testa se é o evento do botão correto.
        if(e.getSource() == fonteRenda)
        {
            try
            {
                //atribuo a variavel nome os valores do jTextField do formulario.
                nome = fonteUI.jtfNomeFonteRenda.getText();
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
            ctrl.cadastrarFonteRenda(nome);
            
            //limpa os dados do formulario.
            fonteUI.jtfNomeFonteRenda.setText("");
        }
    }
  
    
  //Métodos Interface MouseListener  
  /*  @Override
    public void mouseClicked(MouseEvent me) 
    {
      // Obtem a fonte do evento;  
        javax.swing.JMenu fonte = (javax.swing.JMenu)(me.getSource());
      //instancia do objeto da janela FonteRendaUI  
       FonteRendaUI fr = new FonteRendaUI();
      
     //Verfica se a fonte do evento é o atributo do menu fonte de renda.  
        if(me.getSource() == fonte)
            fr.setLocationRelativeTo(null);
            fr.setVisible(true);
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
