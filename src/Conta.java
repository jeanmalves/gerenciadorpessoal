package java;

/**
 * A classe Conta agrega lançamentos do tipo Lancamento(Entrada e Saida). Realiza os cálculos de total de receitas, total de despesas, o resultado no mês(entradas - saidas), gera relatorios e também o saldo disponível.
 */
public class Conta {

	private SaldoInicial saldoIni;

	private double saldo;

	private double resultado;

	private Lancamento registro[ ];

	private SaldoInicial saldoInicial;

	public conta(SaldoInicial saldoIni) {

	}

	public double totalReceita() {
		return 0;
	}

	public double totalDespesa() {
		return 0;
	}

	public boolean calcResultado() {
		return false;
	}

	public void calcSaldo() {

	}

	public double getSaldo() {
		return 0;
	}

	public String relatorio() {
		return null;
	}

}
