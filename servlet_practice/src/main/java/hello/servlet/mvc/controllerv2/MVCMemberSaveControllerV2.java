package hello.servlet.mvc.controllerv2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.mvc.MyView;
import hello.servlet.mvc.model.MVCMemberSaveModel;
import hello.servlet.mvc.view.MVCMemberSaveView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MVCMemberSaveControllerV2 implements ControllerVersion2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MVCMemberSaveModel mvcMemberSaveModel = new MVCMemberSaveModel();

        String username = request.getParameter("username"); // 파라미터를 꺼내서
        int age = Integer.parseInt(request.getParameter("age")); // 파라미터를 꺼내서
        Member member = new Member(username, age);
        memberRepository.save(member); // 저장하고

        // 이를 model에 저장한다.
        mvcMemberSaveModel.setMember(member);

        // 그리고 페이지를 보여준다.
        return new MyView("/WEB-INF/views/members/save.jsp");
    }
}
