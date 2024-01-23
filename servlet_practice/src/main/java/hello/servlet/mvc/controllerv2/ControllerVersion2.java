package hello.servlet.mvc.controllerv2;

import hello.servlet.mvc.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerVersion2 {
    MyView process(HttpServletRequest req, HttpServletResponse res) throws
            ServletException, IOException;
}
