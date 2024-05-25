package chainOfResponsibility;

public class Main {

    public static void main(String[] args) {

        Validator formatValidator = new FormatValidator();
        Validator lengthValidator = new LengthValidator();
        Validator unicityValidator = new UnicityValidator();

        formatValidator.setNext(lengthValidator);
        lengthValidator.setNext(unicityValidator);

        String[] dataTest = {"SAf1nette76%?", "incorrecte", "201116", "C@ffee2001?", "john"};

        for (String password : dataTest) {

            System.out.println("_____ " + password + " _____");

            if (formatValidator.check(password)) {
                System.out.println("\n\u263A La donnée est tout simplement OK !!! \n");
            } else {
                System.out.println("\n\u2639 La donnée n'est pas OK.\n");
            }
        }
    }
}
