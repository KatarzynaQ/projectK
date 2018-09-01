package projectQ;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


UserInterface ui=new UserInterface();
Model model=ui.modelBuilder();
ui.choseMethod();

    }
}
