package com.example.olimpiadiSpring.Repository;

import com.example.olimpiadiSpring.Entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer> {
}
