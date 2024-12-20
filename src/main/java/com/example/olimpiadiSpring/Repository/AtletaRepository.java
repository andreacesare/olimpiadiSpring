package com.example.olimpiadiSpring.Repository;

import com.example.olimpiadiSpring.DTO.AtletaDTO;
import com.example.olimpiadiSpring.Entity.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtletaRepository extends JpaRepository<Atleta, Integer> {

    @Query(value="select id,nome,cognome,anno,altezza_cm from atleti where altezza_cm>(select avg(altezza_cm) from atleti)",nativeQuery = true)
    List<AtletaDTO> atletiPiuAltiDellaMedia();
}
