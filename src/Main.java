import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Message msg = new Message("yahoo!");
        Block blocks = new Block(msg, "0000000000");

        String[] words = {
                "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "ice", "jungle", "kite", "lemon", "mango", "nectarine", "orange", "peach", "quartz", "river", "stone", "tree", "umbrella", "violet", "water", "xylophone", "yarn", "zebra", "cloud", "dream", "echo", "flame", "glow", "horizon", "island", "journey", "king", "light", "mountain", "night", "ocean", "path", "quiet", "rain", "shadow", "thunder", "unity", "valley", "wind", "year", "zenith", "forest", "garden", "harbor", "inspire", "joy", "kindness", "laughter", "memory", "nature", "open", "peace", "quest", "rise", "sun", "time", "under", "vision", "wonder", "youth", "zone", "adventure", "balance", "courage", "destiny", "energy", "freedom", "growth", "hope", "imagine", "justice", "knowledge", "love", "magic", "novel", "optimism", "power", "quality", "respect", "strength", "trust", "unity", "victory", "wisdom", "xenon", "yearning", "zeal"
        };
        ArrayList<Generals> generals = new ArrayList<>();
        for (int i = 0; i < 100; i ++) {
            generals.add(new Generals());
        }
        Message[] msgs = new Message[words.length];
        for (int i = 0; i < words.length; i ++) {
            msgs[i] = new Message(words[i]);
        }
        Chain.theBlockchain.add(blocks);

        for (int j = 0; j < generals.size(); j ++) {
            Block[] hewn = new Block[generals.size()];
            for (int i = 0; i < generals.size(); i ++) {
                String pseudo = "";
                String[] temp = generals.get(i).proposeBlock().getHash().split(":");
                pseudo = temp[0] + " : " + temp[1] + " : " + temp[2];
                hewn[i] = new Block(generals.get(i).getMessage(), pseudo);
//            Chain.theBlockchain.add(new Block(generals.get(i).getMessage(), pseudo));
            }
            String[] strings = new String[generals.size()];
            for (int k = 0; k < hewn.length; k ++) {
                strings[k] = hewn[k].getHash();
            }
            Chain.theBlockchain.add(new Block(new Message(strings[j]), Chain.theBlockchain.getLast().previousHash));

        }
        for (int z = 0; z < Chain.theBlockchain.size(); z ++) {
            System.out.println(Chain.theBlockchain.get(z).hash);
        }
//        for (int i = 0 ; i < msgs.length; i ++) {
//            String pseudo = "";
//            String[] temp = Chain.theBlockchain.get(i).hash.split(" : ");
//            pseudo = temp[0] + " : " + temp[1] + " : " + temp[2];
//
//            Chain.theBlockchain.add(new Block(msgs[i],pseudo));
//        }

    }
}