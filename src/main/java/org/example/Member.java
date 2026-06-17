package org.example;

public class Member {private int memberId;
    private String name;
    Member(int memberId,String name){
        this.memberId=memberId;
        this.name=name;
    }
    public int getMemberId(){
        return memberId;
    }
    public String getName(){
        return name;
    }

}
