package br.com.SistemaBancario.utils.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//Coloca as page aqui
@WebFilter("")
public class FiltroRequisicaoGerente implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            HttpSession httpSession = httpServletRequest.getSession(true);


            if(httpSession.getAttribute("") == null) {
                //COLOQUE A PAGINA AQUI
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "");
                return;
            }

            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {

        }


}

