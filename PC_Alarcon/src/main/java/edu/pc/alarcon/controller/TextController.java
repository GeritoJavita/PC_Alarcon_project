package edu.pc.alarcon.controller;

import edu.pc.alarcon.model.TextDocument;
import edu.pc.alarcon.service.TextService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/texts")
public class TextController {
    private final TextService service;
    public TextController(TextService service){this.service = service;}
    @GetMapping public List<TextDocument> list() throws Exception { return service.list(); }
    @PostMapping public TextDocument add(@RequestBody TextDocument doc) throws Exception { return service.add(doc); }
    @GetMapping("/{id}") public TextDocument get(@PathVariable String id) throws Exception { return service.findById(id).orElse(null); }
    @DeleteMapping public void clear() throws Exception { service.clear(); }
}