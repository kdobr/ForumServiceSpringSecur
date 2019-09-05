package telran.ashkelon2018.forum.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import static telran.ashkelon2018.forum.api.ForumAndPoint.*;


@Configuration //show for program to take instruction from here
@EnableWebSecurity
@EnableGlobalMethodSecurity (prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	public void configure (WebSecurity web) {
		web.ignoring().antMatchers(HttpMethod.POST, ACCOUNT);
		
	}

	@Override
	protected void configure (HttpSecurity http) throws Exception {
	
		http.httpBasic();
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);// to ask token every time;
		//http.authorizeRequests().anyRequest().authenticated();
	http.authorizeRequests().antMatchers(FORUM_POST+"/**").permitAll();
	http.authorizeRequests().antMatchers(HttpMethod.GET, ACCOUNT, FORUM_POST+"/*").authenticated();
	http.authorizeRequests().antMatchers(HttpMethod.POST, FORUM_POST).authenticated();
	http.authorizeRequests().antMatchers(HttpMethod.PUT, FORUM_POST+"/*/like").authenticated();
	http.authorizeRequests().antMatchers(HttpMethod.PUT, FORUM_POST+"/*/comment").authenticated();
	http.authorizeRequests().antMatchers(HttpMethod.PUT, FORUM_POST+"/*/comment").authenticated();
	http.authorizeRequests().antMatchers(ACCOUNT_ROLE+"/**").hasAnyRole("ADMIN");

	}
	
}
//		String ACCOUNT = "/account";// PUT-owner GET-authenticated
//		String ACCOUNT_ID = "/account/{id}"; // delete - owner, admin, moderator
//		String ACCOUNT_ROLE = "/account/role/{id}/{role}";// delete put - admin
//		String ACCOUNT_PASSWORD = "/account/password"; //put  owner
//		String FORUM_POST = "/forum/post"; //post - auth, put - owner 
//		String FORUM_POST_ID = "/forum/post/{id}"; // get - auth, del-owner
//		String FORUM_POST_LIKE = "/forum/post/{id}/like"; // put - auth
//		String FORUM_POST_COMMENT = "/forum/post/{id}/comment"; // put - auth
//		String FORUM_POSTS = "/forum/posts"; 
//}
