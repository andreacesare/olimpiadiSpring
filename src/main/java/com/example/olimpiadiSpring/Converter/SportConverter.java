package com.example.olimpiadiSpring.Converter;

import com.example.olimpiadiSpring.DTO.SportDTO;
import com.example.olimpiadiSpring.Entity.Sport;

public class SportConverter {

    public static SportDTO toDTOnotAtleti(Sport sport) {
        SportDTO sportDTO = new SportDTO();
        sportDTO.setId(sport.getId());
        sportDTO.setNome(sport.getNome());
        sportDTO.setNgiocatori(sport.getNgiocatori());
        sportDTO.setAtleti(null);
        return sportDTO;
    }

    public static SportDTO toDTO(Sport sport) {
        SportDTO sportDTO = new SportDTO();
        sportDTO.setId(sport.getId());
        sportDTO.setNome(sport.getNome());
        sportDTO.setNgiocatori(sport.getNgiocatori());
        sportDTO.setAtleti(sport.getAtleti().stream().map(AtletaConverter::toDTOnotSport).toList());
        return sportDTO;
    }
}
