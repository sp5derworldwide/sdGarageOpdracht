package nl.bd.sdbackendeindopdracht.security.config;


import lombok.AllArgsConstructor;
import nl.bd.sdbackendeindopdracht.security.enums.Roles;
import nl.bd.sdbackendeindopdracht.services.AppUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/API/v1/*/admin/**").hasAnyAuthority(Roles.ADMIN.name())
                .antMatchers("API/v1/*/mechanic/").hasAnyAuthority(Roles.MECHANIC.name())
                .antMatchers("API/v1/**").hasAnyAuthority(Roles.BACKOFFICEWORKER.name(), Roles.ADMIN.name(),
                        Roles.REGISTERWORKER.name(), Roles.MECHANIC.name(), Roles.APPUSER.name())
                .anyRequest()
                .authenticated().and()
                .formLogin()
                .and().httpBasic();
        //todo achter formLogin nog .disable -deze disable moet je weghalen als je users wilt toevoegen.


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }
}
