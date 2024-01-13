package hello.servlet.mvc.model;

import hello.servlet.domain.member.Member;

public class MVCMemberSaveModel {
    private Member member;

    public Member getMember(){
        return member;
    }

    public void setMember(Member member){
        this.member = member;
    }
}
