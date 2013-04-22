/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ouvintes;

import java.awt.event.*;
import layout.CredorUI;

/**
 *
 * @author Jeam
 */
public class OuvinteCredor implements ActionListener, MouseListener
{

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
    
}
