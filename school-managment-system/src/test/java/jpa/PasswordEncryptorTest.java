package jpa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordEncryptorTest {

    @Test
    void testPasswordEncryptor() {
        // given
        PasswordEncryptor encryptor = new PasswordEncryptor();
        String password = "Qwerty123";
        // when
        String encrypted = encryptor.encrypt(password);
        // then
        Assertions.assertTrue(encryptor.validate(password, encrypted));
    }

}
