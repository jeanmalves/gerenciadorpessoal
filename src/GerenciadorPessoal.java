import DAO.*;
import logica.*;
import layout.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeam
 */
public class GerenciadorPessoal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConexaoBD cn = new ConexaoBD();
        ContaUI c = new ContaUI();
        c.setLocationRelativeTo(null);
        c.setVisible(true);
    }
}
