package restful.Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import restful.Model.ClienteModel;
import restful.Model.Conexion;

public class ClienteService {

    public ArrayList<ClienteModel> getClientes() {
        ArrayList<ClienteModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM clientes";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ClienteModel cliente = new ClienteModel();
                cliente.setId_cliente(rs.getInt("Id_cliente"));
                cliente.setNombre(rs.getString("Nom_cliente"));
                cliente.setDireccion(rs.getString("Dire_cliente"));
                cliente.setTelefono(rs.getInt("Tel_cliente"));
                lista.add(cliente);
            }
        } catch (SQLException e) {
        }

        return lista;
    }
    
    public ClienteModel getCliente(int id) {
        ClienteModel cliente = new ClienteModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM clientes WHERE Id_cliente = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                cliente.setId_cliente(rs.getInt("Id_cliente"));
                cliente.setNombre(rs.getString("Nom_cliente"));
                cliente.setDireccion(rs.getString("Dire_cliente"));
                cliente.setTelefono(rs.getInt("Tel_cliente"));
             
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return cliente;
    }
    
    
    public ClienteModel addCliente(ClienteModel cliente) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO clientes (Id_cliente,Nom_cliente,Dire_cliente,Tel_cliente)";
        Sql = Sql + "values (?,?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, cliente.getId_cliente());
            pstm.setString(2, cliente.getNombre());
            pstm.setString(3, cliente.getDireccion());
            pstm.setInt(4, cliente.getTelefono());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return cliente;
    }
 public ClienteModel updateCliente(ClienteModel cliente) {
        Conexion conn = new Conexion();
        String sql = "UPDATE clientes SET Nom_cliente=?,Tel_cliente=?,Dire_cliente=?, WHERE Id_cliente= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, cliente.getNombre());
            pstm.setInt(2, cliente.getTelefono());
            pstm.setString(3, cliente.getDireccion());
            pstm.setInt(4, cliente.getId_cliente());
            
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al modificar  " + excepcion.getMessage());
            return null;
        }
        return cliente;
    }
   
   public String delCliente(int id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM clientes WHERE Id_cliente= ?";
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


