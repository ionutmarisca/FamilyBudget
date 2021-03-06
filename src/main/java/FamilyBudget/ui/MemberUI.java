package FamilyBudget.ui;

import FamilyBudget.controller.MemberController;
import FamilyBudget.exceptions.InvalidBudgetException;
import FamilyBudget.exceptions.InvalidIdException;
import FamilyBudget.exceptions.InvalidNameException;
import FamilyBudget.exceptions.InvalidTypeException;
import FamilyBudget.model.Entry;
import FamilyBudget.model.Member;

import java.util.List;
import java.util.Scanner;

public class MemberUI {
    public MemberController ctrl;
    Scanner in;

    public MemberUI(MemberController ctrl) {
        this.ctrl = ctrl;
        this.in = new Scanner(System.in);
    }

    public MemberController getCtrl() {
        return this.ctrl;
    }

    public void setCtrl(MemberController newCtrl) {
        this.ctrl = newCtrl;
    }

    public Scanner getIn() {
        return this.in;
    }

    public void setIn(Scanner newIn) {
        this.in = newIn;
    }

    public void printMenu() {
        String menu;
        menu = "Budget Admin Menu: \n";
        menu += "\t 1 - to add a new member; \n";
        menu += "\t 2 - to add a new income/cost; \n";
        menu += "\t 3 - to list the current income/cost; \n";
        menu += "\t 0 - exit \n";

        System.out.println(menu);
    }


    public void Run() {
        printMenu();


        int cmd = in.nextInt();
        in.nextLine();

        while (cmd != 0) {
            if (cmd == 1) {
                System.out.println("Enter name:");
                String name = in.nextLine();
                System.out.println("Enter id:");
                String id = in.nextLine();
                Member aMemebr = new Member(name, id);
                try {
                    ctrl.addMember(aMemebr);
                } catch (InvalidNameException e) {
                    System.out.println(e.getMessage() + " Please try again.");
                } catch (InvalidIdException e) {
                    System.out.println(e.getMessage() + " Please try again.");
                }

            }
            if (cmd == 2) {


                System.out.println("Enter type:");
                String type = in.nextLine();

                System.out.println("Enter the value:");
                String valueS = in.nextLine();
                int valueInt = Integer.parseInt(valueS);

                System.out.println("Enter the id of the member:");
                String idS = in.nextLine();
                int idInt = Integer.parseInt(idS);

                Entry e = new Entry(type, valueInt, idInt);
                try {
                    ctrl.addEntry(e);
                } catch (InvalidBudgetException e1) {
                    System.out.println(e1.getMessage() + " Please try again.");
                } catch (InvalidTypeException e1) {
                    System.out.println(e1.getMessage() + " Please try again.");
                }

            }
            if (cmd == 3) {
                System.out.println("list the current budget :");


                List<Entry> allE = ctrl.allEntries();
                for (int j = 0; j < allE.size(); j++)
                    System.out.println(allE.get(j).toString());
            }

            printMenu();
            cmd = in.nextInt();
            in.nextLine();
        }
    }
}
