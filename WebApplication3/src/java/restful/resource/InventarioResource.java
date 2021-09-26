
package restful.resource;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import restful.Model.InventarioModel;
import restful.Services.InventarioServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

@Path("inventario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class InventarioResource {
    InventarioServices servicio = new InventarioServices();

    @GET
    public ArrayList<InventarioModel> getInventario() {

        return servicio.getInventario(); 
}
    @Path("/{codigo_producto}")
    @GET
    public InventarioModel getProducto(@PathParam("codigo_producto") int id) {

        return servicio.getProducto(id);
    }  
    
    @POST
    public InventarioModel addProducto(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        InventarioModel producto = gson.fromJson(JSON, InventarioModel.class);
        return servicio.addProducto(producto);
    } 
  @DELETE
    @Path("/{codigo_producto}")
    public String delProducto(@PathParam("codigo_producto") int id) {

        return servicio.delProducto(id);

    }

  @PUT
    public InventarioModel updateProducto(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        InventarioModel r = gson.fromJson(JSON, InventarioModel.class);
        return servicio.updateProducto(r);
    }

}  
    
    
    
    
    
   