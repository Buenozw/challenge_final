package br.com.fiap.resource;

import br.com.fiap.beans.Paciente;
import br.com.fiap.bo.PacienteBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;

@Path("/paciente")
public class PacienteResource {

    private final PacienteBO pacienteBO = new PacienteBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paciente> selecionarRs() throws ClassNotFoundException, SQLException {
        return pacienteBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Paciente paciente, @Context UriInfo uriInfo)
            throws ClassNotFoundException, SQLException {

        pacienteBO.inserirBo(paciente);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(paciente.getIdPaciente()));
        return Response.created(builder.build()).entity("Paciente cadastrado com sucesso ✅!").build();
    }

    // Atualizar
    @PUT
    @Path("/{idPaciente}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(@PathParam("idPaciente") int idPaciente, Paciente paciente)
            throws ClassNotFoundException, SQLException {

        paciente.setIdPaciente(idPaciente);
        pacienteBO.atualizarBo(paciente);
        return Response.ok("Paciente atualizado com sucesso ✅!").build();
    }

    // Deletar
    @DELETE
    @Path("/{idPaciente}")
    public Response deletarRs(@PathParam("idPaciente") int idPaciente)
            throws ClassNotFoundException, SQLException {

        pacienteBO.deletarBo(idPaciente);
        return Response.ok("Paciente deletado com sucesso ✅!").build();
    }
}
