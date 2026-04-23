package projeto_java_com_bd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Notas {

    private String id, conteudo;

    public Notas(){
    }

    //select
    public Notas(String id, String conteudo){
        this.id = id;
        this.conteudo = conteudo;
    }

    //insert
    public Notas(String conteudo){
        this.conteudo = conteudo;
    }

    public String getId(){
        return id;
    }

    public String getConteudo(){
        return conteudo;
    }

    public void setId (String id){
        this.id = id;
    }

    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }

    public static Notas converter(Map<String,Object> registro){
        String conteudo = (String) registro.get("conteudo");
        UUID id = (UUID) registro.get("id");
        return new Notas(id.toString(), conteudo);
    }

    public static ArrayList<Notas> converterTodos(List<Map<String,Object>> registros){
        ArrayList<Notas> aux = new ArrayList<>();
        for(Map<String,Object> registro : registros){
            aux.add(converter(registro));
        }
        return aux;
    }



    
}
