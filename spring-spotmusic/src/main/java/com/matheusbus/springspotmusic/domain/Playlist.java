package com.matheusbus.springspotmusic.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tbplaylist")
public class Playlist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "O nome não pode estar em branco.")
    @Size(min = 2, max = 60, message = "O tamanho deve estar entre 2 e 60 caracteres.")
    @Column(nullable = false, length = 60)
    private String nome;

    @NotBlank(message = "O campo 'descrição' não pode estar em branco.")
    @Size(min = 10, max = 100, message = "O campo 'descrição' deve conter entre 10 e 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String descricao;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    private List<Musica> musicas = new ArrayList<>();



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public boolean addMusica(Musica musica){
        return this.musicas.add(musica);
    }

    public boolean removeMusica(Musica musica){
        for (Musica m : musicas) {
            if(m.getTitulo().equals(musica.getTitulo())){
                return this.musicas.remove(m);
            }
        }
        return false;
    }

}
