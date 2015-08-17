package pdc.project.Model;
import java.util.Timer;
/**
 * Timer class for point calculation and challenge limitation.
 */
public class GameTimer extends Thread {
    private long startTime;
    private boolean started;
    //end of instance variables.
    public void startThread() {
        this.startTime = System.currentTimeMillis();
        this.started = true;
        this.start();
    }
    public void run() {
        while (started) {
            //looks like it does nothing, because logic is in startThread();
        }
    }
    public void stopThread() {
        this.started = false;
    }  
    public int[] getCurrentTime(){
        long milliTime = System.currentTimeMillis() - this.startTime;
        int[] out = new int[]{0, 0, 0, 0};
        out[0] = (int)(milliTime / 3600000);
        out[1] = (int)(milliTime / 60000) % 60;
        out[2] = (int)(milliTime / 1000) % 60;
        out[3] = (int)(milliTime) % 1000;

        return out;
    }
    public void startTimer(){
        this.startThread();
    }
    public void endTimer(){
        this.stopThread();
    }
    public void pauseTimer(){
        //cannot see need to pause since endTimer is basically a pause.
    }
    
    public boolean isWithinTimeframe(){
        //
        return true; //method to check if something is completed within a time-frame.
    }
}
