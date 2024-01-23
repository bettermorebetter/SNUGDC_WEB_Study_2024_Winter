package hello.servlet.mvc.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerVersion1 {
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
