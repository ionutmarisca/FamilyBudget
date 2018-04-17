package FamilyBudget;

import FamilyBudget.exceptions.InvalidBudgetException;
import FamilyBudget.exceptions.InvalidIdException;
import FamilyBudget.exceptions.InvalidNameException;
import FamilyBudget.exceptions.InvalidTypeException;
import FamilyBudget.model.Entry;
import FamilyBudget.model.Member;
import FamilyBudget.repository.MemberRepository;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BigBangTest {
    private MemberRepository memberRepository;

    public BigBangTest() {
        memberRepository = new MemberRepository();
    }

    @Test
    public void testRequirementA() {
        memberRepository = new MemberRepository();
        assertEquals(0, memberRepository.getAllMembers().size());
        try {
            memberRepository.addMember(new Member("Pop An", Integer.toString(Integer.MAX_VALUE)));
        } catch (InvalidNameException e) {
            e.printStackTrace();
        } catch (InvalidIdException e) {
            e.printStackTrace();
        }
        assertEquals(1, memberRepository.getAllMembers().size());
    }

    @Test()
    public void testRequirementB() throws InvalidBudgetException, InvalidTypeException {
        memberRepository.addEntry(new Entry("income", 400, 20));
        assertEquals(1, memberRepository.getAllEntries().size());
    }

    @Test()
    public void testRequirementC() {
        memberRepository = new MemberRepository();
        assertEquals(0, memberRepository.getAllMembers().size());
    }

    @Test()
    public void testBigBang() throws InvalidTypeException, InvalidBudgetException {
        testRequirementA();
        testRequirementB();
        testRequirementC();
    }
}
