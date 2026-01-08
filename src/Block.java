import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
    boolean genesis;
    String hash = "";
    String previousHash = "";


    Block(Message msg, String previousH ) {

        previousHash = previousH;


        hash = (previousHash) + " : " + msg.getMessage()[1] + " : " + msg.getMessage()[0] + " : " + Sha256Hasher.hashString(Sha256Hasher.hashString(previousHash) + " : " + msg.getMessage()[1] + " : " + msg.getMessage()[0]);
        if (previousH.equals("0000000000")) {
            genesis = true;
            hash = "0000000000" + " : " + msg.getMessage()[1] +  " : " + msg.getMessage()[0] + " : " + Sha256Hasher.hashString("0000000000" + " : " + msg.getMessage()[1] +  " : " + msg.getMessage()[0]);
        }



    }

    public String getHash() {
        return hash;
    }

    public String getTrueHash(){
        String[] temp = hash.split(":");
        return temp[5];
    }

}
