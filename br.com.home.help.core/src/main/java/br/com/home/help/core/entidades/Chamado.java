package br.com.home.help.core.entidades;

import java.util.Date;

public class Chamado {

    private Long id;
    
    private Date data;
    
    private String observacao;
    
    private String descricao;
    
    private String status;
    
    private Cliente cliente;
    
    private Prestador prestador;
    
    private Agenda agenda;
}
