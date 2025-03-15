package filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    
    private static final String[] PUBLIC_PATHS = {"/login", "/css/"};

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
        throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) req;
        String path = request.getRequestURI().substring(request.getContextPath().length());
        
        if(isPublicPath(path)) {
            chain.doFilter(req, res);
            return;
        }
        
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("user") == null) {
            req.getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(req, res);
        } else {
            chain.doFilter(req, res);
        }
    }

    private boolean isPublicPath(String path) {
        for(String publicPath : PUBLIC_PATHS) {
            if(path.startsWith(publicPath)) return true;
        }
        return false;
    }
}