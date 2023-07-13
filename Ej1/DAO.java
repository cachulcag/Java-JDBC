package Ej1;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author crist
 */
public abstract class DAO {

    protected Connection cn = null;
    protected Statement st = null;
    protected ResultSet rs = null;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    //private final String DRIVER = "com.mysql.jdbc.Driver";

    private void conectarBase() {
        try {
            //Class.forName(DRIVER);
            String Url = "jdbc:mysql://localhost:3306/" + DATABASE + "?zeroDateTimeBehavior=CONVERT_TO_NULL";
            cn = DriverManager.getConnection(Url, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Tuviste un error de tipo " + e.getMessage());
            cn = null;
        }
    }

    protected void desconectarBase() throws SQLException {
        try {
            if (rs != null) {
                rs.close();
            }
            if (cn != null) {
                cn.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            System.out.println("error " + e.getMessage());
            throw e;
        }
    }

    protected void Update(String comando) throws Exception {
        try {
            conectarBase();
            st = cn.createStatement();
            st.executeUpdate(comando);
        } catch (SQLException e) {
            System.out.println("Tienes un error SQL " + e.getMessage());
            throw e;
        } finally {
            desconectarBase();
        }
    }

    protected void Qwerty(String comando) throws SQLException {
        try {
            conectarBase();
            st = cn.createStatement();
            rs = st.executeQuery(comando);
        } catch (SQLException e) {
            throw e;
        }        
    }
}
