package hello.servlet.mvc.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServlet1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerVersion1 extends HttpServlet {
    private Map<String, ControllerVersion1> controllerMap = new HashMap<>();

    public FrontControllerVersion1(){
        controllerMap.put("/front-controller/v1/members/new-form", new MVCMemberFormController());
        controllerMap.put("/front-controller/v1/members/save", new MVCMemberSaveController());
        controllerMap.put("/front-controller/v1/members", new MVCMemberListController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String requestURI = request.getRequestURI();
        ControllerVersion1 controller = controllerMap.get(requestURI);

        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controller.process(request, response);
    }
}
