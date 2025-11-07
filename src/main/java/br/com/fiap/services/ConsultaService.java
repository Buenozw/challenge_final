package br.com.fiap.services;

import br.com.fiap.beans.Consulta;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ConsultaService {

    public Consulta getConsulta(int idConsulta) throws IOException {

        Consulta consulta = null;

        String url = "http://localhost:8080/consultas/" + idConsulta;

        HttpGet request = new HttpGet(url);

        CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();

        CloseableHttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();

        if (entity != null) {
            String result = EntityUtils.toString(entity);

            Gson gson = new Gson();
            consulta = gson.fromJson(result, Consulta.class);
        }

        response.close();
        httpClient.close();

        return consulta;
    }
}
