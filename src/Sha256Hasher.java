import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Hasher {

    public static String hashString(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            // Handle the case where SHA-256 algorithm is not available
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String textToHash = "glorp";
        String sha256Hash = hashString(textToHash);

        if (sha256Hash != null) {
            System.out.println("Original String: " + textToHash);
            System.out.println("SHA-256 Hash: " + sha256Hash);
        }
    }
}