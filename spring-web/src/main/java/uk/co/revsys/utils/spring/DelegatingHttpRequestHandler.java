package uk.co.revsys.utils.spring;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.HttpRequestHandler;

public abstract class DelegatingHttpRequestHandler implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equalsIgnoreCase("GET")) {
            doGet(req, resp);
        }else if(req.getMethod().equalsIgnoreCase("POST")){
            doPost(req, resp);
        }else{
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

}
