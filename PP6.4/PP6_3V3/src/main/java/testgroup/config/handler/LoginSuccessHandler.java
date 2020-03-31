package testgroup.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        Set<String> dostup = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

//        Set<GrantedAuthority> roles1 = (Set<GrantedAuthority>) authentication.getAuthorities();
//        System.out.println(roles1);
//

        if (dostup.contains("ADMIN")) {
            httpServletResponse.sendRedirect("/admin");

        }else if (dostup.contains("USER")) {
            httpServletResponse.sendRedirect("/welcome");
        }else {
            httpServletResponse.sendRedirect("/hello");
        }


    }
}