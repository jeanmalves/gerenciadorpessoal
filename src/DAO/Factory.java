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
            
            
}
