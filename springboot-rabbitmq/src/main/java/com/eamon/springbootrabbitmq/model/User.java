package com.eamon.springbootrabbitmq.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author eamon
 * @date 2019/08/08 16:59
 **/
@Data
public class User implements Serializable {
    private int id;
    private String username;
}
