package de.studiapp.pms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



/**
 * Spring Security configuration class. Enables all necessary Spring Security
 * functions.
 * 
 * @author AH/DH
 * 
 * @category SecurityConfiguration
 * 
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static String encryptedPasswordHashAdmin = null;
	private static String encryptedPasswordHashUser = null;
	
	static {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String clearPasswordAdmin = "1234";
		String clearPasswordUser = "abcd";

		encryptedPasswordHashAdmin = encoder.encode(clearPasswordAdmin);
		encryptedPasswordHashUser = encoder.encode(clearPasswordUser);
	}

	/**
	 * Creates the AuthenticationManager with the given values.
	 *
	 * @param auth the AuthenticationManagerBuilder
	 * @throws Exception a given exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("admin")
				.password(encryptedPasswordHashAdmin).authorities("Role_Admin")
		.and()
				.passwordEncoder(passwordEncoder()).withUser("user")
				.password(encryptedPasswordHashUser).authorities("Role_User");

	}
	
	private SecurityExpressionHandler<FilterInvocation> expressionHandler() {
        DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
        defaultWebSecurityExpressionHandler.setRoleHierarchy(roleHierarchy());
        return defaultWebSecurityExpressionHandler;
    }
	
	/**
	 * A given password encoding mechanism.
	 *
	 * @return PasswordEncoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	 @Bean
     public RoleHierarchyImpl roleHierarchy() {
     RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
         String hierarchy ="ROLE_ADMIN > ROLE_USER and ROLE_USER > ROLE_TESTER";
         roleHierarchy.setHierarchy(hierarchy);
      return roleHierarchy;
     }

	/**
	 * Sets the security mechanism.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.expressionHandler(expressionHandler())
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				.antMatchers("/", "/index", "/welcome", "/vv/findAll").permitAll()
				.antMatchers("/admin/**").hasAnyAuthority("Role_Admin", "Role_User")
				.anyRequest().fullyAuthenticated()
				.and()
				.formLogin()
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/admin", true)
				.failureUrl("/login")
				.and().logout().logoutSuccessUrl("/index")
				.invalidateHttpSession(true).logoutSuccessUrl("/login").logoutUrl("/logout").and().exceptionHandling();

	}

}
