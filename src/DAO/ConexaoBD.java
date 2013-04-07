/*
 * Classe para se conectar com a base de dados. Ao criar a conex�o, ela retorna uma inst�ncia da conex�o.
 */
public class ConexaoBD {

	/**
	 * 
	 * 
	 * 
	 */
	private static ConexaoBD instance = null;

	private Conection conn;

	private Statement st;

	public static ConexaoBD getInstance() {
		return null;
	}

	public ConexaoBD() {

	}

	private Statement criarStatement() {
		return null;
	}

	public Statement getStatement() {
		return null;
	}

	public void conectar() {

	}

	public void desconectar() {

	}

}
