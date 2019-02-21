package es.salesianos.repository;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import es.salesianos.model.User;

@Component
public class UserRepository {

	private static Logger log = LogManager.getLogger(UserRepository.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;

	public void insert(User userFormulario) {
		log.debug("el log funciona");
		String sql = "INSERT INTO BANCO (numero, saldo)" + "VALUES ( :numero, :saldo)";
		System.out.println(userFormulario.getNumero());
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("numero", userFormulario.getNumero());
		params.addValue("saldo", userFormulario.getSaldo());
		namedJdbcTemplate.update(sql, params);
		System.out.println("Ha guardado");
	}

	public Optional<User> search(User user) {
		String sql = "SELECT * FROM BANCO WHERE numero = ?";
		log.debug("ejecutando la consulta: " + sql);
		User person = null;
		try {
			person = (User) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(User.class), user.getNumero());
		} catch (EmptyResultDataAccessException e) {
			log.error("error", e);
		}
		return Optional.ofNullable(person);

	}

	public void update(User user) {
		String sql = "SELECT * FROM BANCO WHERE numero = ?";
		log.debug("ejecutando la consulta: " + sql);
		User person = null;
		try {
			person = (User) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(User.class), user.getNumero());
		} catch (EmptyResultDataAccessException e) {
			log.error("error", e);
		}
		sql = "UPDATE BANCO SET " + "saldo = ? WHERE numero = ?";
		jdbcTemplate.update(sql,(user.getSaldo() + person.getSaldo()), person.getNumero());
	}

	public List<User> listAllUsers() {
		String sql = "SELECT * FROM BANCO";
		List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
		for(User user : users)
			System.out.println(user.getNumero());
		return users;
	}

	public void delete(String tablename, Integer id) {
		// log.debug("id: " + id.toString());
		log.debug("tablename: " + tablename);
		String sql = "DELETE FROM " + tablename + " WHERE dni = '?'";
		log.debug(sql);
		// jdbcTemplate.update(sql, id.toString());
	}


}
