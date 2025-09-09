package homework_1;

import java.util.HashMap;
import java.util.Map;

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

        Map<String, String> headers3 = new HashMap<>();
        // TODO implement token substitution locally
        System.out.println(System.getenv("OPEN_AI_TOKEN"));
        headers3.put("Authorization", "Bearer ");
        headers3.put("Content-Type", "application/json");
        Map<String, String> data2 = new HashMap<>();
        data2.put("model", "gpt-5-nano");
        data2.put("input", "Let's tell me a story about unicorns");
        System.out.println(client.post("https://api.openai.com/v1/responses", headers3, data2));


    }
}
