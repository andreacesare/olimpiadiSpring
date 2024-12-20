package com.example.olimpiadiSpring.Service;

import com.example.olimpiadiSpring.Converter.SportConverter;
import com.example.olimpiadiSpring.DTO.SportDTO;
import com.example.olimpiadiSpring.Entity.Sport;
import com.example.olimpiadiSpring.Repository.SportRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SportService {
    private SportRepository sportRepository;
    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public SportDTO getSportById(Integer id) {
        Sport sport=sportRepository.findById(id).orElseThrow(()->new NoSuchElementException("Sport not found"));
        SportDTO sportDTO= SportConverter.toDTO(sport);
        return sportDTO;
    }

    public List<SportDTO> getAllSports() {
        List<Sport> sports=sportRepository.findAll();
        List<SportDTO> sportDTOS=sports.stream().map(SportConverter::toDTO).toList();
        return sportDTOS;
    }

    public SportDTO saveSport(SportDTO sportDTO) {
        Sport sport=new Sport();
        sport.setNome(sportDTO.getNome());
        sport.setNgiocatori(sportDTO.getNgiocatori());
        return SportConverter.toDTO(sportRepository.save(sport));
    }

    public SportDTO updateSport(Integer id, SportDTO sportDTO) {
        Sport sport=sportRepository.findById(id).orElseThrow(()->new NoSuchElementException("Sport not found"));
        sport.setNome(sportDTO.getNome()!=null?sportDTO.getNome():sport.getNome());
        sport.setNgiocatori(sportDTO.getNgiocatori()!=null?sportDTO.getNgiocatori():sport.getNgiocatori());
        return SportConverter.toDTO(sportRepository.save(sport));
    }

    public SportDTO deleteSport(Integer id) {
        Sport sport=sportRepository.findById(id).orElseThrow(()->new NoSuchElementException("Sport not found"));
        SportDTO sportDTO=SportConverter.toDTO(sport);
        if(sport.getAtleti()!=null) {
            sport.getAtleti().stream().forEach(a -> a.setSport(null));
            sport.getAtleti().clear();
        }
        sportRepository.delete(sport);
        return sportDTO;
    }
}
