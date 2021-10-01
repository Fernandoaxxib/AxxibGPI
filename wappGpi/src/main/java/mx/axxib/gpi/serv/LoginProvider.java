package mx.axxib.gpi.serv;


import java.util.ArrayList;
import java.util.List;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.tempuri.BasicHttpBinding_IDomainServiceStub;
import org.tempuri.IDomainServiceProxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.datacontract.schemas._2004._07.DomainService_Entities.*;

@Component
public class LoginProvider implements AuthenticationProvider{
	private static final Logger LOGGER = LogManager.getLogger(LoginProvider.class);
	
	@Override
    public Authentication authenticate(Authentication authentication)     throws AuthenticationException {
 
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        Authentication auth = null;
        
        IDomainServiceProxy proxyy = new IDomainServiceProxy();	
 		DTOLogin login = new DTOLogin();
 		DTOResponseLogin respLogin = new DTOResponseLogin();
 		BasicHttpBinding_IDomainServiceStub service = (BasicHttpBinding_IDomainServiceStub) proxyy.getIDomainService();
 		
      
       try {    
    	   
    	   login.setGroupMember(null);
   		   login.setUserName(name.toLowerCase());
   		   login.setPassword(password);        	

    	   respLogin = service.authenticate(login);
    		
    	   LOGGER.info("# CONSULTA USUARIO - EXISTE:{}, MENSAJE:{}, USUARIO:{}", respLogin.getResult() , respLogin.getMessage(), name.toLowerCase());
        	
    		if(respLogin.getResult()) {        		
        		final List<GrantedAuthority> grantedAuths = new ArrayList<>();
    			grantedAuths.add(new SimpleGrantedAuthority("ROLE_ALL"));
    			final UserDetails principal = new User(name, password, grantedAuths);
    			auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
    			LOGGER.info("# CONSULTA USUARIO - AUTENTICACION CORRECTAMENTE -   USUARIO:{}",  name.toLowerCase());
        		
        		
        	}else {
        		return null;
        	}
        	
        
       } catch(Exception e) {
    	   LOGGER.error("# ERROR - CONSULTA DE USUARIO (LOGIN) - ERROR  -  MENSAJE:{}",e.toString() ); 
      }
       return auth; 
        
    }

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}

	