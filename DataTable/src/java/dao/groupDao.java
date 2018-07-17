
package dao;

import interfaces.groupI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.groupModel;


public class groupDao extends DAO implements groupI{

    @Override
    public List<groupModel> listar() throws Exception {
        List<groupModel> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "select * from VISTA ";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            groupModel gro;
            while (rs.next()) {
                gro = new groupModel();
                gro.setMarca(rs.getString("NOMBRE"));
                gro.setFechaVenta17(rs.getString("FECHA2017"));
                gro.setPrecio17(rs.getDouble("PRECIO2017"));
                gro.setFechaVenta18(rs.getString("FECHA2018"));
                gro.setPrecio18(rs.getDouble("PRECIO2018"));
                lista.add(gro);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
}
