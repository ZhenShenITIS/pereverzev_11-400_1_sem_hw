package homework_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> headers1 = new HashMap<>();
        headers1.put("Content-Type", "application/json");
        Map<String, String> params = new HashMap<>();
        params.put("userId", "2");
        HttpClient client = new HttpClientImpl();
        System.out.println(client.get("https://jsonplaceholder.typicode.com/posts", headers1, params));
    }
}
