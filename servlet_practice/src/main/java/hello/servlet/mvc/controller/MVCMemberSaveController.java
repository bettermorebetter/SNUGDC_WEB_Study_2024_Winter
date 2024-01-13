package hello.servlet.mvc.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.mvc.model.MVCMemberSaveModel;
import hello.servlet.mvc.view.MVCMemberSaveView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(name="mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MVCMemberSaveController extends HttpServlet {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MVCMemberSaveModel mvcMemberSaveModel = new MVCMemberSaveModel();
        MVCMemberSaveView mvcMemberSaveView = new MVCMemberSaveView();

        System.out.println("MemberSaveServlet.service");
        String username = request.getParameter("username"); // 파라미터를 꺼내서
        int age = Integer.parseInt(request.getParameter("age")); // 파라미터를 꺼내서
        Member member = new Member(username, age);
        memberRepository.save(member); // 저장하고

        // 이를 model에 저장한다.
        mvcMemberSaveModel.setMember(member);

        // 그리고 페이지를 보여준다.
        mvcMemberSaveView.View(request, response, mvcMemberSaveModel);
    }
}
