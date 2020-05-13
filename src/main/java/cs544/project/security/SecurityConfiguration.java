package cs544.project.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
//Method security
//@EnableGlobalMethodSecurity(
////        The prePostEnabled property enables Spring Security pre/post annotations
//
//        prePostEnabled = true
////        The securedEnabled property determines if the @Secured annotation should be enabled
//
//        //       securedEnabled = true,
//
////        The jsr250Enabled property allows us to use the @RoleAllowed annotation
//        //       jsr250Enabled = true
//)

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    //Use embeded data source
            DataSource dataSource;

    //different API have different access requirements
    protected void configure(HttpSecurity http) throws Exception {
//    	http.antMatcher("/**").authorizeRequests().anyRequest().hasRole("USER").and().formLogin();
//    	http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    	http.authorizeRequests().anyRequest().hasRole("USER").and().httpBasic();
    	http.csrf().disable();
	}

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    	auth.inMemoryAuthentication().withUser("user")
//        .password("user").roles("USER");
//    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
      throws Exception {
        auth.inMemoryAuthentication().withUser("user")
          .password(passwordEncoder().encode("user")).roles("USER");
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
//    //Method security
//    public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
//    }
}