package cs544.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserSecurityService userDetailsService;

	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic().and()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/").permitAll()
	        .antMatchers("/login").permitAll()
	        .antMatchers(HttpMethod.POST,"/appointments/{\\d+}/reservations").hasAuthority("STUDENT")
	        .antMatchers(HttpMethod.GET,"/appointments/{\\d+}/reservations").hasAuthority("CHECKER")
	        .antMatchers("/reservations/**").hasAnyAuthority("STUDENT", "CHECKER")
			.antMatchers("/users/**", "/appointments/**","/roles/**").hasAuthority("CHECKER")
	        
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

	}
}