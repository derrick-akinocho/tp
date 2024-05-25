package chainOfResponsibility;

public class UnicityValidator extends Validator {

    private static final String[] db = {"J@hnW1ck?", "Panam@r3!", "2020birth@", "C@ffee2001?"};

    public boolean check(String data) {

        boolean isValid = true;

        for (String existingPassword : db) {
            if (existingPassword.equals(data)) {
                System.out.println("\u2716 La donnée existe déjà en base de données.");
                isValid = false;
                break; // On arrête la boucle dès qu'on trouve une correspondance.
            }
        }

        if (isValid) {

            System.out.println("\u2714 La donnée n'existe pas dans la base de données.");
        }

        if (nextValidator != null) {
            return nextValidator.check(data) && isValid;
        }
        return isValid;
    }
}