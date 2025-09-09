package homework_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpClientImpl implements HttpClient {
    @Override
    // TODO Реализовать применение параметра params
    public String get(String url, Map<String, String> headers, Map<String, String> params) {
        if (params != null) {
            StringBuilder urlWithParam = new StringBuilder(url + "?");

            for (String key : params.keySet()) {
                urlWithParam.append(URLEncoder.encode(key, StandardCharsets.UTF_8) + "=" + URLEncoder.encode(params.get(key), StandardCharsets.UTF_8) + "&");
            }

            url = urlWithParam.toString().substring(0, urlWithParam.length() - 1);
        }

        HttpURLConnection connection = getConnection(url, "GET");
        setHeaders(connection, headers);
        return readResponse(connection);


    }

    @Override
    public String post(String url, Map<String, String> headers, Map<String, String> data) {
        return "";
    }

    @Override
    public String put(String url, Map<String, String> headers, Map<String, String> data) {
        return "";
    }

    @Override
    public String delete(String url, Map<String, String> headers, Map<String, String> data) {
        return "";
    }

    private static String readResponse (HttpURLConnection connection) {
        if (connection == null) {
            return "Не удалось прочитать ответ";
        } else {

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder content = new StringBuilder();
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
                return content.toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static HttpURLConnection getConnection (String url, String method) {
        URL initUrl = null;
        try {
            initUrl = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) initUrl.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            connection.setRequestMethod(method);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    private static void setHeaders (HttpURLConnection connection, Map<String, String> headers) {
        if (connection != null) {
            for (String key : headers.keySet()) {
                connection.setRequestProperty(key, headers.get(key));

            }

            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
        }

    }
}
