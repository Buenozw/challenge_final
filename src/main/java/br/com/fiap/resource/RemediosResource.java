package br.com.fiap.resource;

import br.com.fiap.beans.Remedios;
import br.com.fiap.bo.RemediosBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;

@Path("/remedios")
public class RemediosResource {

    private final RemediosBO remediosBO = new RemediosBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Remedios> selecionarRs() throws ClassNotFoundException, SQLException {
        return remediosBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Remedios remedios, @Context UriInfo uriInfo)
            throws ClassNotFoundException, SQLException {

        remediosBO.inserirBo(remedios);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(remedios.getId_remedio()));
        return Response.created(builder.build())
                .entity("Remédio cadastrado com sucesso ✅!")
                .build();
    }

    // Atualizar
    @PUT
    @Path("/{idRemedio}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(@PathParam("idRemedio") int idRemedio, Remedios remedios)
            throws ClassNotFoundException, SQLException {

        remedios.setId_remedio(idRemedio);
        remediosBO.atualizarBo(remedios);
        return Response.ok("Remédio atualizado com sucesso ✅!").build();
    }

    // Deletar
    @DELETE
    @Path("/{idRemedio}")
    public Response deletarRs(@PathParam("idRemedio") int idRemedio)
            throws ClassNotFoundException, SQLException {

        remediosBO.deletarBo(idRemedio);
        return Response.ok("Remédio deletado com sucesso ✅!").build();
    }
}
