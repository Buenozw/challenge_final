package br.com.fiap.services;

import br.com.fiap.beans.Notificacao;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class NotificacaoService {

    public Notificacao getNotificacao(int idNotificacao) throws IOException {

        Notificacao notificacao = null;

        String url = "http://localhost:8080/notificacao/" + idNotificacao;

        HttpGet request = new HttpGet(url);

        CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();

        CloseableHttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();

        if (entity != null) {
            String result = EntityUtils.toString(entity);

            Gson gson = new Gson();
            notificacao = gson.fromJson(result, Notificacao.class);
        }

        response.close();
        httpClient.close();
        return notificacao;
    }
}
