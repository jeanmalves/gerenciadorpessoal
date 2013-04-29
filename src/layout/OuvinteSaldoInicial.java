package layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import logica.Controle;


/**
 *
 * @author Jeam
 */
public class OuvinteSaldoInicial implements ActionListener
{
    private Controle crtl;
    private ContaUI formConta;
    
    //Atribui os objetos da interface gráfica conta(tela inicial) e 
    //o objto do controle.
    public OuvinteSaldoInicial(ContaUI c, Controle ctl)
    {
        formConta = c;
        crtl      = ctl;
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        //Obtem a fonte do evento.
        JButton saldo = (javax.swing.JButton)(ae.getSource());
        
        //declaração de variáveis locais.
        BigDecimal val = null;
        double valor;
        
        //testa se é o evento do botão correto.
        if(ae.getSource() == saldo)
        {
            //Obtem o valor do campo. Caso seja vazio informa o usuário.   
            try
            {
                val = formConta.jnfSaldo.getValue();
            }
            catch (NullPointerException e)
            {
                JOptionPane.showMessageDialog(null, "Digite um valor.");
            }
            
             //Faz o cast para double.
            valor = val.doubleValue();
            
            //Faz a chamada do método para alterar o saldo. 
            crtl.alterarSaldoInicial(valor);
        }
    }
    
}
