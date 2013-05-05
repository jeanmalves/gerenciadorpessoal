/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;

/**
 *
 * @author Jeam
 */
public class Factory 
{
    
    public static SaldoInicialBD criarSaldoInicial() throws SQLException
    {
        return new SaldoInicialBD();
    }
        
    public static CategoriaBD criarCategoria() throws SQLException
    {
        return new CategoriaBD();
    }
     
    public static FonteRendaBD criarFonteRenda() throws SQLException
    {
        return new FonteRendaBD();
    }
    
    public static CredorBD criarCredor() throws SQLException
    {
        return new CredorBD();
    }
    public static EntradaBD criarEntrada() throws SQLException
    {
        return new EntradaBD();
    }
    public static SaidaBD criarSaida() throws SQLException
    {
        return new SaidaBD();
    }
            
}
