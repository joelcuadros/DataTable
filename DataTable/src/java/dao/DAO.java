package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;

@Data
public class DAO {

    private Connection cn;

    public void Conectar() throws Exception {       //Metodo con los datos de acceso
        try {
            if (cn == null) {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "DataTable", "ememjavsaa");
            }
        } catch (ClassNotFoundException | SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No hay conexión a la base de datos"));
            throw e;
        }
    }

    public void Cerrar() throws SQLException {      //Cerrar la conexion
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();
                cn = null;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        DAO dao = new DAO();
        dao.Conectar();
        if (dao.getCn() != null) {
            System.out.println("conectado");
        } else {
            System.out.println("error");
        }
    }

}
