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

public class RepositoryTest {
    private MemberRepository memberRepository;

    public RepositoryTest() {
        memberRepository = new MemberRepository();
    }

    @Test
    public void testCase1() {
        assertEquals(0, memberRepository.getAllMembers().size());
        try {
            memberRepository.addMember(new Member("Pop A", "1"));
        } catch (InvalidNameException e) {
            e.printStackTrace();
        } catch (InvalidIdException e) {
            e.printStackTrace();
        }
        assertEquals(1, memberRepository.getAllMembers().size());
    }

    @Test(expected = InvalidIdException.class)
    public void testCase2() throws InvalidIdException, Exception {
        memberRepository.addMember(new Member("Pop Ioan", "0"));
    }

    @Test(expected = InvalidIdException.class)
    public void testCase3() throws InvalidIdException, Exception {
        memberRepository.addMember(new Member("Pop Alin", Integer.toString(Integer.MAX_VALUE + 1)));
    }

    @Test(expected = InvalidNameException.class)
    public void testCase4() throws InvalidNameException, Exception {
        memberRepository.addMember(new Member("Test", "10"));
    }

    @Test
    public void testCase5() {
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

    @Test
    public void testCase6() {
        memberRepository = new MemberRepository();
        assertEquals(0, memberRepository.getAllMembers().size());
        try {
            memberRepository.addMember(new Member("Pop Vasile", "2"));
        } catch (InvalidNameException e) {
            e.printStackTrace();
        } catch (InvalidIdException e) {
            e.printStackTrace();
        }
        assertEquals(1, memberRepository.getAllMembers().size());
    }

    @Test
    public void testCase7() {
        memberRepository = new MemberRepository();
        assertEquals(0, memberRepository.getAllMembers().size());
        try {
            memberRepository.addMember(new Member("Pop Alin", Integer.toString(Integer.MAX_VALUE - 1)));
        } catch (InvalidNameException e) {
            e.printStackTrace();
        } catch (InvalidIdException e) {
            e.printStackTrace();
        }
        assertEquals(1, memberRepository.getAllMembers().size());
    }

    @Test
    public void testCase8() {
        memberRepository = new MemberRepository();
        assertEquals(0, memberRepository.getAllMembers().size());
        try {
            memberRepository.addMember(new Member("Pop Alin", "1"));
            memberRepository.addMember(new Member("Pop Andrei", "1"));
        } catch (InvalidNameException e) {
            e.printStackTrace();
        } catch (InvalidIdException e) {
            e.printStackTrace();
        }
        assertEquals(1, memberRepository.getAllMembers().size());
    }
}
