package utils.euler;

import org.joda.time.Duration;
import org.joda.time.Instant;

public class EulerTimer {
    private Instant startTime;

    public EulerTimer() {
        startTime = new Instant();
    }
    
    public int getRunningTime() {
        Duration runningTime = new Duration(startTime, new Instant());
        return (int) runningTime.getStandardSeconds();
    }
}
