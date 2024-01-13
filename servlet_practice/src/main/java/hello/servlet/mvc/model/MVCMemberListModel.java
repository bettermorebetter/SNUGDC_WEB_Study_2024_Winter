package hello.servlet.mvc.model;

import hello.servlet.domain.member.Member;

import java.util.List;

public class MVCMemberListModel {
    private List<Member> members;

    public List<Member> getMembers(){
        return members;
    }

    public void setMembers(List<Member> members){
        this.members = members;
    }
}
