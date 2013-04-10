package logica;

/**
 * Classe base para os lan�amentos. Cada lan�amento herda os m�todos gen�ricos e implementa m�todos em sua particularidade.
 */
public class Lancamento
{
    protected String data;
    protected String descricao;
    protected double valor;
    protected Categoria [] categoria;
    
    //construtora recebe os dados do lançamento como: data, descrição, valor e um array de categorias.
    public Lancamento(String d, double v, String desc, Categoria[] cat)
    {
        int i = 0;
        //instancia o objeto Categoria para agregação
        this.categoria = new Categoria[cat.length];
        
        this.data      = d;
        this.valor     = v;
        this.descricao = desc;
        
        while(i < cat.length)
        {
            this.categoria[i] = cat[i];
            i++;
        }
    }
    // rever este método. Faz sentido?
    /*public Lancamento getLancamento()
    {
        return categoria;
    }*/
}
