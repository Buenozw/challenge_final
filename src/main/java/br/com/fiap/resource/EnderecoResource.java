package br.com.fiap.resource;

import br.com.fiap.beans.Endereco;
import br.com.fiap.bo.EnderecoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/endereco")
public class EnderecoResource {

    private EnderecoBO enderecoBO = new EnderecoBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Endereco> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Endereco>) enderecoBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Endereco endereco, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        enderecoBO.inserirBo(endereco);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(endereco.getCep()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Path("/{cep}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(@PathParam("cep") int cep, Endereco endereco) throws ClassNotFoundException, SQLException {
        endereco.setCep(cep);
        enderecoBO.atualizarBo(endereco);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{cep}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("cep") int cep) throws ClassNotFoundException, SQLException {
        enderecoBO.deletarBo(cep);
        return Response.ok().build();
    }
}
