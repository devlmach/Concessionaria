package com.example.store.Controller;

import com.example.store.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    @Autowired
    private ProdutoRepository produtoRepository;

}
