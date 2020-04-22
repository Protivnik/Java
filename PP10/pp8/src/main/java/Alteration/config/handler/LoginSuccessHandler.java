package Alteration.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        Set<String> dostup = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (dostup.contains("ADMIN")) {
            httpServletResponse.sendRedirect("/admin");

        } else if (dostup.contains("USER")) {
            httpServletResponse.sendRedirect("/welcome");
        } else {
            httpServletResponse.sendRedirect("/hello");
        }


    }
}
