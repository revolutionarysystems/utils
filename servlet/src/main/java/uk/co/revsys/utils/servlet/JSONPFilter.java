package uk.co.revsys.utils.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JSONPFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        Map<String, String[]> params = httpRequest.getParameterMap();

        if (params.containsKey("callback")) {

            OutputStream out = httpResponse.getOutputStream();

            GenericResponseWrapper wrapper = new GenericResponseWrapper(httpResponse);

            chain.doFilter(request, wrapper);

            out.write(new String(params.get("callback")[0] + "(").getBytes());
            out.write(wrapper.getData());
            out.write(");".getBytes());

            wrapper.setContentType("text/javascript;charset=UTF-8");

            out.close();
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
