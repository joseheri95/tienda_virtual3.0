
package restful.Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import restful.Model.InventarioModel;
import restful.Model.Conexion;

public class InventarioServices { 
    public ArrayList<InventarioModel> getInventario() {
        ArrayList<InventarioModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM inventario";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                InventarioModel producto = new InventarioModel();
                producto.setCodigo_producto(rs.getInt("Cod_producto"));
                producto.setDescripcion(rs.getString("Des_producto"));
                producto.setCantidad(rs.getInt("Cant_existente"));
                lista.add(producto);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
  
     public InventarioModel getProducto(int id) {
        InventarioModel producto = new InventarioModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM inventario WHERE Cod_producto = ?";

        try {
             
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                producto.setCodigo_producto(rs.getInt("Cod_producto"));
                producto.setDescripcion(rs.getString("Des_producto"));
                producto.setCantidad(rs.getInt("Cant_existente"));
              
            }
        } catch (SQLException e) {
            System.out.println(e);
        }     
        return producto;

}
     
  public InventarioModel addProducto(InventarioModel producto) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO inventario (Cod_producto,Des_producto,Cant_existente)";
        Sql = Sql + "values (?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, producto.getCodigo_producto());
            pstm.setString(2, producto.getDescripcion());
            pstm.setInt(3, producto.getCantidad());
         
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return producto;    
     
     
}
   public InventarioModel updateProducto(InventarioModel r) {
        Conexion conn = new Conexion();
        String sql = "UPDATE inventario SET Des_producto=?,Cant_existente=? WHERE Cod_producto= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, r.getDescripcion());
            pstm.setInt(2, r.getCantidad());
            pstm.setInt(3, r.getCodigo_producto());
            
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al agregar  " + excepcion.getMessage());
            return null;
        }
        return r;
    }
   
   public String delProducto(int id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM inventario WHERE Cod_producto= ?";
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
  
  
  
  
