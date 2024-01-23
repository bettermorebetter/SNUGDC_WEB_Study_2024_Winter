package hello.servlet.mvc.controllerv2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.mvc.MyView;
import hello.servlet.mvc.model.MVCMemberListModel;
import hello.servlet.mvc.view.MVCMemberListView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MVCMemberListControllerV2 implements ControllerVersion2{
    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MVCMemberListModel mvcMemberListModel = new MVCMemberListModel();
        MVCMemberListView mvcMemberListView = new MVCMemberListView();

        // 사용자의 요청을 처리한다.
        List<Member> members = memberRepository.findAll();

        // Model에 데이터를 저장하고
        mvcMemberListModel.setMembers(members);

        // View 함수를 실행해 페이지를 보여준다.
        return new MyView("/WEB-INF/views/members.jsp");
    }
}
