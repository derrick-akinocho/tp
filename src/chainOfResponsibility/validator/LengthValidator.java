package chainOfResponsibility;

public class LengthValidator extends Validator {

    public boolean check(String data) {

        boolean isValid = true;

        if (data.length() < 8 || data.length() > 20) {

            System.out.println("\u2716 La donnée doit comporter minimum 8 caractères et au maximum 20 caractères.");
            isValid = false;
        } else {

            System.out.println("\u2714 La taille de la donnée est valide.");
        }

        if (nextValidator != null) {
            return nextValidator.check(data) && isValid;
        }
        return isValid;
    }
}