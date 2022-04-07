package takeout.mainweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import takeout.mainweb.Service.MyUserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
//        http
//                .authorizeRequests()
//                //访问"/"和"/home"路径的请求都允许
//                .antMatchers("/", "/index","/login","/register",
//                        "/v2/api-docs", "/configuration/ui", "/swagger-resources",
//                        "/configuration/security", "/swagger-ui.html", "/webjars/**",
//                        "/swagger-resources/configuration/ui","/swagge‌​r-ui.html")
//                .permitAll()
//                //而其他的请求都需要认证
//                .anyRequest()
//                .authenticated()
//                .and()
//                //修改Spring Security默认的登陆界面
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

    }

    @Bean
    public UserDetailsService myUserService(){
        return new MyUserDetailsService();
    }
}
