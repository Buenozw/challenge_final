package br.com.fiap.resource;

import br.com.fiap.beans.Exame;
import br.com.fiap.bo.ExameBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/exame")
public class ExameResource {

    private ExameBO exameBO = new ExameBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Exame> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Exame>) exameBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Exame exame, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        exameBO.inserirBo(exame);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(exame.getIdExame()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Path("/{idExame}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(@PathParam("idExame") int idExame, Exame exame) throws ClassNotFoundException, SQLException {
        exame.setIdExame(idExame);
        exameBO.atualizarBo(exame);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{idExame}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("idExame") int idExame) throws ClassNotFoundException, SQLException {
        exameBO.deletarBo(idExame);
        return Response.ok().build();
    }
}
