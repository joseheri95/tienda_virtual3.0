
package restful.Model;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InventarioModel {
    
    private int codigo_producto;
    private String descripcion;
    private int cantidad;
              
    public InventarioModel() {
    }

    public InventarioModel(int codigo_producto, String descripcion, int cantidad) {
        this.codigo_producto = codigo_producto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }
    
    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}

