package FamilyBudget.controller;

import FamilyBudget.exceptions.InvalidBudgetException;
import FamilyBudget.exceptions.InvalidIdException;
import FamilyBudget.exceptions.InvalidNameException;
import FamilyBudget.exceptions.InvalidTypeException;
import FamilyBudget.model.Entry;
import FamilyBudget.model.Member;
import FamilyBudget.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

public class MemberController {

    private MemberRepository mr;

    public MemberController(MemberRepository newMr) {
        this.mr = newMr;
    }

    public void addMember(Member aMemebr) throws InvalidNameException, InvalidIdException {
        mr.addMember(aMemebr);
    }

    public void addEntry(Entry oneEntry) throws InvalidBudgetException, InvalidTypeException {
        mr.addEntry(oneEntry);
    }

    public List<Entry> allEntries() {
        List<Entry> allE = new ArrayList<Entry>();
        allE = this.mr.getAllEntries();
        return allE;
    }
}
