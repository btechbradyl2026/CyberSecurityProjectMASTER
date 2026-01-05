import java.util.Random;

public class Generals {

    public Generals() {
        boolean trust = true;

        Random random = new Random();
        int min = 1;
        int max = 1000;
        int randomNumber = random.nextInt(max - min + 1) + min;
        if (isPrime(randomNumber)) {
            trust = false;
        }
    }

    public Message getMessage() {
        String[] rands = {
                "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "ice", "jungle", "kite", "lemon", "mango", "nectarine", "orange", "peach", "quartz", "river", "stone", "tree", "umbrella", "violet", "water", "xylophone", "yarn", "zebra", "cloud", "dream", "echo", "flame", "glow", "horizon", "island", "journey", "king", "light", "mountain", "night", "ocean", "path", "quiet", "rain", "shadow", "thunder", "unity", "valley", "wind", "year", "zenith", "forest", "garden", "harbor", "inspire", "joy", "kindness", "laughter", "memory", "nature", "open", "peace", "quest", "rise", "sun", "time", "under", "vision", "wonder", "youth", "zone", "adventure", "balance", "courage", "destiny", "energy", "freedom", "growth", "hope", "imagine", "justice", "knowledge", "love", "magic", "novel", "optimism", "power", "quality", "respect", "strength", "trust", "unity", "victory", "wisdom", "xenon", "yearning", "zeal"
        };
        Random random = new Random();
        int min = 0;
        int max = rands.length - 1;
        int randomNumber = random.nextInt(max - min + 1) + min;
        Message msg = new Message(rands[randomNumber]);
        return msg;
    }

    public Block proposeBlock() {
        Block minecraft;
        minecraft = new Block(getMessage(), Chain.theBlockchain.getLast().hash);
        return minecraft;
    }



    public static boolean isPrime(int n) {
        // Numbers less than or equal to 1 are not prime
        if (n <= 1) {
            return false;
        }

        // Check for factors from 2 up to the square root of n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                // If n is divisible by any number other than 1 and itself, it's not prime
                return false;
            }
        }

        // If no divisors were found, the number is prime
        return true;
    }

}
