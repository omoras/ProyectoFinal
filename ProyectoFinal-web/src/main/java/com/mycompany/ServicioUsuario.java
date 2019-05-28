/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.Entity.Usuarios;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author orlan
 */
@javax.enterprise.context.RequestScoped
@Path("/usuario")
public class ServicioUsuario {
    @EJB
    ServicioEJBUsuarioLocal servicioEjb;
    @EJB
    ServicioEJBTokensLocal servicioToken;
    
    @POST
    @Path("/guardar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarPostUsuario(Usuarios usuario) {
        servicioEjb.guardarUsuario(usuario);
        return Response.status(Response.Status.OK).build();
    }
    
    @POST
    @Path("/loggin")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logginUsuario(Usuarios usuario) {
        
        return Response.status(Response.Status.OK).build();
    }
}
