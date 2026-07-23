import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {

        HashMap<String, Integer> studentMarks = new HashMap<>();

        studentMarks.put("Alice", 85);
        studentMarks.put("Bob", 92);
        studentMarks.put("Charlie", 78);
        studentMarks.put("Diana", 95);
        studentMarks.put("Eve", 88);

        System.out.println("All Students: " + studentMarks);

        System.out.println("Bob's marks: " + studentMarks.get("Bob"));

        System.out.println("Contains Alice: " + studentMarks.containsKey("Alice"));
        System.out.println("Contains Frank: " + studentMarks.containsKey("Frank"));

        studentMarks.put("Charlie", 82);
        System.out.println("Charlie updated marks: " + studentMarks.get("Charlie"));

        studentMarks.remove("Eve");
        System.out.println("After removing Eve: " + studentMarks);

        System.out.println("Size: " + studentMarks.size());

        System.out.println("Iterating:");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Keys: " + studentMarks.keySet());
        System.out.println("Values: " + studentMarks.values());
    }
}
