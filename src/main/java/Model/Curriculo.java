/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;

public class Curriculo {
    
    private String usuarioNM;
    private String nomeCompleto;
    private String dataNascimento;
    private String genero;
    private String escolaridade;
    private HashMap experiancia;   
    private String experienciasAdd;

    public Curriculo(String usuarioNM,String nomeCompleto, String dataNascimento, String genero,String escolaridade, HashMap experiancia, String experienciasAdd) {
        this.usuarioNM = usuarioNM;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.escolaridade = escolaridade;
        this.genero = genero;
        this.experiancia = experiancia;
        this.experienciasAdd = experienciasAdd;
    }

    public String getUsuarioNM() {
        return usuarioNM;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public int GetExperienciaJS(){
        return (int)experiancia.get("JavaScript");
    }
    public int GetExperienciaSQL(){
        return (int)experiancia.get("SQL");
    }
    public int GetExperienciaCSharp(){
        return (int)experiancia.get("CSharp");
    }
    public int GetExperienciaGitHub(){
        return (int)experiancia.get("GitHub");
    }

    public String getExperienciasAdd() {
        return experienciasAdd;
    }

    public String getGenero() {
        return genero;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
    
}
