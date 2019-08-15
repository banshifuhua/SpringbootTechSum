package com.eamon.springbootsecurityjwt.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author eamon
 * @date 2019/08/15 15:32
 **/
@Data
public class ViewData<V> implements Serializable {
    protected int code;
    protected V data;
    protected Object error;
}
