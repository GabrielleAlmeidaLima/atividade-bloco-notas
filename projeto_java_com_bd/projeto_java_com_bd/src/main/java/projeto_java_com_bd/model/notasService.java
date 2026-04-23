package projeto_java_com_bd.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class notasService {
    @Autowired
    NotasDAO NotasDAO;

    public void inserirNota(Notas notas){
        NotasDAO.inserirNota(notas);
    }

    public Notas mostrarNotas(String uuid){
        return NotasDAO.mostrarNotas(uuid);
    }

    public ArrayList<Notas> listarNotas(){
        return NotasDAO.listarNotas();
    }
}


