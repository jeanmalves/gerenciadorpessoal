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
public class SaidaBD
{
    private ConexaoBD conexao;
    
    public SaidaBD() throws SQLException
    {
        conexao = ConexaoBD.getInstance();
    }
    
     public void inserir(Saida obj) throws SQLException
    {
        //conecta com o banco de dados.
        conexao.conectar();
        Statement st = conexao.getStatement();
       
        try
        {
            //comando SQL para cadastro, caso haja erro é lançada uma exception.
            st.executeUpdate("INSERT INTO gf_saida (ctg_id, crd_id, sai_data, sai_valor, sai_descricao) "+
                             "VALUES('"+obj.categoria.getId()+"','"+obj.credor.getId()+"','"+obj.getData()+"','"+
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
