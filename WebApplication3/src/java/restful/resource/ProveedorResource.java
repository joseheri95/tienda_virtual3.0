
package restful.resource;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import restful.Model.ProveedorModel;
import restful.Services.ProveedorServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import restful.Model.Conexion;
import restful.Model.InventarioModel;



@Path("proveedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ProveedorResource {
    
    ProveedorServices servicio = new ProveedorServices();

    @GET
    public ArrayList<ProveedorModel> getProveedores() {

        return servicio.getProveedores(); 
}
    
      @Path("/{proveedor}")
    @GET
    public ProveedorModel getProducto(@PathParam("proveedor") int id) {

        return servicio.getProveedor(id);
    }  
       @POST
    public ProveedorModel addProveedor (String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        ProveedorModel proveedor = gson.fromJson(JSON, ProveedorModel.class);
        return servicio.addProveedor(proveedor);
    } 
     @PUT
    public ProveedorModel updateProveedor(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        ProveedorModel pp = gson.fromJson(JSON, ProveedorModel.class);
        return servicio.updateProveedor(pp);
    }
    @DELETE
    @Path("/{nit_proveedor}")
    public String delProveedor(@PathParam("nit_proveedor") int id) {

        return servicio.delProveedor(id);

    }
}
    

