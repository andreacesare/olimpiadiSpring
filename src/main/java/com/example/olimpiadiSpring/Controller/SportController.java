package com.example.olimpiadiSpring.Controller;

import com.example.olimpiadiSpring.DTO.SportDTO;
import com.example.olimpiadiSpring.Entity.Sport;
import com.example.olimpiadiSpring.Service.SportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sport")
public class SportController {
    private SportService sportService;
    public SportController(SportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping("")
    public List<SportDTO> getSports() {
        return sportService.getAllSports();
    }

    @GetMapping("/getSportById/{id}")
    public SportDTO getSportById(@PathVariable("id") Integer id) {
        return sportService.getSportById(id);
    }

    @PostMapping("/saveSport")
    public SportDTO saveSport(@RequestBody SportDTO sportDTO) {
        return sportService.saveSport(sportDTO);
    }

    @PutMapping("/updateSport/{id}")
    public SportDTO updateSport(@RequestBody SportDTO sportDTO,@PathVariable("id") Integer id) {
        return sportService.updateSport(id, sportDTO);
    }

    @DeleteMapping("/deleteSport/{id}")
    public SportDTO deleteSport(@PathVariable("id") Integer id) {
        return sportService.deleteSport(id);
    }

    @GetMapping("/sportDiSquadra")
    public List<SportDTO> getSportDiSquadra() {
        return sportService.sportDiSquadra();
    }

    @GetMapping("/sportNumeroAtleti")
    public Map<String, Long> getSportNumeroAtleti() {
        return sportService.sportConNumeroAtleti();
    }

    @GetMapping("/sportAlmeno2Atleti")
    public List<SportDTO> getSportAlmeno2Atleti() {
        return sportService.sport2Atleti();
    }
}
