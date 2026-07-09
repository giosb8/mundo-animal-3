package com.senai.infob.mundoanimal.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.senai.infob.mundoanimal.models.Postagem;
import com.senai.infob.mundoanimal.services.PostagemService;

@RestController
@RequestMapping("/postagem")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;

    @GetMapping("/count")
    public Long count() {
        return postagemService.count();
    }

    @PostMapping(value = "/salvar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Postagem salvar(
            @RequestPart("postagem") Postagem postagem,
            @RequestPart("imagem") MultipartFile imagem) throws IOException {

        postagem.setImagem(imagem.getBytes());

        return postagemService.salvar(postagem);
    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id) {
        boolean deletou = postagemService.delete(id);

        if (deletou) {
            return "Postagem removida com sucesso";
        }

        return "Falha ao remover a postagem";
    }

    @GetMapping("/busca/id/{id}")
    public Postagem buscaPorId(@PathVariable Integer id) {
        return postagemService.busca(id);
    }

    @GetMapping("/busca/pagina/{pagina}")
    public List<Postagem> buscaPorPagina(@PathVariable String pagina) {
        return postagemService.buscaPostagens(pagina);
    }

    @GetMapping("/lista")
    public List<Postagem> lista() {
        return postagemService.lista();
    }

    @PutMapping(value = "/atualizar/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Postagem atualizar(
            @PathVariable Integer id,
            @RequestPart("postagem") Postagem postagem,
            @RequestPart(value = "imagem", required = false) MultipartFile imagem)
            throws IOException {

        if (imagem != null && !imagem.isEmpty()) {
            postagem.setImagem(imagem.getBytes());
        }

        return postagemService.atualizar(postagem, id);
    }
}