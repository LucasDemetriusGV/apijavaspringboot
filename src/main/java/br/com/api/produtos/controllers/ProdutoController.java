package br.com.api.produtos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.models.Produto;
import br.com.api.produtos.models.ResponseModelo;
import br.com.api.produtos.services.ProdutoService;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Produto produto){
        return produtoService.cadastrarAlterar(produto, "alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Produto produto){
        return produtoService.cadastrarAlterar(produto, "cadastrar");
    }

    @GetMapping("/listar")
    public Iterable<Produto> listar(){
        return produtoService.listar();
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<ResponseModelo> remover(@PathVariable long id){
        return produtoService.remover(id);
    }

    @GetMapping("/")
    public String rota(){
        return "API de produtos funcionando!";
    }
    
}
