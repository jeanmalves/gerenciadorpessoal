package DAO;

import DAO.SaldoInicial;

/**
 * A classe Conta agrega lan�amentos do tipo Lancamento(Entrada e Saida). Realiza os c�lculos de total de receitas, total de despesas, o resultado no m�s(entradas - saidas), gera relatorios e tamb�m o saldo dispon�vel.
 */
public class Conta
{
    private SaldoInicial saldoIni;
    private double saldo;
    private double resultado;
    private Lancamento [] registro;	
    private SaldoInicial saldoInicial;

    public Conta(SaldoInicial saldo)
    {

    }

    public double totalReceita()
    {
            return 0;
    }

    public double totalDespesa()
    {
            return 0;
    }

    public boolean calcResultado()
    {
            return false;
    }

    public void calcSaldo()
    {

    }

    public double getSaldo()
    {
            return 0;
    }

    public String relatorio()
    {
            return null;
    }
}
