package br.com.senac.siscomee.auth.jwt;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class JwtAuthFilter implements Filter
{

    @Override
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String authorization = servletRequest.getHeader("Authorization");

        if (authorization != null)
        {
        	String name = SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().getName() != null ? SecurityContextHolder.getContext().getAuthentication().getName() : "";
            JwtAuthToken token = new JwtAuthToken(authorization.replaceAll("Bearer ", ""), name);
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy()
    {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }
}
