package Task_4_2;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslationService {
    private Map<String, String> translations;

    public TranslationService() {
        translations = new HashMap<>();
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

    public String translate(String word) {
        return translations.get(word);
    }
}
