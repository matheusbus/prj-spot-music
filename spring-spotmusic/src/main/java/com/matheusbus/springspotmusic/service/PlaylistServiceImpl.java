package com.matheusbus.springspotmusic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusbus.springspotmusic.dao.PlaylistDAO;
import com.matheusbus.springspotmusic.domain.Playlist;

import jakarta.transaction.Transactional;

/**
 * PlaylistServiceImpl
 */
@Service
@Transactional
public class PlaylistServiceImpl implements PlaylistService{

    @Autowired
    private PlaylistDAO playlistDAO;

    @Override
    public void salvar(Playlist playlist) {
        playlistDAO.salvar(playlist);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    // Transctional readOnly = Indica que neste método iremos só ler dados e não alterar nada    
    public List<Playlist> recuperar() {
        return playlistDAO.recuperar();
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true) 
    // Transctional readOnly = Indica que neste método iremos só ler dados e não alterar nada
    public Playlist recuperarPorId(long id) {
        return playlistDAO.recuperarPorId(id);
    }

    @Override
    public void atualizar(Playlist playlist) {
        playlistDAO.atualizar(playlist);
    }

    @Override
    public void excluir(long id) {
        playlistDAO.excluir(id);
    }

}