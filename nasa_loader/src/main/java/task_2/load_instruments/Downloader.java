package task_2.load_instruments;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import task_2.model.ResponseNasa;
import java.io.FileOutputStream;
import java.io.IOException;

public class Downloader {
    public static void Download(ResponseNasa resp) {
        String imageName = LinkParser.parseLink(resp.getUrl());
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(resp.getUrl());
        try (CloseableHttpResponse response = client.execute(request);
        FileOutputStream writer = new FileOutputStream(imageName)) {
            writer.write(response.getEntity().getContent().readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}