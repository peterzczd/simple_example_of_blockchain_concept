package easy.blockchain;

import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class HashGenerator {
    public static String generateHash(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            String encoded = Base64.getEncoder().encodeToString(hash);
            return encoded;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HashGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
