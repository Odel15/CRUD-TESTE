package com.javaletgo.boot;

import com.javaletgo.boot.entity.Pessoa;
import com.javaletgo.boot.repository.PessoaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/pessoa")
public class SpringTddRedisApplication {
    @Autowired
    private PessoaDao dao;

    @PostMapping
    public Pessoa save(@RequestBody Pessoa pessoa) {
        return dao.save(pessoa);
    }

    @GetMapping
    public List<Pessoa> getAllProducts() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Pessoa findPessoa(@PathVariable int id) {
        return dao.findById(id);
    }
    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id)   {
        return dao.deletePessoa(id);
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringTddRedisApplication.class, args);
    }

}
