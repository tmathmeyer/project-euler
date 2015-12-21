package lib;

public class Stopwatch {

    private long startTime = -1;
    private long stopTime = -1;
    private boolean running = false;
    
    /**
     * Start the stopwatch
     */
    public void start() {
       startTime = System.currentTimeMillis();
       running = true;
    }
    
    /**
     * stop the stopwatch
     */
    public void stop() {
       stopTime = System.currentTimeMillis();
       running = false;
    }
    
    /**
     * 
     * @return the ammout of miliseconds passed since the start of the stopwatch
     */
    public long getElapsedTime() {
       if (startTime == -1) {
          return 0;
       }
       if (running){
       return System.currentTimeMillis() - startTime;
       } else {
       return stopTime-startTime;
       } 
    }

    /**
     * reset the stopwatch
     */
    public void reset() {
       startTime = -1;
       stopTime = -1;
       running = false;
    }
}