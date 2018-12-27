package br.com.ricardo.springboot.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1l;

    private Integer status;
    private String msg;
    private Long timeStamp;


}
