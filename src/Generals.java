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
                "Alice to Bob [$50.00]", "Charlie to Dana [$120.00]", "Edward to Alice [$200.00]", "Bob to Charlie [$35.50]", "Dana to Edward [$75.25]", "Frank to Sarah [$100.00]", "James to Robert [$1500.00]", "Linda to Alex [$50.00]", "Alex to George [$30.00]", "Sarah to James [$25.00]", "Henry to Victor [$600.00]", "Bob to Alice [$15.00]", "Charlie to Bob [$10.00]", "Dana to Sarah [$45.00]", "James to Thomas [$85.40]", "Alice to Maria [$500.00]", "Edward to Bob [$12.00]", "Sarah to Dana [$22.10]", "Alex to James [$60.00]", "Oscar to Alice [$1000.00]", "Rachel to Steven [$45.00]", "Kevin to Laura [$90.00]", "Megan to Chris [$115.00]", "Brian to Jessica [$300.00]", "Mark to Sophia [$20.00]", "Paul to Karen [$65.00]", "Gary to Helen [$12.50]", "Nancy to Jeff [$210.00]", "Larry to Ruth [$80.00]", "Anna to Mike [$55.00]", "Diana to Eric [$140.00]", "Justin to Chloe [$33.00]", "Ryan to Amber [$75.00]", "Scott to Lisa [$95.00]", "Kyle to Maria [$110.00]", "Joe to Ben [$25.00]", "Tina to Rose [$40.00]", "Peter to Sam [$18.00]", "Emily to Jack [$250.00]", "Logan to Oliver [$15.00]", "Emma to Noah [$300.00]", "Lucas to Mia [$70.00]", "Ethan to Ava [$85.00]", "Mason to Sofia [$125.00]", "Jacob to Ella [$40.00]", "Logan to Avery [$60.00]", "Levi to Scarlett [$110.00]", "Daniel to Victoria [$200.00]", "Jack to Grace [$55.00]", "Owen to Zoey [$90.00]"        };
        Random random = new Random();
        int min = 0;
        int max = rands.length - 1;
        int randomNumber = random.nextInt(max - min + 1) + min;
        Message msg = new Message(rands[randomNumber]);
        return msg;
    }

    public Block proposeBlock() {
        Block minecraft;
        minecraft = new Block(getMessage(), Chain.theBlockchain.getLast().getTrueHash());
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
