package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ChatLogger {
    private final String FILE_PATH = "src/log.txt";

    public void saveChatToFile(String text) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            out.write(text);
            out.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String loadChatFromFile(){
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
                sb.append("\n");
            }
//            sb.delete(sb.length()-1, sb.length());
            return sb.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
