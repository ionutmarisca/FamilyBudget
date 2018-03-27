package FamilyBudget.repository;

import FamilyBudget.exceptions.InvalidBudgetException;
import FamilyBudget.exceptions.InvalidNameException;
import FamilyBudget.exceptions.InvalidTypeException;
import FamilyBudget.model.Entry;
import FamilyBudget.model.Member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class MemberRepository {
    private final static String filenameMember = "membersF.txt";
    private final static String filenameBudget = "budgetF.txt";
    private List<Member> members = new ArrayList<Member>();
    private List<Entry> entries = new ArrayList<Entry>();

    @SuppressWarnings("resource")
    public MemberRepository() {

        try {
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            String currentLine = null;

            fileReader = new FileReader(filenameMember);
            bufferedReader = new BufferedReader(fileReader);

            while ((currentLine = bufferedReader.readLine()) != null) {
                String line[] = currentLine.split(";");
                Member m = new Member(line[0], line[1]);
                this.members.add(m);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        try {
            FileReader fileReaderEntry = null;
            BufferedReader bufferedReaderEntry = null;
            String currentLineEntry = null;

            fileReaderEntry = new FileReader(filenameMember);
            bufferedReaderEntry = new BufferedReader(fileReaderEntry);

            while ((currentLineEntry = bufferedReaderEntry.readLine()) != null) {
                String line[] = currentLineEntry.split(";");
                int valueEntry = Integer.parseInt(line[1]);
                int idEntryMember = Integer.parseInt(line[2]);
                Entry e = new Entry(line[0], valueEntry, idEntryMember);
                this.entries.add(e);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void addMember(Member m) throws InvalidNameException {
        if (m.getName().length() <= 5) {
            throw new InvalidNameException("Length of the name should be greater than 5.");
        }
        members.add(m);
    }

    public void addEntry(Entry e) throws InvalidTypeException, InvalidBudgetException {
        if (!(e.getType().equalsIgnoreCase("income") || e.getType().equalsIgnoreCase("cost"))) {
            throw new InvalidTypeException("Type value can only be 'income' or 'cost'.");
        }
        if (e.getValue() <= 0) {
            throw new InvalidBudgetException("Value can only be a positive integer, greater than 0.");
        }
        entries.add(e);
    }

    public List<Entry> getAllEntries() {

        return entries;
    }
}