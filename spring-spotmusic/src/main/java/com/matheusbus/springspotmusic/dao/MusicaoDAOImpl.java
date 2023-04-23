package com.matheusbus.springspotmusic.dao;

import java.util.List;

import com.matheusbus.springspotmusic.domain.Musica;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class MusicaoDAOImpl implements MusicaDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Musica musica) {
        em.persist(musica);
    }

    @Override
    public List<Musica> recuperarPorPlaylist(long playlist_id) {
        return em.createQuery("select m from Musica m where m.playlist_id = :playlist_id", Musica.class)
            .setParameter("playlist_id", playlist_id)
            .getResultList();
    }

    @Override
    public Musica recuperarPorPlaylistIdEMusicaId(long playlist_id, long musica_id) {
        return em.createQuery("select m from Musica m where m.playlist.id = :playlist_id and m.id = :musica_id", Musica.class)
            .setParameter("playlist_id", playlist_id)
            .setParameter("musica_id", musica_id)
            .getSingleResult();
    }

    @Override
    public void atualizar(Musica musica) {
        em.merge(musica);
    }

    @Override
    public void excluir(long musicaId) {
        em.remove(em.getReference(Musica.class, musicaId));
    }
    
}
