package com.example.olimpiadiSpring.Repository;

import com.example.olimpiadiSpring.DTO.SportDTO;
import com.example.olimpiadiSpring.Entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer> {

    @Query(value = "select s.nome,count(*) from sport s  join atleti a on s.id=a.id_sport group by s.nome", nativeQuery = true)
    List<Object[]> getSportConNumeroAtleti();

    @Query(value="select s.id,s.nome,s.n_giocatori from sport s join atleti a on s.id=id_sport group by s.id, s.nome, s.n_giocatori having count(*)>1",nativeQuery = true)
    List<SportDTO> getSportConNumeroAtleti2();
}

