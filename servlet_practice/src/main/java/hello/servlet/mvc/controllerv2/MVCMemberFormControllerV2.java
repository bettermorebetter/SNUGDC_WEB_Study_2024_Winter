package hello.servlet.mvc.controllerv2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.mvc.MyView;
import hello.servlet.mvc.controller.ControllerVersion1;
import hello.servlet.mvc.view.MVCMemberFormView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MVCMemberFormControllerV2 implements ControllerVersion2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new MyView("/WEB-INF/views/members/new-form.jsp");
    }
}
