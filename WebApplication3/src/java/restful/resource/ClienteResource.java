/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.resource;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import restful.Model.ClienteModel;
import restful.Services.ClienteService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

@Path("clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    ClienteService servicio = new ClienteService();

    @GET
    public ArrayList<ClienteModel> getClientes() {

        return servicio.getClientes(); 
    }
        @Path("/{Id_cliente}")
    @GET
    public ClienteModel getCliente(@PathParam("Id_cliente") int id) {

        return servicio.getCliente(id);
    }
    
    @POST
    public ClienteModel addCliente(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        ClienteModel cliente = gson.fromJson(JSON, ClienteModel.class);
        return servicio.addCliente(cliente);
    }

    @DELETE
    @Path("/{Id_cliente}")
    public String delCliente(@PathParam("Id_cliente") int id) {

        return servicio.delCliente(id);

    }

    @PUT
    public ClienteModel updateCliente(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        ClienteModel cliente = gson.fromJson(JSON, ClienteModel.class);
        return servicio.updateCliente(cliente);
    }

}
    
    
 
    
    
    
    


