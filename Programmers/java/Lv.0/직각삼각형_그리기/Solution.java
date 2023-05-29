import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static Integer getInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            return n;
        } catch (IOException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        try {
            FigureGeneratorFactory factory = new FigureGeneratorFactory();
            FigureGenerator generator = factory.create("RightAngle");
            ArrayList<String> result = generator.generate(getInput());
            Printer p = new Printer();
            p.print(result);
        } catch (Exception e) {
            return;
        }
    }
}

class SolutionInputException extends RuntimeException {
}

class Printer {
    public void print(ArrayList<String> n) {
        for (int i = 0; i < n.size(); i++) {
            System.out.println(n.get(i));
        }
    }
}

interface FigureGenerator {
    public ArrayList<String> generate(Integer n);
}

class RightAngleGenerator implements FigureGenerator {
    public ArrayList<String> generate(Integer n) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            String s = "*".repeat(i + 1);
            result.add(s);
        }
        return result;
    }
}

class FigureGeneratorFactory {

    public FigureGenerator create(String s) {
        if (s.compareTo("RightAngle") == 0) {
            return new RightAngleGenerator();
        }
        throw new SolutionInputException();
    }
}
