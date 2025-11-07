package br.com.fiap.resource;

import br.com.fiap.beans.Login;
import br.com.fiap.bo.LoginBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/login")
public class LoginResource {

    private LoginBO loginBO = new LoginBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Login> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Login>) loginBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Login login, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        loginBO.inserirBo(login);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(login.getIdLogin()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Path("/{idLogin}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(@PathParam("idLogin") int idLogin, Login login) throws ClassNotFoundException, SQLException {
        login.setIdLogin(idLogin);
        loginBO.atualizarBo(login);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{idLogin}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("idLogin") int idLogin) throws ClassNotFoundException, SQLException {
        loginBO.deletarBo(idLogin);
        return Response.ok().build();
    }
}
