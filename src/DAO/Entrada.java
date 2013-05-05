package DAO;

import DAO.FonteRenda;
import DAO.Categoria;

/**
 * Classe derivada da classe Lan�amento. Agrega v�rias fontes de renda para fins espec�ficos de registro.
 */
public class Entrada extends Lancamento
{
	protected FonteRenda  fonte;
        protected int     id;
 
        public Entrada(String dt, double vl, String desc, Categoria cat, FonteRenda  fr)
        {
            //cosntrutora da classe base.
            super(dt,vl,desc,cat);
            
            //instancia o objeto FonteRenda para agregação
            this.fonte = fr;// = fr.setId(n);//new FonteRenda[fr.length];
            
           /* int i = 0;
        
            while(i < fr.length)
            {
                this.fonte[i] = fr[i];
                i++;
            }*/
        }
        
        public void setData(String dt)
        {
            data = dt;
        }
        
        public void setId(int i)
        {
            id = i;
        }
        /*public void setCategoria (Categoria ct)
        {
            categoria = ct;
        }*/
        
        public void setFonteRenda(FonteRenda ft)
        {
            fonte = ft;
        }
        
        public void setDescricao(String desc)
        {
            
            descricao = desc;
        }
        
        public void SetValor(double val)
        {
            valor = val;
        }

}
