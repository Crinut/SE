package td3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteThread extends Thread {
	private static final Logger log = Logger.getLogger(WriteThread.class.getName());
    private static ArrayList<String> list = new ArrayList<>();
    
    public WriteThread(ArrayList<String> list, String name){
		WriteThread.list =  list;
        super(name);
    }
    
    @Override
    public void run(){
        String name;
        try(BufferedWriter bw =  new BufferedWriter(new FileWriter("C:/TD3/Bonjour.txt"))){
            while((name = WriteThread.list.get(WriteThread.list.size()-1)) != null){
                bw.append(name + "\n");
                WriteThread.list.remove(WriteThread.list.size()-1);
            }
            bw.close();
        } catch(Exception e) {
            log.log(Level.INFO, e.getMessage());
        }
    }
}
