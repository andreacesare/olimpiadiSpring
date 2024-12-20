package com.example.olimpiadiSpring.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sport")
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(name="n_giocatori")
    private Integer ngiocatori;
    @OneToMany(mappedBy = "sport")
    private List<Atleta> atleti=new ArrayList<>();

    public Sport(){};

    public Sport(Integer id, String nome, int ngiocatori) {
        this.id = id;
        this.nome = nome;
        this.ngiocatori = ngiocatori;
    }

    public Integer getId() {return id;}
    public String getNome() {return nome;}
    public Integer getNgiocatori() {return ngiocatori;}
    public void setId(Integer id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setNgiocatori(Integer ngiocatori) {this.ngiocatori = ngiocatori;}
    public void aggiungiAtleta(Atleta atleta) {
        atleti.add(atleta);
        atleta.setSport(this);
    }
    public List<Atleta> getAtleti() {return atleti;}
    public void setAtleti(List<Atleta> atleti) {
        this.atleti = atleti;
    }
}
