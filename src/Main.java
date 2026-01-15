import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Message msg = new Message("Transaction 1");
        Block blocks = new Block(msg, "0000000000");
        ArrayList<Generals> generals = new ArrayList<>();
        for (int i = 0; i < 100; i ++) {
            Generals newGen = new Generals();
            if (newGen.getTrust()) {
                generals.add(newGen);
            }
        }
        int trust = 0;
        for (int i = 0; i < generals.size(); i ++) {
            if (generals.get(i).trust == false) {
                trust ++;
            }
        }
        System.out.println("There are currently " + trust + " false generals out of " + generals.size() + " generals!");
        Chain.theBlockchain.add(blocks);
        for (int j = 0; j < 100; j ++) {
            Block[] blocks2 = new Block[generals.size()];
            for (int i = 0; i < generals.size(); i ++) {
                if (generals.get(i).getTrust()) {
                    blocks2[i] = (generals.get(i).proposeBlock());
                }
            }
            String[] holay = new String[blocks2.length];
            for (int i = 0; i < blocks2.length; i ++) {
                holay[i] = (blocks2[i].getTrueHash());
            }
            String molay = MostFrequentString.findMostFrequent(holay);
            for (int i = 0; i < blocks2.length; i ++) {
                if (blocks2[i].getTrueHash().equals(molay)) {
                    Chain.theBlockchain.add(blocks2[i]);
                    i = blocks2.length;
                }
            }
        }

        for (int z = 0; z < Chain.theBlockchain.size(); z ++) {
            System.out.println(Chain.theBlockchain.get(z).hash);
        }


    }
}