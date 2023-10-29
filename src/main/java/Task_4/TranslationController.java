package Task_4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TranslationController {

    private final Map<String, String> translations = new HashMap<>();

    public TranslationController() {
        translations.put("кіт", "cat");
        translations.put("собака", "dog");
        translations.put("книга", "book");
        translations.put("дерево", "tree");
        translations.put("автомобіль", "car");
        translations.put("сонце", "sun");
        translations.put("місяць", "moon");
        translations.put("будинок", "house");
        translations.put("вогонь", "fire");
        translations.put("квітка", "flower");
        translations.put("вода", "water");
        translations.put("риба", "fish");
        translations.put("птах", "bird");
        translations.put("яблуко", "apple");
        translations.put("стілець", "chair");
        translations.put("двері", "door");
        translations.put("ручка", "pen");
        translations.put("шапка", "hat");
        translations.put("годинник", "clock");
        translations.put("стіл", "table");
    }

    @GetMapping("/translate")
    public String translate(@RequestParam String word) {
        String translation = translations.get(word);
        if (translation != null) {
            return translation;
        } else {
            return "Translation not found";
        }
    }
}
