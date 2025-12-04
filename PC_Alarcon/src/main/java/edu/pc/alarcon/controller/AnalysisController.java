package edu.pc.alarcon.controller;

import edu.pc.alarcon.model.CountResult;
import edu.pc.alarcon.model.StatsResult;
import edu.pc.alarcon.service.AnalysisService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {
    private final AnalysisService service;
    public AnalysisController(AnalysisService service){this.service = service;}
    @GetMapping("/count") public CountResult countAll() throws Exception { return service.countAll(); }
    @GetMapping("/stats") public List<StatsResult> stats() throws Exception { return service.stats(); }
}