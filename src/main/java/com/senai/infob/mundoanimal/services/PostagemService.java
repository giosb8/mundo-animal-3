package com.senai.infob.mundoanimal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.mundoanimal.models.Postagem;
import com.senai.infob.mundoanimal.repositories.PostagemRepository;

@Service
public class PostagemService {


    @Autowired
    private PostagemRepository postagemRepository;


    public Postagem salvar(Postagem postagem) {

        return postagemRepository.save(postagem);

    }


    public List<Postagem> lista() {

        return postagemRepository.findAll();

    }


    public Postagem busca(Integer id) {

        return postagemRepository.findById(id).orElse(null);

    }

    public Postagem buscarPorId(Integer id) {
    return postagemRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Postagem não encontrada"));
}


    public boolean delete(Integer id) {

        if(postagemRepository.existsById(id)) {

            postagemRepository.deleteById(id);
            return true;

        }

        return false;
    }
}