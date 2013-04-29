package logica;

/**
 * Classe que define o modelo de saldo inicial do programa. Inicialmente ser� zero, caso queira inserir um valor diferente � possivel alterar atrav�s do m�todo setSaldo. O m�todo getSaldo retorna o valor atualmente cadastrado.
 */
public class SaldoInicial
{
	private double saldoInicial;
   
	public void setSaldo(double val)
        {
            this.saldoInicial = val;  
	}

	public double getSaldo()
        {
            return saldoInicial;
	}
}