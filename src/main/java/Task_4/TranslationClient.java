package Task_4;

import org.springframework.web.client.RestTemplate;

public class TranslationClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String word = "вода";
        String translation = restTemplate.getForObject("http://localhost:8080/translate?word=" + word, String.class);
        System.out.println("Translation: " + translation);
    }
}

