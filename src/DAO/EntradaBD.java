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
    
     
    
    
}
