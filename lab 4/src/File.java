import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


enum State{START, CHR_BODY, CHR_SPEC_SYMB, STR_BODY, SPEC_SYMB, SUSPECTED_STR, SUSPECTED_COMM, ONE_STR_COMM, COMM, STAR }

public class File {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("D:\\универ\\3 сем\\java\\lab 4\\src\\input.txt");
        FileWriter fw = new FileWriter("D:\\универ\\3 сем\\java\\lab 4\\src\\output.txt");
        Scanner sc = new Scanner(fr);
        State state = State.START;
        StringBuilder begin = new StringBuilder();
        StringBuilder end = new StringBuilder();
        while (sc.hasNextLine()) {
            begin.append(sc.nextLine() + "\n");
        }
        String in = begin.toString();
        for (char symbol : in.toCharArray()) {
            switch (state) {
                case START:
                    if (symbol == '\'') {
                        end.append(symbol);
                        state = State.CHR_BODY;
                    } else if (symbol == '\"') {
                        end.append(symbol);
                        state = State.STR_BODY;
                    } else if (symbol == '/')
                        state = State.SUSPECTED_COMM;
                    else {
                        end.append(symbol);
                        state = State.START;
                    }
                    break;

                case CHR_BODY:
                    if (symbol == '\'') {
                        end.append(symbol);
                        state = State.START;
                    } else if (symbol == '\\') {
                        end.append(symbol);
                        state = State.CHR_SPEC_SYMB;
                    } else {
                        end.append(symbol);
                        state = State.CHR_BODY;
                    }
                    break;

                case CHR_SPEC_SYMB:
                    end.append(symbol);
                    state = State.CHR_BODY;
                    break;

                case STR_BODY:
                    if (symbol == '\"') {
                        end.append(symbol);
                        state = State.SUSPECTED_STR;
                    } else if (symbol == '\\') {
                        end.append(symbol);
                        state = State.SPEC_SYMB;
                    } else {
                        end.append(symbol);
                        state = State.STR_BODY;
                    }
                    break;

                case SPEC_SYMB:
                    end.append(symbol);
                    state = State.STR_BODY;
                    break;


                case SUSPECTED_STR:
                    if (symbol == '\"') {
                        end.append(symbol);
                        state = State.STR_BODY;
                    } else {
                        end.append(symbol);
                        state = State.START;
                    }
                    break;
                case SUSPECTED_COMM:
                    if (symbol == '/') {
                        state = State.ONE_STR_COMM;
                    } else if (symbol == '*') {
                        state = State.COMM;
                    } else if (symbol == '\'') {
                        end.append("/" + symbol);
                        state = State.CHR_BODY;
                    } else {
                        end.append("/");
                        state = State.START;
                    }
                    break;

                case ONE_STR_COMM:
                    if (symbol == '\n') {
                        end.append(symbol);
                        state = State.START;
                    } else {
                        state = State.ONE_STR_COMM;
                    }
                    break;
                case COMM:
                    if (symbol == '*') {
                        state = State.STAR;
                    } else {
                        state = State.COMM;
                    }
                    break;
                case STAR:
                    if (symbol == '/') {
                        state = State.START;
                    } else {
                        state = State.COMM;
                    }
                    break;
            }
        }
        fw.write(end.toString());
        fw.close();
    }
}
