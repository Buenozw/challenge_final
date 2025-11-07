package br.com.fiap.services;

import br.com.fiap.beans.Paciente;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class PacienteService {

    public Paciente getPaciente(int idPaciente) throws IOException {

        Paciente paciente = null;

        String url = "http://localhost:8080/paciente/" + idPaciente;

        HttpGet request = new HttpGet(url);

        CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();

        CloseableHttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();

        if (entity != null) {
            String result = EntityUtils.toString(entity);

            Gson gson = new Gson();
            paciente = gson.fromJson(result, Paciente.class);
        }

        response.close();
        httpClient.close();
        return paciente;
    }
}
