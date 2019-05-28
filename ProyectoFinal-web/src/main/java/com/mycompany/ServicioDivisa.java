/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.Entity.Divisas;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author orlan
 */
@javax.enterprise.context.RequestScoped
@Path("/ejemplo")
public class ServicioDivisa {
    @EJB
    ServicioEJBDivisaLocal servicioEjb;
    
    @GET
    @Path("/guardar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardarDivisa() {
        Divisas divisa=new Divisas(1, "Euro", (float) 0.5344, (float) 0.5605);
        servicioEjb.guardarDivisa(divisa);
        return Response.status(Response.Status.OK).build();
    }
    
    
    @GET
    @Path("/consulta")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultaDivisa() {
        System.out.println("LLego al servicio Consulta Divisa");
        Divisas div=servicioEjb.buscarDivisa("Dolar");
        System.out.println("Salio bien: "+div.getNombre());
        return Response.ok(div).build();
    }
}
