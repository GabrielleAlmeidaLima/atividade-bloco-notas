package projeto_java_com_bd.model;

import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;

@Repository
public class NotasDAO {
    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirNota(Notas nota){
        String sql = "INSERT INTO nota(conteudo) VALUES (?)";
        Object[] obj = new Object[1];
        obj[0] = nota.getConteudo();

        jdbc.update(sql, obj);
    }

    public Notas mostrarNotas(String uuid){
		String sql = "SELECT * FROM nota where id=?::uuid";
		return Notas.converter(jdbc.queryForMap(sql,uuid));
    }

    	public ArrayList<Notas> listarNotas(){
		String sql = "SELECT * FROM nota";
		return Notas.converterTodos(jdbc.queryForList(sql));
	}
}

