package mx.axxib.gpi.serv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

import mx.axxib.gpi.util.ConteoUsuario;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.datacontract.schemas._2004._07.DomainService_Entities.*;

@Component
public class LoginProvider implements AuthenticationProvider {
	private static final Logger LOGGER = LogManager.getLogger(LoginProvider.class);

	@Autowired
	private Environment env;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String usuario = authentication.getName();
		String usuarioObtenido = null;
		String password = authentication.getCredentials().toString();
		boolean existeUsArchivo = false;
		Authentication auth = null;

		IDomainServiceProxy proxyy = new IDomainServiceProxy();
		DTOLogin login = new DTOLogin();
		DTOResponseLogin respLogin = new DTOResponseLogin();
		BasicHttpBinding_IDomainServiceStub service = (BasicHttpBinding_IDomainServiceStub) proxyy.getIDomainService();

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String nombreUsuario = null;

		String registroUsuario = null;
		boolean usuarioEncontrado = false;
		File file = null;

		String[] parts = null;
		String part1 = null;
		String part2 = null;
		int conteo = 0;

		try {

			login.setGroupMember(null);
			login.setUserName(usuario.toLowerCase());
			login.setPassword(password);

			respLogin = service.authenticate(login);

			LOGGER.info("# CONSULTA USUARIO - EXISTE:{}, MENSAJE:{}, USUARIO:{}", respLogin.getResult(),
					respLogin.getMessage(), usuario);

			if (respLogin.getResult()) {

				try {

					archivo = new File(this.env.getProperty("ruta.archivoUsuarios"));
					fr = new FileReader(archivo);
					br = new BufferedReader(fr);

					while ((nombreUsuario = br.readLine()) != null) {
						if (nombreUsuario.toUpperCase().trim().equals(usuario.toUpperCase())) {
							existeUsArchivo = true;						

							break;

						}

					}
					LOGGER.info("# CONSULTA USUARIO - ENCONTRADO EN EL SISTEMA - USUARIO:{}, BANDERA:{}",
							usuario.toUpperCase(), existeUsArchivo);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {

					try {
						if (null != fr) {
							fr.close();
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}

				if (existeUsArchivo) {
					final List<GrantedAuthority> grantedAuths = new ArrayList<>();
					grantedAuths.add(new SimpleGrantedAuthority("ROLE_ALL"));
					final UserDetails principal = new User(usuario.toUpperCase(), password, grantedAuths);
					auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
					LOGGER.info("# CONSULTA USUARIO - AUTENTICACION CORRECTAMENTE -   USUARIO:{}",
							usuario.toUpperCase());

					try {

						file = new File(this.env.getProperty("ruta.archivoConteoUsuarios"));
						fr = new FileReader(file);
						br = new BufferedReader(fr);

						while ((registroUsuario = br.readLine()) != null)
							if (registroUsuario.toUpperCase().trim().contains(auth.getName().toUpperCase())) {
								usuarioObtenido = registroUsuario.toUpperCase().trim();
								usuarioEncontrado = true;

								break;

							}

					} catch (Exception e) {
						e.printStackTrace();
					} finally {

						try {
							if (null != fr) {
								fr.close();
							}
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}

					if (usuarioEncontrado) {
						parts = usuarioObtenido.split(" TOTAL: ");
						part1 = parts[0];
						part2 = parts[1];
						conteo = Integer.parseInt(part2);
						ConteoUsuario.crearRemplazar(part1 + " TOTAL: ", part2, "0");

					}

				} else {
					final List<GrantedAuthority> grantedAuths = new ArrayList<>();
					grantedAuths.add(new SimpleGrantedAuthority("ROLE_SE"));
					final UserDetails principal = new User(usuario.toUpperCase(), password, grantedAuths);
					auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
					LOGGER.info("# CONSULTA USUARIO - SIN REGISTRO EN EL ARCHIVO DEL SISTEMA - USUARIO:{}",
							auth.getName().toUpperCase());
				}

			} else {

				File crearArchivo = new File(this.env.getProperty("ruta.archivoConteoUsuarios"));

				if (!crearArchivo.exists()) {

					crearArchivo.createNewFile();

					ConteoUsuario.crearRemplazar(usuario.toUpperCase() + " - TOTAL: ", part2, String.valueOf(conteo));

				} else {

					try {

						crearArchivo = new File(this.env.getProperty("ruta.archivoConteoUsuarios"));
						fr = new FileReader(crearArchivo);
						br = new BufferedReader(fr);

						while ((registroUsuario = br.readLine()) != null)
							if (registroUsuario.toUpperCase().trim().contains(usuario.toUpperCase())) {
								usuarioObtenido = registroUsuario.toUpperCase().trim();
								usuarioEncontrado = true;
								LOGGER.info("# ARCHIVO CONSULTA USUARIO -   USUARIOEXISTE:{}", usuario.toUpperCase());
								break;

							}

					} catch (Exception e) {
						e.printStackTrace();
						LOGGER.error("# ERROR - ERROR AL CONSULTAR USUARIO EN EL ARCHIVO - ERROR  -  MENSAJE:{}", e.toString());
					} finally {

						try {
							if (null != fr) {
								fr.close();
							}
						} catch (Exception e2) {
							e2.printStackTrace();
							LOGGER.error("# ERROR - ERROR AL CONSULTAR USUARIO EN EL ARCHIVO - ERROR  -  MENSAJE:{}", e2.toString());
						}
					}

					if (usuarioEncontrado) {
						parts = usuarioObtenido.split(" TOTAL: ");
						part1 = parts[0];
						part2 = parts[1];
						conteo = Integer.parseInt(part2);
						conteo = conteo + 1;

						ConteoUsuario.crearRemplazar(part1 + " TOTAL: ", part2, String.valueOf(conteo));
						LOGGER.info("# ARCHIVO ACTUALIZA USUARIO -   USUARIOEXISTE:{}", usuarioObtenido);

					} else {

						ConteoUsuario.crearRemplazar(usuario.toUpperCase() + " - TOTAL: ", part2,
								String.valueOf(conteo));
						LOGGER.info("# ARCHIVO ALTA DE USUARIO -   USUARIOEXISTE:{}",
								usuario.toUpperCase() + " - TOTAL: ", part2, String.valueOf(conteo));
					}

				}

				final List<GrantedAuthority> grantedAuths = new ArrayList<>();
				grantedAuths.add(new SimpleGrantedAuthority("ROLE_IN"));
				final UserDetails principal = new User(usuario.toUpperCase(), password, grantedAuths);
				auth = new UsernamePasswordAuthenticationToken(principal, password, null);
				return auth;
			}

		} catch (Exception e) {
			LOGGER.error("# ERROR - ERROR AL CONSULTAR USUARIO EN EL ARCHIVO - ERROR  -  MENSAJE:{}", e.toString());
		}
		return auth;

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
