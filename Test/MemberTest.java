import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    @Test
    void testGetID(){
        LoanPolicy aalborg = new AalborgLoanPolicy();
        Member member = new Member("Daniel", 1234);

        int memberId = member.getID();

        assertEquals(1234, memberId);
    }

}