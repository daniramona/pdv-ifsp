package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Esta classe é responsável por criar a conexão com o banco de dados mysql
 * 
 * @author Bruno Sartori <brunosartori.webmaster@gmail.com>
 * @version 1.0.0, 09/05/2017 21:22 
 * @package controller
 */
public class ConnectionFactory {
    /**
     * uma {@link String} contendo o driver do mysql
     */
    private final String driver = "com.mysql.jdbc.Driver";
    
    /**
     * uma {@link String} contendo a url de conexão com o banco de dados
     */
    private final String url = "jdbc:mysql://localhost/erp_perfumaria";
    
    /**
     * uma {@link String} contendo o usuario do banco de dados mysql
     */
    private final String user = "root";
    
    /**
     * uma {@link String} contendo a senha do banco de dados mysql
     */
    private final String password = "";
    
    /**
     * Cria a conexão com o banco de dados mysql
     * @return Retorna uma instancia de conexão com o banco de dados
     */
    public Connection getConnection(){
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro de Conexão: ", ex);
        }       
    }
}
