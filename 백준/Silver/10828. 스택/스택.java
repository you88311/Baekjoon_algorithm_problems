import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    static public class Stack {
        int[] stack;
        int length = 0;

        public Stack(int size) {
            this.stack = new int[size];
        }

        void push(int input) {
            stack[length++] = input;
        }

        int pop() {
            if (length == 0) return -1;

            return stack[length-- - 1];
        }

        int size() {
            return length;
        }

        int empty() {
            return length == 0 ? 1 : 0;
        }

        int top() {
            if (length == 0) return -1;

            return stack[length - 1];
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int commandCnt = Integer.parseInt(br.readLine());
        String command;
        Stack stack = new Stack(commandCnt);

        for (int i = 0; i < commandCnt; i++) {
            command = br.readLine();
            if (command.equals("pop")) {
                System.out.println(stack.pop());
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                System.out.println(stack.empty());
            } else if (command.equals("top")) {
                System.out.println(stack.top());
            } else if (command.startsWith("push")) {
                String[] pushCommand = command.split(" ");
                stack.push(Integer.parseInt(pushCommand[1]));
            }
        }

    }
}

