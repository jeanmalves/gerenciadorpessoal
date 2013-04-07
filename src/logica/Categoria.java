package logica;

/**
 * Classe derivada da classe TipoCadastro. Herda os atributos e m�todos de TipoCadastro e impelmenta suas particularidades.
 */
public class Categoria extends TipoCadastro
{
    private byte tipo;

    public boolean setTipo(byte t)
    {
        this.tipo = t;
        return true;
    }

    public byte getTipo()
    {
        return this.tipo;
    }
}
