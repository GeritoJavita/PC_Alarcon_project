package edu.pc.alarcon.controller;

import edu.pc.alarcon.model.TextDocument;
import edu.pc.alarcon.service.TextService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/texts")
public class TextController {

    private final TextService service;

    // Servicio que maneja textos en archivo JSON
    public TextController(TextService service){
        this.service = service;
    }

    /**
     * GET /api/texts
     * ---------------------
     * Lista todos los textos almacenados.
     */
    @GetMapping
    public List<TextDocument> list() throws Exception {
        return service.list();
    }

    /**
     * POST /api/texts
     * ---------------------
     * Recibe un documento de texto en JSON:
     * {
     *    "id": "1",
     *    "title": "Titulo",
     *    "body": "Texto del documento"
     * }
     */
    @PostMapping
    public TextDocument add(@RequestBody TextDocument doc) throws Exception {
        return service.add(doc);
    }

    /**
     * GET /api/texts/{id}
     * -------------------------
     * Obtiene un texto por su ID
     */
    @GetMapping("/{id}")
    public TextDocument get(@PathVariable String id) throws Exception {
        return service.findById(id).orElse(null);
    }

    /**
     * DELETE /api/texts
     * -------------------------
     * Borra TODOS los textos almacenados.
     */
    @DeleteMapping
    public void clear() throws Exception {
        service.clear();
    }
}
