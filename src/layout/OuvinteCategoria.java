package layout;

import java.awt.event.*;
import layout.CategoriaUI;

/**
 *
 * @author Jeam
 */
public class OuvinteCategoria implements ActionListener, MouseListener
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
        javax.swing.JMenu cat = (javax.swing.JMenu)(me.getSource());   
        
        //instancia do objeto da janela CredorUI  
         CategoriaUI categoria = new CategoriaUI();
         
        //Verfica se a fonte do evento é o atributo do menu credores.  
        if(me.getSource() == cat)
            categoria.setLocationRelativeTo(null);
            categoria.setVisible(true);
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
