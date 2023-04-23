package com.matheusbus.springspotmusic.service;

import java.util.List;

import com.matheusbus.springspotmusic.domain.Musica;

/**
 * MusicaService
 */
public interface MusicaService {

    void salvar(Musica musica, long playlist_id);
    List<Musica> recuperarPorPlaylistId(long playlist_id);
    Musica recuperarPorPlaylistIdEMusicaId(long playlist_id, long musica_id);
    void atualizar(Musica musica, long playlist_id);
    void excluir(long playlist_id, long musica_id);
    
}