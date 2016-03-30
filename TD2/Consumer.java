package td2;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Consumer extends Thread {
    private final Tampon queue;
    
    public Consumer(Tampon queue){
        this.queue = queue;
    }
    
    @Override
    public void run(){
        String name;
        
        try{
			FileWriter fw = new FileWriter("C:/TD2/Bonjour.txt");
			BufferedWriter bw = new BufferedWriter(fw);
            
            while((name = this.queue.get()) != null){
                bw.append(name + "\n");
            }
            bw.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
