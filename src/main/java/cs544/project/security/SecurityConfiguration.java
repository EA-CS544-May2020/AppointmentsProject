package cs544.project.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    //Use embeded data source
            DataSource dataSource;

    //different API have different access requirements
    protected void configure(HttpSecurity http) throws Exception {
//    	http.httpBasic().and()
//        .csrf().disable().authorizeRequests()
//    	.anyRequest().hasRole("USER")
//    	.and().formLogin()
//    	.and()
//    	.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//    	.logoutSuccessUrl("/");
    	http.httpBasic().and().csrf().disable().authorizeRequests()
        .anyRequest().authenticated()
        .and().formLogin().and()
    	.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    	.logoutSuccessUrl("/");
	}
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
      throws Exception {
//        auth.inMemoryAuthentication().withUser("user")
//          .password(passwordEncoder().encode("user")).roles("USER");
        
        auth
	     .jdbcAuthentication()
	     .dataSource(dataSource)
	     .usersByUsernameQuery("select user.username as username, user.password as password, user.enabled as enabled from user where username = ?")
	     .authoritiesByUsernameQuery("select user.username as username, user.email as role from user where username = ?");
//	     .authoritiesByUsernameQuery("select user.username as username, user.roles.name as role from user where username = ?");
        
    }
//   //Not encoding password
//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }

//    //encode password
    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}