package com.matheusbus.springspotmusic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusbus.springspotmusic.dao.MusicaDAO;
import com.matheusbus.springspotmusic.domain.Musica;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaDAO musicaDAO;

    @Autowired
    private PlaylistService playlistService;

    @Override
    public void salvar(Musica musica, long playlist_id) {
        musica.setPlaylist(playlistService.recuperarPorId(playlist_id));
        musicaDAO.salvar(musica);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    // Transctional readOnly = Indica que neste método iremos só ler dados e não alterar nada    
    public List<Musica> recuperarPorPlaylistId(long playlist_id) {
        return musicaDAO.recuperarPorPlaylist(playlist_id);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    // Transctional readOnly = Indica que neste método iremos só ler dados e não alterar nada    
    public Musica recuperarPorPlaylistIdEMusicaId(long playlist_id, long musica_id) {
        return musicaDAO.recuperarPorPlaylistIdEMusicaId(playlist_id, musica_id);
    }

    @Override
    public void atualizar(Musica musica, long playlist_id) {
        musica.setPlaylist(playlistService.recuperarPorId(playlist_id));
        musicaDAO.atualizar(musica);
    }

    @Override
    public void excluir(long playlist_id, long musica_id) {
        musicaDAO.excluir(recuperarPorPlaylistIdEMusicaId(playlist_id, musica_id).getId());
    }
    
}
