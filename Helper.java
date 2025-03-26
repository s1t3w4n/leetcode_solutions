import java.util.Arrays;
import java.util.stream.Collectors;

public class Helper {
    public static void main(String[] args) {
        String s = "[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]";
        String collect = Arrays.stream(s.split("],")).map(v -> v.replace("[", "new int[]{") + "}")
                .collect(Collectors.joining(",\n"));
        System.out.println(collect);
    }
}
