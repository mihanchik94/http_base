package task_2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class Main {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String LINK = "https://api.nasa.gov/planetary/apod?api_key=MfAkalTi0LqAUx0htF7jjpDkMZQOLRxfMzJ0JCi0";

    public static void main(String[] args) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(LINK);
        try (CloseableHttpResponse response = client.execute(request)) {
            ResponseNasa nasa = MAPPER.readValue(response.getEntity().getContent(), new TypeReference<>() {});
            Downloader.download(nasa);
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