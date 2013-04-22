package ouvintes;

import java.awt.event.*;
import layout.FonteRendaUI;
/**
 *
 * @author Jeam
 */
public class OuvinteFonteRenda implements ActionListener, MouseListener
{
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       /*javax.swing.JMenuItem fonte = (javax.swing.JMenuItem)(e.getSource());
       FonteRendaUI fr = new FonteRendaUI();
       
        if(e.getSource() == fonte)
            //fonte.setVisible(true);
            fr.setVisible(true);*/
    }
  
    
  //Métodos Interface MouseListener  
    @Override
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
     
}
