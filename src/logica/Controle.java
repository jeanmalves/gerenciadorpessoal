package logica;

/**
 * A classe Controle � respons�vel por distribuir as atividades do sistema por meio de  ouvintes. Precisa "conhecer" quem executar� as atividades. Neste caso, tem associa��o com a classe SaldoInicialBD, LancamentoBD e TipoCadastroBD.
 */
public class Controle
{
	private Conta conta;

	private Lancamento lancamento;

	private TipoCadastro tipoCadastro;

	private SaldoInicial saldoInicial;

	private ContaUI contaUI;

	private SaldoInicialUI saldoInicialUI;

	private FonteRendaUI fonteRendaUI;

	private CredorUI credorUI;

	private CategoriaUI categoriaUI;

	private SaidaUI saidaUI;

	private EntradaUI entradaUI;

	private SaldoInicialBD saldoInicialBD;

	private LancamentoBD lancamentoBD;

	private TipoCadastroBD tipoCadastroBD;

}
