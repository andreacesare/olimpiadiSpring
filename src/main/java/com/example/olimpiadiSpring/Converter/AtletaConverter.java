package com.example.olimpiadiSpring.Converter;

import com.example.olimpiadiSpring.DTO.AtletaDTO;
import com.example.olimpiadiSpring.Entity.Atleta;

public class AtletaConverter {

    public static AtletaDTO toDTO(Atleta atleta) {
        AtletaDTO atletaDTO = new AtletaDTO();
        atletaDTO.setId(atleta.getId());
        atletaDTO.setNome(atleta.getNome());
        atletaDTO.setCognome(atleta.getCognome());
        atletaDTO.setAnno(atleta.getAnno());
        atletaDTO.setAltezza_cm(atleta.getAltezza_cm());
        atletaDTO.setSport(SportConverter.toDTOnotAtleti(atleta.getSport()));
        return atletaDTO;
    }

    public static AtletaDTO toDTOnotSport(Atleta atleta) {
        AtletaDTO atletaDTO = new AtletaDTO();
        atletaDTO.setId(atleta.getId());
        atletaDTO.setNome(atleta.getNome());
        atletaDTO.setCognome(atleta.getCognome());
        atletaDTO.setAnno(atleta.getAnno());
        atletaDTO.setAltezza_cm(atleta.getAltezza_cm());
        return atletaDTO;
    }
}
