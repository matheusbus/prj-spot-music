package com.matheusbus.springspotmusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matheusbus.springspotmusic.domain.Playlist;
import com.matheusbus.springspotmusic.service.PlaylistService;

import jakarta.validation.Valid;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("playlists")
public class PlaylistController {
    
    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/listar")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("playlists", playlistService.recuperar());
        return new ModelAndView("/playlist/list", model);
    }
    
    @GetMapping(value = "/cadastro")
    public String preSalvar(@ModelAttribute("playlist") Playlist playlist){
        return "/playlist/add";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("playlist") Playlist playlist, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            return "/playlist/add";
        }

        playlistService.salvar(playlist);
        attr.addFlashAttribute("mensagem", "Playlist criada com sucesso.");
        return "redirect:/playlists/listar";
    }

    @GetMapping("/{id}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("id") long id, ModelMap model){
        Playlist playlist = playlistService.recuperarPorId(id);
        model.addAttribute("playlist", playlist);
        return new ModelAndView("/playlist/add", model);
    }

    @PutMapping("/salvar")
    public ModelAndView atualizar(@Valid @ModelAttribute("playlist") Playlist playlist, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return new ModelAndView("/playlist/add");
        }

        playlistService.atualizar(playlist);
        attr.addFlashAttribute("mensagem", "Playlist atualizada com sucesso.");
        return new ModelAndView("redirect:/playlists/listar");
    }

    @GetMapping("/{id}/remover")
    public String remover(@PathVariable("id") long id, RedirectAttributes attr){
        playlistService.excluir(id);
        attr.addFlashAttribute("mensagem", "Playlist excluída com sucesso.");
        return "redirect:/playlists/listar";
    }

}
