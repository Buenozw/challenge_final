package br.com.fiap.services;

import br.com.fiap.beans.Remedios;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RemediosService {

    public Remedios getRemedio(int idRemedio) throws IOException {

        Remedios remedio = null;

        String url = "http://localhost:8080/remedios/" + idRemedio;

        HttpGet request = new HttpGet(url);

        CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();

        CloseableHttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();

        if (entity != null) {
            String result = EntityUtils.toString(entity);

            Gson gson = new Gson();
            remedio = gson.fromJson(result, Remedios.class);
        }

        response.close();
        httpClient.close();
        return remedio;
    }
}
