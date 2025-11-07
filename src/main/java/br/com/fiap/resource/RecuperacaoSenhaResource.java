package br.com.fiap.resource;

import br.com.fiap.beans.RecuperacaoSenha;
import br.com.fiap.bo.RecuperacaoSenhaBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;

@Path("/recuperacaosenha")
public class RecuperacaoSenhaResource {

    private final RecuperacaoSenhaBO recuperacaoSenhaBO = new RecuperacaoSenhaBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RecuperacaoSenha> selecionarRs() throws ClassNotFoundException, SQLException {
        return recuperacaoSenhaBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(RecuperacaoSenha recuperacaoSenha, @Context UriInfo uriInfo)
            throws ClassNotFoundException, SQLException {

        recuperacaoSenhaBO.inserirBo(recuperacaoSenha);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(recuperacaoSenha.getIdRecuperacaoSenha()));
        return Response.created(builder.build())
                .entity("Recuperação de senha cadastrada com sucesso ✅!")
                .build();
    }

    // Atualizar
    @PUT
    @Path("/{idRecuperacaoSenha}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(@PathParam("idRecuperacaoSenha") int idRecuperacaoSenha, RecuperacaoSenha recuperacaoSenha)
            throws ClassNotFoundException, SQLException {

        recuperacaoSenha.setIdRecuperacaoSenha(idRecuperacaoSenha);
        recuperacaoSenhaBO.atualizarBo(recuperacaoSenha);
        return Response.ok("Recuperação de senha atualizada com sucesso ✅!").build();
    }

    // Deletar
    @DELETE
    @Path("/{idRecuperacaoSenha}")
    public Response deletarRs(@PathParam("idRecuperacaoSenha") int idRecuperacaoSenha)
            throws ClassNotFoundException, SQLException {

        recuperacaoSenhaBO.deletarBo(idRecuperacaoSenha);
        return Response.ok("Recuperação de senha deletada com sucesso ✅!").build();
    }
}
