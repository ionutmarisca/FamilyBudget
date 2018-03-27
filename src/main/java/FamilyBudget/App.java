package FamilyBudget;

import FamilyBudget.controller.MemberController;
import FamilyBudget.repository.MemberRepository;
import FamilyBudget.ui.MemberUI;

public class App {
    public static void main(String[] args) {
        MemberRepository repo = new MemberRepository();

        MemberController ctrl = new MemberController(repo);

        MemberUI console = new MemberUI(ctrl);
        console.Run();
    }
}

