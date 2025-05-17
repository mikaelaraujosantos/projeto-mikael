package com.example.crud3.controller;

import com.example.crud3.model.Produto;
import com.example.crud3.repository.ProdutoRepository;
import com.example.crud3.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IAttribute;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String listaProdutos(Model model){
        List<Produto> produtos = produtoService.listarTodos();
        model.addAttribute("produtos", produtos);

        return"produtos/listar";
    }

    @GetMapping("/novo")
    public String mostrarFormularioNovoProduto(Model model){
        model.addAttribute("produto", new Produto());
        return "produtos/formulario";
    }

    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute("produto") Produto produto){
        produtoService.salvar(produto);

        return "redirect:/produtos";
    }

    @GetMapping("/editar{id}")
    public String editar(@PathVariable Long id, Model model){
        model.addAttribute("produto", produtoService.buscarPorId(id));

        return "produtos/formulario";
    }

    @GetMapping("deletar/{id}")
    public String deletar(@PathVariable Long id){
        produtoService.deletar(id);
        return "redirect:/produtos";
    }
}
