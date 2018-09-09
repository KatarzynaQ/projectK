package projectQ;

import projectQ.service.Model;

public class Main {
    public static void main(String[] args) {


UserInterface ui=new UserInterface();
Model model=ui.modelBuilder();
ui.choseMethod();

    }
}
