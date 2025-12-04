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

    // Inyección de servicios de diccionario y textos
    public CountController(DictionaryService dictionaryService, TextService textService) {
        this.dictionaryService = dictionaryService;
        this.textService = textService;
    }

    /**
     * GET /api/count
     * ----------------------------------------
     * Realiza un conteo de TODAS las palabras
     * del diccionario dentro de TODOS los textos.
     *
     * Funciona así:
     * 1) Lee el diccionario
     * 2) Junta todos los textos
     * 3) Limpia signos y minúsculas
     * 4) Divide en palabras
     * 5) Cuenta coincidencias exactas
     */
    @GetMapping
    public CountResult count() throws Exception {

        // Obtener diccionario en minúsculas
        List<String> dictionary = dictionaryService.list()
                .stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        // Unir todos los textos
        StringBuilder fullText = new StringBuilder();
        for (TextDocument doc : textService.list()) {
            fullText.append(" ").append(doc.getBody());
        }

        // Limpieza del texto
        String cleanText = fullText.toString()
                .toLowerCase()
                .replaceAll("[^a-záéíóúñ0-9 ]", " ");

        // Convertir en lista de palabras
        List<String> words = Arrays.asList(cleanText.split("\\s+"));

        // Map para almacenar resultados del conteo
        Map<String, Integer> result = new HashMap<>();

        // Contar coincidencias
        for (String word : dictionary) {
            int count = (int) words.stream()
                    .filter(w -> w.equals(word))
                    .count();
            result.put(word, count);
        }

        return new CountResult(result);
    }
}
