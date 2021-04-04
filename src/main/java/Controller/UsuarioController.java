/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import SQLUtil.MySqlConnect;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author CristianSSD
 */
public class UsuarioController {

    private static UsuarioController instance;
    
    public static UsuarioController GetInstance(){
        if(instance == null){
            instance = new UsuarioController();
        }
        return instance;
    }
    
    public boolean Logar(Usuario usuario){
        String cmd = "SELECT count(1) FROM `Usuario` WHERE USUARIO_NM = "+MySqlConnect.aplicarApostofo(usuario.getUserName())
                +"and PASSWORD = "+MySqlConnect.aplicarApostofo(usuario.getPassword());
        ArrayList<HashMap> retorno = MySqlConnect.getInstance().executaConsultaPadrao(cmd);
        if(retorno.size()>0){
            Object retornoConsulta = retorno.get(0).get("count(1)");
            return ((long)retornoConsulta!=0);
        }
        return false;
    }
}
