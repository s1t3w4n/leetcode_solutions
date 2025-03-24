import java.util.Arrays;
import java.util.stream.Collectors;

public class Helper {
    public static void main(String[] args) {
        String s = "[3,49],[23,44],[21,56],[26,55],[23,52],[2,9],[1,48],[3,31]";
        String collect = Arrays.stream(s.split("],")).map(v -> v.replace("[", "new int[]{") + "}")
                .collect(Collectors.joining(",\n"));
        System.out.println(collect);
    }
}
