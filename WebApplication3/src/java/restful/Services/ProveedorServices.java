
package restful.Services;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import restful.Model.ProveedorModel;
import restful.Model.Conexion;
import restful.Model.InventarioModel;


public class ProveedorServices {
    public ArrayList<ProveedorModel> getProveedores() {
        ArrayList<ProveedorModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM proveedor";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ProveedorModel proveedor = new ProveedorModel();
                proveedor.setNit_proveedor(rs.getInt("Nit_proveedor"));
                proveedor.setNombre_proveedor(rs.getString("Nom_proveedor"));
                proveedor.setTelefono(rs.getInt("Tel_proveedor"));
                proveedor.setDireccion(rs.getString("Dire_proveedor"));
                lista.add(proveedor);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    
    
 public ProveedorModel getProveedor(int id) {
        ProveedorModel proveedor = new ProveedorModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM proveedor WHERE Nit_proveedor = ?";

        try {
             
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                proveedor.setNit_proveedor(rs.getInt("Nit_proveedor"));
                proveedor.setNombre_proveedor(rs.getString("Nom_proveedor"));
                proveedor.setTelefono(rs.getInt("Tel_proveedor"));
                proveedor.setDireccion(rs.getString("Dire_proveedor"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }     
        return proveedor;

}
      public ProveedorModel addProveedor (ProveedorModel proveedor) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO proveedor (Nit_proveedor,Nom_proveedor,Tel_proveedor,Dire_proveedor)";
        Sql = Sql + "values (?,?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, proveedor.getNit_proveedor());
            pstm.setString(2, proveedor.getNombre_proveedor());
            pstm.setInt(3, proveedor.getTelefono());
            pstm.setString(4, proveedor.getDireccion());
            
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return proveedor;    
     
}
      
   public ProveedorModel updateProveedor (ProveedorModel pp) {
        Conexion conn = new Conexion();
        String sql = "UPDATE proveedor SET Nom_proveedor=?,Tel_proveedor=?,Dire_proveedor=? WHERE Nit_proveedor= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, pp.getNombre_proveedor());
            pstm.setInt(2, pp.getTelefono());
            pstm.setString(3, pp.getDireccion());
            pstm.setInt(4, pp.getNit_proveedor());

            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al agregar  " + excepcion.getMessage());
            return null;
        }
        return pp;
    }
     public String delProveedor(int id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM proveedor WHERE Nit_proveedor= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return "{\"Accion\":\"Error\"}";
        }
        return "{\"Accion\":\"Registro Borrado\"}";
    }
}
