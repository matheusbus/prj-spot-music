package com.matheusbus.springspotmusic.dao;

import java.util.List;

import com.matheusbus.springspotmusic.domain.Musica;

public interface MusicaDAO {
    
    void salvar(Musica musica);
    List<Musica> recuperarPorPlaylist(long playlist_id);
    Musica recuperarPorPlaylistIdEMusicaId(long playlist_id, long musica_id);
    void atualizar(Musica musica);
    void excluir(long musicaId);

}
