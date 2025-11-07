package br.com.fiap.resource;

import br.com.fiap.beans.Consulta;
import br.com.fiap.bo.ConsultaBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/consulta")
public class ConsultaResource {

    private ConsultaBO consultaBO = new ConsultaBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Consulta> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Consulta>) consultaBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Consulta consulta, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        consultaBO.inserirBo(consulta);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(consulta.getId_consulta()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Path("/{id_consulta}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(@PathParam("id_consulta") int id_consulta, Consulta consulta) throws ClassNotFoundException, SQLException {
        consulta.setId_consulta(id_consulta);
        consultaBO.atualizarBo(consulta);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id_consulta}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id_consulta") int id_consulta) throws ClassNotFoundException, SQLException {
        consultaBO.deletarBo(id_consulta);
        return Response.ok().build();
    }
}
