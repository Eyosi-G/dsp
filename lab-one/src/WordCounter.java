import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WordCounter {
    public static void main(String[] args) throws IOException {
        int countInA = countWord("a.txt", "Wolrd");
        int countInB = countWord("b.txt", "Wolrd");
        System.out.println("word count in a " + countInA);
        System.out.println("word count in b " + countInB);

    }

    public static int countWord(String filename, String word) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        String wordHolder = "";
        int count = 0;
        int character = fileInputStream.read();
        while(character!= -1){
            char letter = (char) character;
            if(letter != ' '){
                wordHolder += letter;
            }else{
                wordHolder = "";
            }

            if(word.equals(wordHolder)){
                count++;
            }

            character = fileInputStream.read();

        }
        return count;
    }
}
