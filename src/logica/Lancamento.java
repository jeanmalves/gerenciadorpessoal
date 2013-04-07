package logica;

/**
 * Classe base para os lan�amentos. Cada lan�amento herda os m�todos gen�ricos e implementa m�todos em sua particularidade.
 */
public class Lancamento
{
    protected String data;
    protected String descricao;
    protected Categoria[] TipoCategoria;
    protected double valor;
    
    public Lancamento(String d, double v, String desc, Categoria cat)
    {
        int i = 0;
        
        this.data      = d;
        this.valor     = v;
        this.descricao = desc;
        
        while(cat)
        {
            this.TipoCategoria[i] = cat;
            i++;
        }
    }
    
    public Lancamento getLancamento()
    {
        return null;
    }
}
