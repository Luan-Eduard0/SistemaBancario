package br.com.SistemaBancario.utils.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("")
public  class FiltroRequisicaoCliente implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession httpSession = httpServletRequest.getSession(true);


        if(httpSession.getAttribute("") == null) {

            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}