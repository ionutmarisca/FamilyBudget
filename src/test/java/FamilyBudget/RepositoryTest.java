package FamilyBudget;

import FamilyBudget.exceptions.InvalidBudgetException;
import FamilyBudget.exceptions.InvalidNameException;
import FamilyBudget.exceptions.InvalidTypeException;
import FamilyBudget.model.Entry;
import FamilyBudget.model.Member;
import FamilyBudget.repository.MemberRepository;
import org.junit.Test;

public class RepositoryTest {
    private final MemberRepository memberRepository;

    public RepositoryTest() {
        memberRepository = new MemberRepository();
    }

    @Test(expected = InvalidNameException.class)
    public void testAddName() throws NumberFormatException, Exception {
        memberRepository.addMember(new Member("Test", "20"));
    }

    @Test(expected = InvalidBudgetException.class)
    public void testAddValues() throws NumberFormatException, Exception {
        memberRepository.addEntry(new Entry("income", -20, 20));
    }

    @Test(expected = InvalidTypeException.class)
    public void testAddValuesInvalidType() throws NumberFormatException, Exception {
        memberRepository.addEntry(new Entry("test", 20, 20));
    }
}
