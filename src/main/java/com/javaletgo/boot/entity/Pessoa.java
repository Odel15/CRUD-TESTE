package com.javaletgo.boot.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Pessoa")
public class Pessoa implements Serializable {
    @Id
    private int id;
    private String nome;
    private String email;
    public String tel;

}
