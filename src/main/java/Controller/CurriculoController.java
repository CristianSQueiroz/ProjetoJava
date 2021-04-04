/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Curriculo;
import Model.Usuario;
import SQLUtil.MySqlConnect;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author CristianSSD
 */
public class CurriculoController {

    private static CurriculoController instance;
    
    public static CurriculoController GetInstance(){
        if(instance == null){
            instance = new CurriculoController();
        }
        return instance;
    }
    
    public boolean Cadastrar(Curriculo curriculo){
        String cmd = "INSERT INTO CURRICULO (USUARIO_NM,NOME_COMPLETO,DT_NASCIMENTO,GENERO,ESCOLARIDADE,"
                + " EXPERIENCIAADD,JAVASCRIPT_EXP,SQL_EXP,CSHARP_EXP,GITHUB_EXP) VALUES("
                + MySqlConnect.aplicarApostofo(curriculo.getUsuarioNM())+","
                + MySqlConnect.aplicarApostofo(curriculo.getNomeCompleto())+","
                + MySqlConnect.aplicarApostofo(curriculo.getDataNascimento())+","
                + MySqlConnect.aplicarApostofo(curriculo.getGenero())+","
                + MySqlConnect.aplicarApostofo(curriculo.getEscolaridade())+","
                + MySqlConnect.aplicarApostofo(curriculo.getExperienciasAdd())+","
                + curriculo.GetExperienciaJS()+","
                + curriculo.GetExperienciaSQL()+","
                + curriculo.GetExperienciaCSharp()+","
                + curriculo.GetExperienciaGitHub()
                +")";
        return MySqlConnect.getInstance().executaComandoPadrao(cmd);
    }
    
    public boolean DeletarCurriculo(Usuario usuario){
        String cmd = "Delete from CURRICULO WHERE USUARIO_NM ="+MySqlConnect.aplicarApostofo(usuario.getUserName());
        return MySqlConnect.getInstance().executaComandoPadrao(cmd);
    }
    
    public Curriculo GetCurriculo(Usuario usuario){
        String cmd = "SELECT * FROM CURRICULO WHERE USUARIO_NM ="+MySqlConnect.aplicarApostofo(usuario.getUserName());
        ArrayList<HashMap> retorno = MySqlConnect.getInstance().executaConsultaPadrao(cmd);
        if(retorno.size()>0){
            HashMap retornoHM = retorno.get(0);
            HashMap experiencias = new HashMap();
            experiencias.put("JavaScript", (Integer)retornoHM.get("JAVASCRIPT_EXP"));
                    experiencias.put("SQL", (Integer)retornoHM.get("SQL_EXP"));
                    experiencias.put("CSharp", (Integer)retornoHM.get("CSHARP_EXP"));
                    experiencias.put("GitHub", (Integer)retornoHM.get("GITHUB_EXP"));
            Curriculo curriculo = new Curriculo((String)retornoHM.get("USUARIO_NM"),
                    (String)retornoHM.get("NOME_COMPLETO"),
                    (String)retornoHM.get("DT_NASCIMENTO"),
                    (String)retornoHM.get("GENERO"),
                    (String)retornoHM.get("ESCOLARIDADE"),
                    experiencias, 
                    (String)retornoHM.get("EXPERIENCIAADD"));
            return curriculo;
        }
        return null;
    }
}
