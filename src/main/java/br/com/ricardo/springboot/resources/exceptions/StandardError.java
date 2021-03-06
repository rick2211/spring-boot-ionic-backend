package br.com.ricardo.springboot.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1l;

    private Integer status;
    private String msg;
    private Long timeStamp;


}
