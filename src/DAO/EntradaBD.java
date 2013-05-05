/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;

/**
 *
 * @author Jeam
 */
public class EntradaBD
{
    private ConexaoBD conexao;
    
    public EntradaBD() throws SQLException
    {
        conexao = ConexaoBD.getInstance();
    }
    
     public void inserir(Entrada obj) throws SQLException
    {
        //conecta com o banco de dados.
        conexao.conectar();
        Statement st = conexao.getStatement();
       
        try
        {
            st.executeUpdate("INSERT INTO gf_entrada (fre_id, ctg_id, ent_data, ent_valor, ent_descricao) "+
                             "VALUES('"+obj.fonte.getId()+"','"+obj.categoria.getId()+"','"+obj.getData()+"','"+
                             obj.getValor()+"','"+obj.getDescricao()+"')");
        }
        catch(SQLSyntaxErrorException e)
        {
            System.out.println("erro de sintax mysql ");
        }
         try 
        {
            conexao.desconectar();
        }
        catch (Exception ex)
        {
            System.out.println("Erro ao desconectar do banco de dados" + ex);
        }
    } 
    
    
}
