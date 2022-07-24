import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    static void addCharwithIterator(ListIterator<Character> iterator, String input){
        for(int i = 0; i < input.length(); i++)
            iterator.add(input.charAt(i));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> iterator= list.listIterator();
        //첫 번재 문자열 저장
        String input = br.readLine();
        addCharwithIterator(iterator, input);
        //명령어 개수 저장
        int commandCnt = Integer.parseInt(br.readLine());
        String command;
        for (int i = 0; i < commandCnt; i++) {
            command = br.readLine();
        //명렁어 대로 실행
            if (command.equals("L")) {
                if (iterator.previousIndex() != -1) iterator.previous();
            } else if (command.equals("D")) {
                if (iterator.nextIndex() != list.size()) iterator.next();
            } else if (command.equals("B")) {
                if (iterator.previousIndex() != -1){
                    iterator.previous();
                    iterator.remove();
                }
            } else if(command.startsWith("P")){
                String[] arr = command.split(" ");
                addCharwithIterator(iterator, arr[1]);
            }
        }

        bw.write(list.toString()
                .replaceAll(" ","")
                .replaceAll(",","")
                .replaceAll("\\[","")
                .replaceAll("\\]",""));
        bw.flush();
        bw.close();
    }
}
