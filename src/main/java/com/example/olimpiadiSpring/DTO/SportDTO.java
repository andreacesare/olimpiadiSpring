package com.example.olimpiadiSpring.DTO;

import com.example.olimpiadiSpring.Entity.Atleta;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SportDTO {
    private Integer id;
    private String nome;
    private Integer ngiocatori;
    private List<AtletaDTO> atleti=new ArrayList<>();


    public Integer getId() {return id;}
    public String getNome() {return nome;}
    public Integer getNgiocatori() {return ngiocatori;}
    public void setId(Integer id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setNgiocatori(Integer ngiocatori) {this.ngiocatori = ngiocatori;}
    public void aggiungiAtleta(AtletaDTO atletaDTO) {
        atleti.add(atletaDTO);
        atletaDTO.setSport(this);
    }
    public List<AtletaDTO> getAtleti() {return atleti;}
    public void setAtleti(List<AtletaDTO> atleti) {
        this.atleti = atleti;
    }
}
