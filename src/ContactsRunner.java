public class ContactsRunner {
    public static void main(String[] args) {


        MainMenu runner = new MainMenu();
        runner.userMenu();
        Methods test = new Methods();

        test.loadContacts();

    }
}
