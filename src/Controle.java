package java;

/**
 * A classe Controle é responsável por distribuir as atividades do sistema por meio de  ouvintes. Precisa "conhecer" quem executará as atividades. Neste caso, tem associação com a classe SaldoInicialBD, LancamentoBD e TipoCadastroBD.
 */
public class Controle {

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
