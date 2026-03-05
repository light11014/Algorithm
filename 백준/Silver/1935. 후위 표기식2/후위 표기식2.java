import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String expression = br.readLine();

        Double[] operands = new Double[N];
        for(int i = 0; i < N; i++) {
            operands[i] = Double.parseDouble(br.readLine());
        }

        ArrayDeque<Double> stack = new ArrayDeque<>();

        for(char op : expression.toCharArray()) {
            if(op >= 'A' && op <= 'Z') {
                stack.push(operands[op-'A']);
            } else {
                Double op2 = stack.pop();
                Double op1 = stack.pop();

                switch (op) {
                    case '+': stack.push(op1 + op2); break;
                    case '-': stack.push(op1 - op2); break;
                    case '*': stack.push(op1 * op2); break;
                    case '/': stack.push(op1 / op2); break;
                }
            }
        }

        System.out.printf("%.2f", stack.pop());
    }

}