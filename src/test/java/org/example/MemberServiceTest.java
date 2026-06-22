package org.example;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
public class MemberServiceTest {
    @Test
    void testSearchMemberById() throws MemberNotFoundException {
        ArrayList<Member> members = new ArrayList<>();
        members.add(new Member(1, "Hannah"));
        Member member = MemberService.searchMemberbyId(members, 1);
        assertNotNull(member);
        assertEquals("Hannah", member.getName());
    }
    @Test
    void testMemberNotFound() {
        ArrayList<Member> members = new ArrayList<>();
        assertThrows(MemberNotFoundException.class, () -> MemberService.searchMemberbyId(members,1));
    }
    @Test
    void testDisplayMembers() {
        ArrayList<Member> members = new ArrayList<>();
        members.add(new Member(1,"Hannah"));
        assertDoesNotThrow(() -> MemberService.displayMembers(members));
    }
}
