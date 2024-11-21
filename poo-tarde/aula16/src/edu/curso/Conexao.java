package edu.curso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String DB_CLASS = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://localhost:3307/agendadb?allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "alunofatec";

    private static Conexao instancia;
    private Connection connection;

    private Conexao() throws ContatoException {
        try {
            Class.forName(DB_CLASS);
        } catch (ClassNotFoundException e) { 
            throw new ContatoException( e );
        }
    }

    public static Conexao getInstance() throws ContatoException { 
        if (instancia == null) { 
            instancia = new Conexao();
        }
        return instancia;
    }

    public Connection getConnection() throws ContatoException {
        try { 
            if (this.connection == null || 
                this.connection.isClosed() || 
                !this.connection.isValid(5000)) { 
                    this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            }
        } catch (SQLException e) { 
            throw new ContatoException(e);
        }
        return this.connection;
    }
    
}
