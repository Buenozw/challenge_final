package br.com.fiap.services;

import br.com.fiap.beans.Exame;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ExameService {

    public Exame getExame(int idExame) throws IOException {

        Exame exame = null;

        String url = "http://localhost:8080/exame/" + idExame;

        HttpGet request = new HttpGet(url);

        CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();

        CloseableHttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();

        if (entity != null) {
            String result = EntityUtils.toString(entity);

            Gson gson = new Gson();
            exame = gson.fromJson(result, Exame.class);
        }

        response.close();
        httpClient.close();
        return exame;
    }
}
