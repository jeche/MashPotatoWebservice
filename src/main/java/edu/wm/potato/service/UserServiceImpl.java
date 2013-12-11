package edu.wm.potato.service;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.wm.potato.dao.IPotatoUserDAO;
import edu.wm.potato.dao.authUser;
import edu.wm.potato.model.PotatoUser;

@Service("userService")
public class UserServiceImpl implements UserDetailsService {
	@Autowired IPotatoUserDAO userDAO;
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		System.out.println("User is " + username);
		return null;
		/*PotatoUser user = userDAO.getUserByUsername(username);
		System.out.println("User is " + username);
		BCryptPasswordEncoder encoded = new BCryptPasswordEncoder();
		// TODO: Remove admin functionality
//		logger.info(user.toString());
		if(user == null && username.equals("admin")) {
			// Ignore simply used for setup
			;
			userDAO.createUser(new PotatoUser("admin", "admin", "admin", "admin", encoded.encode("admin"), 0, true, 0, 0, 0, 0));
			user.setAdmin(true);
			userDAO.update(user);
			user = userDAO.getUserByUsername(username);
		}
		else if(user == null && !username.equals("admin")) {
			System.out.println("Grabbed null user." + username);
			return null;
		}
		
		Collection<GrantedAuthorityImpl> authorities = new ArrayList<GrantedAuthorityImpl>();
		authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
		// remove || later after setting up database
		if(user.isAdmin() || username.equals("admin")) {
			authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		}
		System.out.println("User is: " + user);
		logger.info("User is: " + user);
		return new authUser(user.getuId(), user.getHashedPassword(), true, true, true, true, authorities);*/
	}

}