package DAO;

/**
 * Classe base de tipo de cadastro como fontes de renda, categoria com status do tipo receita ou despesa e credores.
 */
public class TipoCadastro
{
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
}