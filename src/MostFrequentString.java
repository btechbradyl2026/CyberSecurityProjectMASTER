import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class MostFrequentString {

    public static String findMostFrequent(String[] strings) {
        if (strings == null || strings.length == 0) {
            return null;
        }

        // 1. Create a HashMap to store strings as keys and their frequencies as values.
        Map<String, Integer> frequencyMap = new HashMap<>();

        // 2. Iterate through the array and update the frequency map.
        for (String str : strings) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        // 3. Iterate through the map to find the string with the maximum frequency.
        String mostFrequentString = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentString = entry.getKey();
            }
        }

        // Return null if no duplicates (maxCount is 1 or less)
        return maxCount > 1 ? mostFrequentString : null;
    }

    public static void main(String[] args) {
        String[] data = {"apple", "banana", "apple", "orange", "banana", "apple", "grape", "banana"};
        String mostFrequent = findMostFrequent(data);
        if (mostFrequent != null) {
            System.out.println("The most frequent duplicate string is: " + mostFrequent);
        } else {
            System.out.println("No duplicate strings found or the input is empty.");
        }
    }
}
