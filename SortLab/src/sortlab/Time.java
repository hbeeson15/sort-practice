package sortlab;

/*
This function is where the computer's run time clock is accessed. startTime()
begins the timer, and runTime subtracts the start time from the end time to
give the amount of time the sort took in milliseconds. 
*/
public class Time{
    
    long start;
    long run;
    
    public void Time() {
        
    }
    
    public long startTime(){
        start = System.currentTimeMillis();
        return start;
    }
    
    public long runTime(long startTime){

        run = System.currentTimeMillis() - start;
        System.out.println("Run time: " + run);
        return run;
    }
}