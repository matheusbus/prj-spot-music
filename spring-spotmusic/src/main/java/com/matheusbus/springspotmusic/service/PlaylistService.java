package com.matheusbus.springspotmusic.service;

import java.util.List;

import com.matheusbus.springspotmusic.domain.Playlist;

public interface PlaylistService {
    
    void salvar(Playlist playlist);
    List<Playlist> recuperar();
    Playlist recuperarPorId(long id);
    void atualizar(Playlist playlist);
    void excluir(long id);

}
