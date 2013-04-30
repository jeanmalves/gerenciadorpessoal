package DAO;


/**
 * Classe derivada da classe TipoCadastro. Herda os atributos e m�todos de TipoCadastro e impelmenta suas particularidades.
 */
public class Categoria extends TipoCadastro
{
    private int tipo;

    public boolean setTipo(int t)
    {
        this.tipo = t;
        return true;
    }

    public int getTipo()
    {
        return this.tipo;
    }
}
