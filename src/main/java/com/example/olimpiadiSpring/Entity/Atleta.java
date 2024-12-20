package com.example.olimpiadiSpring.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="atleti")
public class Atleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cognome;
    private int anno;
    private int altezza_cm;
    @ManyToOne
    @JoinColumn(name="id_sport")
    private Sport sport;

    public Integer getId(){return this.id;}
    public void setId(Integer id){this.id = id;}
    public String getNome(){return this.nome;}
    public void setNome(String nome){this.nome = nome;}
    public String getCognome(){return this.cognome;}
    public void setCognome(String cognome){this.cognome = cognome;}
    public int getAnno(){return this.anno;}
    public void setAnno(int  data){this.anno = data;}
    public int getAltezza_cm(){return this.altezza_cm;}
    public void setAltezza_cm(int altezza_cm) {this.altezza_cm = altezza_cm;}
    public Sport getSport(){return this.sport;}
    public void setSport(Sport sport) {this.sport = sport;}
}
