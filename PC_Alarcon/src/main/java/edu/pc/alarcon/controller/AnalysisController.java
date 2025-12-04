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

    // Inyección del servicio encargado de análisis (conteo + estadísticas)
    public AnalysisController(AnalysisService service){
        this.service = service;
    }

    /**
     * GET /api/analysis/count
     * -----------------------------------
     * Endpoint que devuelve el conteo total
     * de todas las palabras del diccionario
     * dentro de todos los textos almacenados.
     */
    @GetMapping("/count")
    public CountResult countAll() throws Exception {
        return service.countAll();
    }

    /**
     * GET /api/analysis/stats
     * -----------------------------------
     * Devuelve estadísticas basadas en el conteo,
     * por ejemplo: palabra, frecuencia, porcentaje.
     */
    @GetMapping("/stats")
    public List<StatsResult> stats() throws Exception {
        return service.stats();
    }
}
