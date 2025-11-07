package br.com.fiap.resource;

import br.com.fiap.beans.Agendamento;
import br.com.fiap.bo.AgendamentoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/agendamento")
public class AgendamentoResource {

    private AgendamentoBO agendamentoBO = new AgendamentoBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Agendamento> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Agendamento>) agendamentoBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Agendamento agendamento, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        agendamentoBO.inserirBo(agendamento);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(agendamento.getIdAgendamento()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Agendamento agendamento) throws ClassNotFoundException, SQLException {
        agendamentoBO.atualizarBo(agendamento);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{idAgendamento}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("idAgendamento") int idAgendamento) throws ClassNotFoundException, SQLException {
        agendamentoBO.deletarBo(idAgendamento);
        return Response.ok().build();
    }
}
