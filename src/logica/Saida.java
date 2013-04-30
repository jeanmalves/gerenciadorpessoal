package logica;

import DAO.Categoria;

/**
 * Classe derivada da classe Lan�amento. Agrega v�rios credores para fins espec�ficos de registro.
 */
public class Saida extends Lancamento
{
    private Credor [] credor;
    
    public Saida(String dt, double vl, String desc, Categoria[] cat, Credor [] cd)
    {
        //cosntrutora da classe base.
        super(dt,vl,desc,cat);
        
        //instancia o objeto Credor para agregação
        this.credor = new Credor[cd.length];
        int i = 0;
        
        while(i < cd.length)
        {
            this.credor[i] = cd[i];
            i++;
        }
    }
}
