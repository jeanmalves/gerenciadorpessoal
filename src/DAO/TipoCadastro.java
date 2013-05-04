package DAO;

/**
 * Classe base de tipo de cadastro como fontes de renda, categoria com status do tipo receita ou despesa e credores.
 */
public class TipoCadastro
{
    private int    id;
    private String nome;
        
    public boolean setNome(String n)
    {
        nome = n;
        return true;
    }

    public String getNome()
    {
        return nome;
    }
    
    public boolean setId(int n)
    {
        id = n;
        return true;
    }
    
    public int getId()
    {
        return id;
    }
}