package hello.servlet.mvc.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.mvc.model.MVCMemberListModel;
import hello.servlet.mvc.view.MVCMemberListView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="mvcMemberListServlet", urlPatterns = "/servlet-mvc/members")
public class MVCMemberListController extends HttpServlet {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MVCMemberListModel mvcMemberListModel = new MVCMemberListModel();
        MVCMemberListView mvcMemberListView = new MVCMemberListView();

        // 사용자의 요청을 처리한다.
        List<Member> members = memberRepository.findAll();

        // Model에 데이터를 저장하고
        mvcMemberListModel.setMembers(members);

        // View 함수를 실행해 페이지를 보여준다.
        mvcMemberListView.View(request, response, mvcMemberListModel);
    }
}
