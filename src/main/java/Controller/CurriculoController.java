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

public class CurriculoController {

    private static CurriculoController instance;
        
        //Singleton
    public static CurriculoController GetInstance(){
        //Verifica se existe uma instancia já criada
        if(instance == null){
            //Caso não exista uma instancia criada cria uma
            instance = new CurriculoController();
        }
        //Retorno a instancia 
        return instance;
    }
    
    public boolean Cadastrar(Curriculo curriculo){
        //Criação da linha de comando para inserir um curriculo no banco de dados
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
        //Execução do comando no banco de dados
        return MySqlConnect.getInstance().executaComandoPadrao(cmd);
    }
    
    public boolean Atualizar(Curriculo curriculo){
        //Criação da linha de comando para atualizar as informaçoes do curriculo do usuario informado
        String cmd = "UPDATE CURRICULO SET NOME_COMPLETO = "+MySqlConnect.aplicarApostofo(curriculo.getNomeCompleto())
                +", DT_NASCIMENTO="+MySqlConnect.aplicarApostofo(curriculo.getDataNascimento())
                +",GENERO="+MySqlConnect.aplicarApostofo(curriculo.getGenero())
                +",ESCOLARIDADE="+MySqlConnect.aplicarApostofo(curriculo.getEscolaridade())
                +",EXPERIENCIAADD="+MySqlConnect.aplicarApostofo(curriculo.getExperienciasAdd())
                +",JAVASCRIPT_EXP="+curriculo.GetExperienciaJS()
                +",SQL_EXP="+curriculo.GetExperienciaSQL()
                +",CSHARP_EXP="+curriculo.GetExperienciaCSharp()
                +",GITHUB_EXP="+curriculo.GetExperienciaGitHub()
                +" WHERE USUARIO_NM="+ MySqlConnect.aplicarApostofo(curriculo.getUsuarioNM());
        //Execução da query ao banco de dados
        return MySqlConnect.getInstance().executaComandoPadrao(cmd);
    }
    
    public boolean DeletarCurriculo(Usuario usuario){
        //Criação da linha de comando para deletar o curriculo pertencete ao usuario informado
        String cmd = "Delete from CURRICULO WHERE USUARIO_NM ="+MySqlConnect.aplicarApostofo(usuario.getUserName());
        //Execução da query no banco de dados
        return MySqlConnect.getInstance().executaComandoPadrao(cmd);
    }
    
    public boolean HasCurriculoCadastrado(Usuario usuario){
        //Criação da linha de comando para verificar se existe algum curriculo para o usuario informado
        String cmd = "SELECT count(1) FROM CURRICULO WHERE USUARIO_NM = "+MySqlConnect.aplicarApostofo(usuario.getUserName());
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
        //retorno padrao do método
        return false;
    }
    
    public Curriculo GetCurriculo(Usuario usuario){
        //Criação da linha de comando para obter o curriculo pertencente ao usuario informado
        String cmd = "SELECT * FROM CURRICULO WHERE USUARIO_NM ="+MySqlConnect.aplicarApostofo(usuario.getUserName());
        //Execução da query no banco de dados
        ArrayList<HashMap> retorno = MySqlConnect.getInstance().executaConsultaPadrao(cmd);
        //Verificando teve algum retorno do banco de dados
        if(retorno.size()>0){
            //caso exista um retorno do banco
            //Armazena essa informação em uma objecto
            HashMap retornoHM = retorno.get(0);
            //Criação de um HashMap para armazenar as informações dos RadioButton
            HashMap experiencias = new HashMap();
            //Guardando as informações do banco no HashMap de acordo com o RadioButton
            experiencias.put("JavaScript", (Integer)retornoHM.get("JAVASCRIPT_EXP"));
            experiencias.put("SQL", (Integer)retornoHM.get("SQL_EXP"));
            experiencias.put("CSharp", (Integer)retornoHM.get("CSHARP_EXP"));
            experiencias.put("GitHub", (Integer)retornoHM.get("GITHUB_EXP"));
            //Criando Objeto Curriculo com as informações que foram obtidas na consulta
            //Utilizando a chave para pegar os valoes inseridos no banco de dados
            Curriculo curriculo = new Curriculo((String)retornoHM.get("USUARIO_NM"),
                    (String)retornoHM.get("NOME_COMPLETO"),
                    (String)retornoHM.get("DT_NASCIMENTO"),
                    (String)retornoHM.get("GENERO"),
                    (String)retornoHM.get("ESCOLARIDADE"),
                    experiencias, 
                    (String)retornoHM.get("EXPERIENCIAADD"));
            //Retornando o curriculo que o banco de dados retornou
            return curriculo;
        }
        //Retorno padrao do método
        return null;
    }
}
