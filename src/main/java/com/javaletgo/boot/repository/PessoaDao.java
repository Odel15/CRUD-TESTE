package com.javaletgo.boot.repository;

import com.javaletgo.boot.entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaDao {

    public static final String Hash_Key = "Pessoa";
    @Autowired
    private RedisTemplate template;


    public Pessoa save(Pessoa pessoa) {
        template.opsForHash().put(Hash_Key,pessoa.getId(), pessoa);
        return pessoa;
    }

    public List<Pessoa> findAll() {
        return template.opsForHash().values(Hash_Key);
    }
    public Pessoa findById(int id) {
        return (Pessoa) template.opsForHash().get(Hash_Key,id);

    }

    public String deletePessoa(int id) {
        template.opsForHash().delete(Hash_Key,id);
        return " A pessoa com o id "+id+" foi deletada com sucesso!! ";

    }

}
