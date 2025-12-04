package edu.pc.alarcon.controller;

import edu.pc.alarcon.model.CountResult;
import edu.pc.alarcon.model.TextDocument;
import edu.pc.alarcon.service.DictionaryService;
import edu.pc.alarcon.service.TextService;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

@RestController
@RequestMapping("/api/count")
public class CountController {

    private final DictionaryService dictionaryService;
    private final TextService textService;

    public CountController(DictionaryService dictionaryService, TextService textService) {
        this.dictionaryService = dictionaryService;
        this.textService = textService;
    }

    @GetMapping
    public CountResult count() throws Exception {

        // 1. Obtener diccionario de palabras
        List<String> dictionary = dictionaryService.list()
                .stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        // 2. Unir TODOS los textos
        StringBuilder fullText = new StringBuilder();
        for (TextDocument doc : textService.list()) {
            fullText.append(" ").append(doc.getBody());
        }

        // 3. Limpiar texto (minúscula + quitar símbolos)
        String cleanText = fullText.toString()
                .toLowerCase()
                .replaceAll("[^a-záéíóúñ0-9 ]", " ");

        // 4. Convertir a lista de palabras
        List<String> words = Arrays.asList(cleanText.split("\\s+"));

        // 5. Contar
        Map<String, Integer> result = new HashMap<>();

        for (String word : dictionary) {
            int count = (int) words.stream()
                    .filter(w -> w.equals(word))
                    .count();
            result.put(word, count);
        }

        return new CountResult(result);
    }
}

