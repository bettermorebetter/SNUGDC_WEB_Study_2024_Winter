package hello.servlet.mvc.controllerv2;

import hello.servlet.mvc.MyView;
import hello.servlet.mvc.controller.ControllerVersion1;
import hello.servlet.mvc.controller.MVCMemberFormController;
import hello.servlet.mvc.controller.MVCMemberListController;
import hello.servlet.mvc.controller.MVCMemberSaveController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerV2 extends HttpServlet {
    private Map<String, ControllerVersion2> controllerMap = new HashMap<>();

    public FrontControllerV2(){
        controllerMap.put("/front-controller/v2/members/new-form", new MVCMemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MVCMemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MVCMemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerVersion2 controller = controllerMap.get(requestURI);

        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView view = controller.process(request, response);
        view.render(request, response);
    }
}
