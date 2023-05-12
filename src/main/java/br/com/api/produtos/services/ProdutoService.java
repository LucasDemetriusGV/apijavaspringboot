package br.com.api.produtos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.models.Produto;
import br.com.api.produtos.models.ResponseModelo;
import br.com.api.produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ResponseModelo responseModelo;

    /**
     * @return
     */
    public Iterable<Produto> listar(){
        return produtoRepository.findAll();
    }

    public ResponseEntity<?> cadastrarAlterar(Produto produto, String acao){

        if(produto.getNome().equals("")){
            responseModelo.setMensagem("Nome do produto é requerido");
            return new ResponseEntity<ResponseModelo>(responseModelo, HttpStatus.BAD_REQUEST);
        } else if (produto.getMarca().equals("")){
            responseModelo.setMensagem("Nome da marca é requerido");
            return new ResponseEntity<ResponseModelo>(responseModelo, HttpStatus.BAD_REQUEST);
        } else {
            if(acao.equals("cadastrar")) {
                return new ResponseEntity<Produto>(produtoRepository.save(produto), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<Produto>(produtoRepository.save(produto), HttpStatus.OK);
            }
        }

    }

    public ResponseEntity<ResponseModelo> remover(Long id){

        produtoRepository.deleteById(id);

        responseModelo.setMensagem("Produto removido");
        return new ResponseEntity<ResponseModelo>(responseModelo, HttpStatus.OK);

    }
    
}
