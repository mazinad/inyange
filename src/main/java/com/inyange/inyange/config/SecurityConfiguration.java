package com.inyange.inyange.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
   private UserPrincipalDetailsService userPrincipalDetailsService;
//    @Autowired
//    private LoginSuccessHandler loginSuccessHandler;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userPrincipalDetailsService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(
                        "/registration**",
                        "/js/**",
                        "/css/**",
                        "/forgot-password",
                        "/reset-password",
                        "/static/img/**").permitAll()
                .antMatchers("/").authenticated()
                .antMatchers("/api/school/addNewSchool").hasAnyRole("ADMIN")
                .antMatchers("/api/school/all").hasAnyRole("ADMIN","INYANGE")
                .antMatchers("/api/distribution/addNewDistribution").hasAnyRole("USER")
                .antMatchers("/api/distribution/all").hasAnyRole("USER","ADMIN","INYANGE")
                .antMatchers("/api/school/updateSchoolById/**").hasAnyRole("ADMIN")
                .antMatchers("/api/school/deleteSchoolById/**").hasAnyRole("ADMIN")
                .antMatchers("/registration/api/addDistributor/**").hasAnyRole("INYANGE")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/registration/default")
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }

}
