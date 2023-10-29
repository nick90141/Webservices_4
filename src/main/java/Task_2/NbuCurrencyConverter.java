package Task_2;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NbuCurrencyConverter {
    public static void main(String[] args) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");

            HttpResponse response = httpClient.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuilder responseBody = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    responseBody.append(line);
                }

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseBody.toString());

                double usdRate = 1.0;
                double eurRate = 1.0;
                double gbpRate = 1.0;

                for (JsonNode node : jsonNode) {
                    String currencyCode = node.get("cc").asText();
                    double rate = node.get("rate").asDouble();

                    if (currencyCode.equals("USD")) {
                        usdRate = rate;
                    } else if (currencyCode.equals("EUR")) {
                        eurRate = rate;
                    } else if (currencyCode.equals("GBP")) {
                        gbpRate = rate;
                    }
                }

                System.out.println("Поточний курс USD до UAH: " + usdRate);
                System.out.println("Поточний курс EUR до UAH: " + eurRate);
                System.out.println("Поточний курс GBP до UAH: " + gbpRate);
            } else {
                System.err.println("Помилка при виконанні HTTP-запиту: " + response.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}