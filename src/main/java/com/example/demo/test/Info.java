package com.example.demo.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by lu on 2018/6/3.
 */
@Data
@AllArgsConstructor
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;

    private String phone;
    private String address;




}
