package com.example.olimpiadiSpring.Controller;

import com.example.olimpiadiSpring.DTO.AtletaDTO;
import com.example.olimpiadiSpring.Repository.AtletaRepository;
import com.example.olimpiadiSpring.Service.AtletaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atleta")
public class AtletaController {
    private final AtletaRepository atletaRepository;
    private AtletaService atletaService;
    public AtletaController(AtletaService atletaService, AtletaRepository atletaRepository) {
        this.atletaService = atletaService;
        this.atletaRepository = atletaRepository;
    }

    @GetMapping("")
    public List<AtletaDTO> getAtleti() {
        return atletaService.getAllAtletas();
    }

    @GetMapping("/getAtletaById/{id}")
    public AtletaDTO getAtletaById(@PathVariable("id") Integer id) {
        return atletaService.getAtleta(id);
    }

    @PostMapping("/saveAtleta")
    public AtletaDTO saveAtleta(@RequestBody AtletaDTO atleta) {
        return atletaService.saveAtleta(atleta);
    }

    @PutMapping("/updateAtleta/{id}")
    public AtletaDTO updateAtleta(@RequestBody AtletaDTO atleta,@PathVariable("id") Integer id) {
        return atletaService.updateAtleta(id,atleta);
    }

    @DeleteMapping("/deleteAtleta")
    public AtletaDTO deleteAtleta(@PathVariable("id") Integer id) {
        return atletaService.deleteAtleta(id);
    }
}
