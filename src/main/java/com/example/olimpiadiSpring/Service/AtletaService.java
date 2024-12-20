package com.example.olimpiadiSpring.Service;

import com.example.olimpiadiSpring.Converter.AtletaConverter;
import com.example.olimpiadiSpring.DTO.AtletaDTO;
import com.example.olimpiadiSpring.Entity.Atleta;
import com.example.olimpiadiSpring.Entity.Sport;
import com.example.olimpiadiSpring.Repository.AtletaRepository;
import com.example.olimpiadiSpring.Repository.SportRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AtletaService {
    private final SportRepository sportRepository;
    private AtletaRepository atletaRepository;
    public AtletaService(AtletaRepository atletaRepository, SportRepository sportRepository) {
        this.atletaRepository = atletaRepository;
        this.sportRepository = sportRepository;
    }

    public List<AtletaDTO> getAllAtletas() {
        List<Atleta> atletas = atletaRepository.findAll();
        List<AtletaDTO> atletasDTO = atletas.stream().map(AtletaConverter::toDTO).toList();
        return atletasDTO;
    }

    public AtletaDTO getAtleta(Integer id) {
        Atleta atleta = atletaRepository.findById(id).orElseThrow(()->new NoSuchElementException("Atleta no encontrado"));
        return AtletaConverter.toDTO(atleta);
    }

    public AtletaDTO saveAtleta(AtletaDTO atletaDTO) {
        Atleta atleta=new Atleta();
        atleta.setNome(atletaDTO.getNome());
        atleta.setCognome(atletaDTO.getCognome());
        atleta.setAnno(atletaDTO.getAnno());
        atleta.setAltezza_cm(atletaDTO.getAltezza_cm());
        if(atletaDTO!=null) {
            Sport sport = sportRepository.findById(atletaDTO.getId()).orElseThrow(() -> new NoSuchElementException("Sport no encontrado"));
            atleta.setSport(sport);
            sport.getAtleti().add(atleta);
            sportRepository.save(sport);
        }
        return AtletaConverter.toDTO(atletaRepository.save(atleta));
    }

    public AtletaDTO updateAtleta(Integer id,AtletaDTO atletaDTO) {
        Atleta atleta=atletaRepository.findById(id).orElseThrow(()->new NoSuchElementException("Atleta no encontrado"));
        atleta.setNome(atletaDTO.getNome()!=null?atletaDTO.getNome():atleta.getNome());
        atleta.setCognome(atletaDTO.getCognome()!=null?atletaDTO.getCognome():atleta.getCognome());
        atleta.setAnno(atletaDTO.getAnno()!=null?atletaDTO.getAnno(): atleta.getAnno());
        atleta.setAltezza_cm(atletaDTO.getAltezza_cm()!=null? atletaDTO.getAltezza_cm() : atleta.getAltezza_cm());
        if(atletaDTO.getSport()!=null){
            Sport sport=sportRepository.findById(atletaDTO.getSport().getId()).orElseThrow(()->new NoSuchElementException("Sport no encontrado"));
            atleta.setSport(sport);
            sport.getAtleti().add(atleta);
            sportRepository.save(sport);
        }

        return AtletaConverter.toDTO(atletaRepository.save(atleta));
    }

    public AtletaDTO deleteAtleta(Integer id) {
        Atleta atleta=atletaRepository.findById(id).orElseThrow(()->new NoSuchElementException("Atleta no encontrado"));
        AtletaDTO atletaDTO=AtletaConverter.toDTOnotSport(atleta);
        if(atleta.getSport()!=null){
            atleta.getSport().getAtleti().remove(atleta);
            atleta.setSport(null);
        }
        return atletaDTO;
    }
}
