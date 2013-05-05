/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;

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
     
   //em fase de construção  
   /*  public ArrayList<Entrada> listarEntrada() throws SQLException
    {   
        //conecta com o banco de dados.
        conexao.conectar();
        Statement st = conexao.getStatement();
        String buscaSql = "SELECT * FROM gf_entrada";

        //interface ResultSet permite colher os resultados da execução de nossa query no banco de dados.
        ResultSet dados = st.executeQuery(buscaSql);
           
        //Cria um ArrayList de FonteRenda para retornar com os dados do banco.
  
        ArrayList <Entrada> listaEnt = new ArrayList<Entrada>();  
      
        // O método next() informa se houve resultados e posiciona o cursor do banco  
       // na próxima linha disponível para recuperação
        while(dados.next())
        {
            //cria um objeto para cada fonte de renda.
            Entrada ent = new Entrada(dados.getString("ent_data"), dados.getInt(i), );
            
            ent.setId(dados.getInt("ent_id"));
            
            
            listaFr.add(fr);
            
        }
       
        try 
        {
            conexao.desconectar();
        } 
        catch (Exception ex)
        {
            System.out.println("Erro ao desconectar do banco de dados" + ex);
        }
        return listaFr;  
    
    } */
    
    
}
