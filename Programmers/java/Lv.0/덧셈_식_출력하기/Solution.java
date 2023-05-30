import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        InputParser inputParser = new InputParser(new SingleIntegerArrayParsingRule());
        ArrayList<Integer> input = inputParser.parseInput();
        Printer p = new Printer(new SolutionPrintStrategy());
        p.print(input);
    }
}

interface InputParsingRuleInterface {
    public ArrayList<Integer> parse(BufferedReader br);
}

class SingleIntegerArrayParsingRule implements InputParsingRuleInterface {
    @Override
    public ArrayList<Integer> parse(BufferedReader br) {
        try {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                arr.add(Integer.parseInt(token));
            }
            return arr;
        } catch (IOException e) {
            return null;
        }
    }
}

class InputParser {
    private InputParsingRuleInterface strategy;

    public InputParser(InputParsingRuleInterface pr) {
        this.strategy = pr;
    }

    public ArrayList<Integer> parseInput() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            ArrayList<Integer> result = this.strategy.parse(br);
            br.close();
            return result;
        } catch (IOException e){
            return null;
        }
    }
}

interface PrintStrategyInterface {
    public String buildPrintableString(ArrayList<Integer> arr);
}

class SolutionPrintStrategy implements PrintStrategyInterface {
    public String buildPrintableString(ArrayList<Integer> arr) {
        StringBuilder sb = new StringBuilder();

        Integer a = arr.get(0);
        Integer b = arr.get(1);
        Integer c = a + b;

        sb.append(a).append(" + ").append(b).append(" = ").append(c);
        return sb.toString();
    }
}

class Printer{
    private PrintStrategyInterface strategy;

    public Printer(PrintStrategyInterface strategy) {
        this.strategy = strategy;
    }

    public void print(ArrayList<Integer> arr) {
        System.out.println(this.strategy.buildPrintableString(arr));
    }
}