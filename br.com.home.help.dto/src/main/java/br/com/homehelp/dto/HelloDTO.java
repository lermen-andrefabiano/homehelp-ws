package br.com.homehelp.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "hello")
public class HelloDTO {

    public Long id;

    public String descricao;

}