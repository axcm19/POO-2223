import SubUI.MenuUI;


public class Main {
    public static void main(String[] args) {
        try {
            new MenuUI().run();
        }
        catch (Exception e) {
            System.out.println("Não foi possível arrancar: "+e.getMessage());
        }
    }
}




