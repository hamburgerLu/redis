package com.example.demo.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by lu on 2018/6/3.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {


    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String password;

}
