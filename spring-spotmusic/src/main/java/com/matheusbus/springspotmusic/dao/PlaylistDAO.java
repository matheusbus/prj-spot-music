package com.matheusbus.springspotmusic.dao;

import java.util.List;

import com.matheusbus.springspotmusic.domain.Playlist;

public interface PlaylistDAO {

    void salvar(Playlist playlist);
    List<Playlist> recuperar();
    Playlist recuperarPorId(long id);
    void atualizar(Playlist playlist);
    void excluir(long id);
    
}
