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

public class UsuarioController {

    private static UsuarioController instance;
    
    //Singleton
    public static UsuarioController GetInstance(){
        //Verifica se existe uma instancia já criada
        if(instance == null){
            //Caso não exista uma instancia criada cria uma
            instance = new UsuarioController();
        }
        //Retorno a instancia 
        return instance;
    }
    
    //Metodo para verificar se existe um registro com o usuario e senha iguais aos informados
    public boolean Logar(Usuario usuario){
        //Criação do comando a ser enviado ao banco
        String cmd = "SELECT count(1) FROM `Usuario` WHERE USUARIO_NM = "+MySqlConnect.aplicarApostofo(usuario.getUserName())
                +"and PASSWORD = "+MySqlConnect.aplicarApostofo(usuario.getPassword());
        //Execução da query no banco de dados
        ArrayList<HashMap> retorno = MySqlConnect.getInstance().executaConsultaPadrao(cmd,false);
        //Verificando teve algum retorno do banco de dados
        if(retorno.size()>0){
            //caso exista um retorno do banco
            //Armazena essa informação em uma objecto
            Object retornoConsulta = retorno.get(0).get("count(1)");
            //Retorna sim caso o resultado count(1) seja diferente de 0
            //Retorna não caso o resultado seja 0
            return ((long)retornoConsulta!=0);
        }
        //Retorno padrao do método
        return false;
    }
}
