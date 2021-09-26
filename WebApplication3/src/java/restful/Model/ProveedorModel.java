
package restful.Model;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProveedorModel {
    
    private int nit_proveedor;
    private String nombre_proveedor;
    private int telefono;
    private String direccion;

    public ProveedorModel(int nit_proveedor, String nombre_proveedor, int telefono, String direccion) {
        this.nit_proveedor = nit_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getNit_proveedor() {
        return nit_proveedor;
    }

    public void setNit_proveedor(int nit_proveedor) {
        this.nit_proveedor = nit_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
                

    public ProveedorModel() {
    }
    
    
}
