package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MemberTest {
    @Test
    void testMemberConstructor() {
        Member member = new Member(1, "Hannah");
        assertEquals(1, member.getMemberId());
        assertEquals("Hannah", member.getName());
    }
}
