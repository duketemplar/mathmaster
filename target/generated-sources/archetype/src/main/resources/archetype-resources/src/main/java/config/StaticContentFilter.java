#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

/**
 * Created by lordofeverything on 29/12/14.
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Filter class which reroutes URI's referring to static data to
 * the default servlet. The static data is in fact the Swagger-UI
 * files which have been placed in the webapp directory. URI's
 * ending with '.html', '.js', '.css' etc will be sent to the
 * default servlet.
 *
 */
@WebFilter("/*")
public class StaticContentFilter implements Filter {

    private RequestDispatcher defaultRequestDispatcher;

    @Override
    public void destroy() {
        // do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) request;
        String requestURI = rq.getRequestURI();

        if (requestURI.endsWith(".html") || requestURI.endsWith(".png")
                || requestURI.endsWith(".js") || requestURI.endsWith(".css")
                || requestURI.endsWith(".gif")) {
            defaultRequestDispatcher.forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.defaultRequestDispatcher = filterConfig.getServletContext()
                .getNamedDispatcher("default");
    }

}