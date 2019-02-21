package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import es.salesianos.model.User;

@Component
public class UserAssembler {

	public User createUserFromRequest(HttpServletRequest request) {

		User user = new User();
		user.setNumero(request.getParameter("numero"));
		user.setSaldo(Integer.parseInt(request.getParameter("saldo")));
		return user;
	}

}
