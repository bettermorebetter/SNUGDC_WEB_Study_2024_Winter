package hello.servlet.mvc.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.mvc.view.MVCMemberFormView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MVCMemberFormController extends HttpServlet {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MVCMemberFormView mvcMemberFormView = new MVCMemberFormView();

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        List<Member> members = memberRepository.findAll();

        mvcMemberFormView.View(request, response);
    }
}
