package mx.axxib.gpi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

import mx.axxib.gpi.serv.CustomAuthenticationProvider;


@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
@EnableWebSecurity
public class SecurityConfigWeb extends WebSecurityConfigurerAdapter {
	
	
	
	@Autowired
	CustomAuthenticationProvider customAuthenticationProvider;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.authorizeRequests()
	        .antMatchers("/","/css/**", "/Imagenes/**").permitAll()	
	        .antMatchers("/home").hasAuthority("ROLE_ALL")    
            .anyRequest().authenticated().
	        and().formLogin().permitAll()
			 .loginPage("/login")
			.usernameParameter("usuario")
			.passwordParameter("password")
			.and()
			.logout().permitAll().logoutSuccessUrl("/login?logout")			
			.and().exceptionHandling().accessDeniedPage("/acessoDenegado")			
			.and().csrf().disable();
		   
		  
             

	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider);
		
	}
	

@Override
public void configure(WebSecurity web) {
    web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
}
 
@Bean
public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
    DefaultHttpFirewall firewall = new DefaultHttpFirewall();
    firewall.setAllowUrlEncodedSlash(true);
    return firewall;
}
	
	
	
	
	

 
	

}
