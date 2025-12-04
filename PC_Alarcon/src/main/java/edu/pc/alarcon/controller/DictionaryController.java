package edu.pc.alarcon.controller;

import edu.pc.alarcon.service.DictionaryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController {
    private final DictionaryService service;
    public DictionaryController(DictionaryService service){this.service = service;}
    @GetMapping public List<String> list() throws Exception { return service.list(); }
    @PostMapping public List<String> add(@RequestParam String word) throws Exception { return service.add(word); }
    @DeleteMapping public void clear() throws Exception { service.clear(); }
}