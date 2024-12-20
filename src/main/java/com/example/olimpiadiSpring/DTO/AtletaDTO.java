package com.example.olimpiadiSpring.DTO;

import com.example.olimpiadiSpring.Entity.Sport;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AtletaDTO {
    private Integer id;
    private String nome;
    private String cognome;
    private Integer anno;
    private Integer altezza_cm;
    private SportDTO sport;

    public AtletaDTO() {}
    public AtletaDTO(Integer id, String nome, String cognome, Integer anno,Integer altezza_cm) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.anno = anno;
        this.altezza_cm = altezza_cm;

    }

    public Integer getId(){return this.id;}
    public void setId(Integer id){this.id = id;}
    public String getNome(){return this.nome;}
    public void setNome(String nome){this.nome = nome;}
    public String getCognome(){return this.cognome;}
    public void setCognome(String cognome){this.cognome = cognome;}
    public Integer getAnno(){return this.anno;}
    public void setAnno(Integer  data){this.anno = data;}
    public Integer getAltezza_cm(){return this.altezza_cm;}
    public void setAltezza_cm(Integer altezza_cm) {this.altezza_cm = altezza_cm;}
    public SportDTO getSport(){return this.sport;}
    public void setSport(SportDTO sport) {this.sport = sport;}
}
