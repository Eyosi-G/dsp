import java.io.FileInputStream;
import java.io.IOException;

public class CounterThread extends Thread{
    private final String word;
    private final String filename;

    public CounterThread(String word, String filename) {
        this.word = word;
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            int wordCount = countWord(word, filename);
            System.out.println(String.format("%s word in file %s is %d", word, filename, wordCount));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private int countWord(String word, String filename) throws IOException {
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
