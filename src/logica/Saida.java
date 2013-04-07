package logica;

/**
 * Classe derivada da classe Lan�amento. Agrega v�rios credores para fins espec�ficos de registro.
 */
public class Saida extends Lancamento
{

    private Credor[] credor;
    
    public Saida(String dt, double vl, String desc, Categoria cat, Credor cd)
    {
        int i=0;
        super(dt, vl, desc, cat);
        
        while(cd)
        {
            this.credor[i] = cd;
            i++;
        }
    }
}
