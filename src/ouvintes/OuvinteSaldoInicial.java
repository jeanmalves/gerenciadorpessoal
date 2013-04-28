/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import logica.Controle;
import layout.ContaUI;
import logica.JNumberFormatField;

/**
 *
 * @author Jeam
 */
public class OuvinteSaldoInicial implements ActionListener
{
    private Controle crtl;
    private ContaUI formConta;
    
    public OuvinteSaldoInicial(ContaUI c)
    {
        formConta = c;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       /*
        JNumberFormatField jnfSaldo;
        BigDecimal val;
        double valor;
        //Obtem a fonte do evento.
        javax.swing.JButton saldo = (javax.swing.JButton)(ae.getSource());
        
       jnfSaldo =  formConta.getJmfSaldo();
        
        if(ae.getSource() == saldo)
        {
            val = jnfSaldo.getValue();
            valor = val.doubleValue();
           
            try {
                this.crtl.inserirSaldoInicial(valor);
            } catch (Exception ex) {
                Logger.getLogger(OuvinteSaldoInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
    }
    
}
