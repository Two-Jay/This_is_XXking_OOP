import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
    }
}

class FilePath {
    private String path = null;

    public FilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}

interface InputReadStrategyInterface {
}

class Tokenizer {
    private InputReadStrategyInterface strategy;

    public ArrayList<ArrayList<String>> tokenize() {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        return result;
    }
}

class InputParser {

    private FilePath path;

    public ArrayList<Integer> parseInput() {
        try {
            ArrayList<Integer> result = new ArrayList<Integer>();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            return result;
        } catch (IOException e) {
            return null;
        }
    }

    public void setPath(FilePath path) {
        this.path = path;
    }
}