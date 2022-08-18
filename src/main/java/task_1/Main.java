package task_1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String LINK = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(LINK);

        try (CloseableHttpResponse response = client.execute(request)) {
            List<CatInfo> info = MAPPER.readValue(response.getEntity().getContent(), new TypeReference<>(){});
            info.stream().filter(catInfo -> catInfo.getUpvotes() != null && catInfo.getUpvotes() != 0)
                    .forEach(System.out::println);
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