package com.senai.infob.mundoanimal.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.senai.infob.mundoanimal.models.Postagem;
import com.senai.infob.mundoanimal.services.PostagemService;

@RestController
@RequestMapping("/postagem")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;


    @PostMapping(value = "/salvar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public Postagem salvar(
        @RequestParam String titulo,
        @RequestParam String descricao,
        @RequestParam String localizacao,
        @RequestParam String telContato,
        @RequestParam LocalDate dataHora,
        @RequestParam Boolean paginas,
        @RequestParam MultipartFile imagem
) throws IOException {

    Postagem postagem = new Postagem();

    postagem.setTitulo(titulo);
    postagem.setDescricao(descricao);
    postagem.setLocalizacao(localizacao);
    postagem.setTelContato(telContato);
    postagem.setDataHora(dataHora);
    postagem.setPaginas(paginas);
    postagem.setImagem(imagem.getBytes());

    return postagemService.salvar(postagem);
}


    @GetMapping("/lista")
    public List<Postagem> lista() {
        return postagemService.lista();
    }


    @GetMapping("/busca/{id}")
    public Postagem busca(@PathVariable Integer id) {
        return postagemService.busca(id);
    }


    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id) {

        boolean deletou = postagemService.delete(id);

        if(deletou) {
            return "Postagem removida com sucesso";
        }

        return "Erro ao remover postagem";
    }
}