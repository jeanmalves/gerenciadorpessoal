package logica;

/**
 * Classe derivada da classe Lan�amento. Agrega v�rias fontes de renda para fins espec�ficos de registro.
 */
public class Entrada extends Lancamento
{
	private FonteRenda [] fonte;
 
        public Entrada(String dt, double vl, String desc, Categoria[] cat, FonteRenda [] fr)
        {
            //cosntrutora da classe base.
            super(dt,vl,desc,cat);
            
            //instancia o objeto FonteRenda para agregação
            this.fonte = new FonteRenda[fr.length];
            
            int i = 0;
        
            while(i < fr.length)
            {
                this.fonte[i] = fr[i];
                i++;
            }
        }        

}
