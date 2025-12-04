package edu.pc.alarcon.controller;

import edu.pc.alarcon.service.DictionaryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController {

    private final DictionaryService service;

    // Servicio para manejar el diccionario en JSON
    public DictionaryController(DictionaryService service){
        this.service = service;
    }

    /**
     * GET /api/dictionary
     * ----------------------
     * Devuelve todas las palabras del diccionario
     */
    @GetMapping
    public List<String> list() throws Exception {
        return service.list();
    }

    /**
     * POST /api/dictionary?word=xxx
     * --------------------------------
     * Agrega una palabra nueva al diccionario.
     * Se guarda en minúsculas automáticamente.
     */
    @PostMapping
    public List<String> add(@RequestParam String word) throws Exception {
        return service.add(word);
    }

    /**
     * DELETE /api/dictionary
     * ------------------------
     * Limpia el diccionario completo
     */
    @DeleteMapping
    public void clear() throws Exception {
        service.clear();
    }
}
