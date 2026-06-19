package org.example;
import java.util.ArrayList;
public class MemberService {
    public static void displayMembers(ArrayList<Member> members){
        System.out.println("\nMember Details\n");
        System.out.printf("%-5s %-20s%n", "Member Id", "Name");
        for(Member member:members) {
            System.out.printf("%-5d %-20s%n", member.getMemberId(), member.getName());
        }
    }
public static Member searchMemberbyId(ArrayList<Member>members,int id) throws MemberNotFoundException{
    for(Member member:members){
        if(member.getMemberId()==id){
            return member;
        }
    }
    throw new MemberNotFoundException("Member with Id" +id+ "not found");
}
}
