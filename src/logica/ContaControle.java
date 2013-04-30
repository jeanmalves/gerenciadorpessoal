package logica;

import DAO.Categoria;
import DAO.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import layout.ContaUI;
import layout.OuvinteSaldoInicial;
import layout.SaldoInicialUI;

/**
 * A classe Controle � respons�vel por distribuir as atividades do sistema por meio de  ouvintes. Precisa "conhecer" quem executar� as atividades. Neste caso, tem associa��o com a classe SaldoInicialBD, LancamentoBD e TipoCadastroBD.
 */
public class ContaControle
{
   /* private Factory        factor;
    private SaldoInicialBD saldoInicialBD;
    private CategoriaBD    categoriaBD;
    private Lancamento     lancamento;
    private LancamentoBD   lancamentoBD;*/
    private ContaUI conta;
   

    public ContaControle()
    { 
       
    }
    public void contaUI(ContaUI c)
    {
        this.conta = c;
    }
    
  
    
}