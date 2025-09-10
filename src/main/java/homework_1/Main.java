package homework_1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        HttpClient client = new HttpClientImpl();
        Map<String, String> headers1 = new HashMap<>();
        headers1.put("Content-Type", "application/json");
        Map<String, String> params = new HashMap<>();
        params.put("userId", "2");
        System.out.println(client.get("https://jsonplaceholder.typicode.com/posts", headers1, params));
        System.out.println();


        Map<String, String> headers2 = new HashMap<>();
        headers2.put("Content-Type", "application/json");
        Map<String, String> data = new HashMap<>();
        data.put("text", "text");
        System.out.println(client.delete("https://webhook.site/9016bec8-0908-474f-95a4-3c0ef310c878", headers2, data));


        OpenAiClient openAiClient = new OpenAiClient();
        System.out.println(openAiClient.getResponse("Hello, let's tell about programming"));

    }
}
