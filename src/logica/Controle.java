package logica;
import DAO.*;
import java.awt.event.*;

/**
 * A classe Controle � respons�vel por distribuir as atividades do sistema por meio de  ouvintes. Precisa "conhecer" quem executar� as atividades. Neste caso, tem associa��o com a classe SaldoInicialBD, LancamentoBD e TipoCadastroBD.
 */
public class Controle
{
    private SaldoInicialBD saldoInicialBD;    
    private Conta          conta;
    private Lancamento     lancamento;
    private TipoCadastro   tipoCadastro;
    private LancamentoBD   lancamentoBD;
    private TipoCadastroBD tipoCadastroBD;
    
}