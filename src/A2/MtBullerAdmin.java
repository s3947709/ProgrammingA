package A2;

public class MtBullerAdmin {
    public static void main(String[] args) {
        try {
            ResortGUI gui = new ResortGUI();
            gui.setVisible(true);
        } catch (Exception e) {
            System.err.println("An error occurred while starting the application: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
