package cybersoft.java18.crm.filter;

import cybersoft.java18.crm.utils.UrlUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = UrlUtils.ALL)
public class RoleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Headers", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS,HEAD,PUT,DELETE,POST");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json"); // set đầu ra cho response là json
        chain.doFilter(request, response);
    }
}
