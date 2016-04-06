package oose.dea.guice;

import com.google.inject.servlet.GuiceFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class GuiceWebFilter extends GuiceFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if(request != null) {
            HttpSession session = request.getSession();
            if(session != null) {
                String owner = (String)session.getValue("owner");

                //Don't do this session check for rest calls.
                if(!request.getRequestURI().matches("/rest")) {

                    //Do session check:
                    if (!request.getRequestURI().equals("/index.jsp") && !request.getRequestURI().equals("/") && owner == null) {
                        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
                        httpResponse.sendRedirect("/");
                    }

                }

            }
        }

        super.doFilter(servletRequest, servletResponse, filterChain);
    }
}
