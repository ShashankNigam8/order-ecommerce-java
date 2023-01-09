package com.order.ecommerce.filter;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorizationHeader = req.getHeader("Authorization");

        if(authorizationHeader == null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You are not authorized");

        }

        chain.doFilter(request, response);
    }
}
