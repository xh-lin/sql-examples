package jpa;

// I'm not actually going to implement this
public class PasswordEncryptor {

    public String encrypt(String password) {
        return password;
    }

    public boolean validate(String password, String encrypted) {
        return password.equals(encrypted);
    }

}
