public final class Time{
    int hours;
    int minutes;
    int seconds;
    
    public Time(int hours, int minutes, int seconds){
        assert isHourCorrect(hours) : "Invalid hour";
        assert isMinuteCorrect(minutes) : "Invalid minute";
        assert isSecondCorrect(seconds) : "Invalid second";
        
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    
    public boolean isTimeEqual(Time time){
        return this.hours == time.hours && this.minutes == time.minutes && this.seconds == time.seconds;
    }
    
    public boolean isTimeBefore(Time time){
        return !isTimeAfter(time);
    }
    
    public boolean isTimeAfter(Time time){
        if(this.hours > time.hours){
            return true;
        }else if(this.hours == time.hours){
            if(this.minutes > time.minutes){
                return true;
            }else if(this.minutes == time.minutes){
                if(this.seconds > time.seconds){
                    return true;
                }
            }
        }
        return false;
    }
    
    public int compareTo(Time time){
        return isTimeEqual(time) ? 0 : isTimeAfter(time) ? 1 : -1;
    }

    public void next(){
        this.seconds++;
        if(!isSecondCorrect(this.seconds)){
            this.seconds = 0;
            this.minutes++;
            if(!isMinuteCorrect(this.minutes)){
                this.minutes = 0;
                this.hours++;
                if(!isHourCorrect(this.hours)){
                    this.hours = 0;
                }
            }
        }
    }
    
    public void previous(){
        this.seconds--;
        if(!isSecondCorrect(this.seconds)){
            this.seconds = 59;
            this.minutes--;
            if(!isMinuteCorrect(this.minutes)){
                this.minutes = 59;
                this.hours--;
                if(!isHourCorrect(this.hours)){
                    this.hours = 23;
                }
            }
        }
      
    }

    @Override
    public String toString(){
        return String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
    }
    
    public Time addTime(Time time) {
        int totalSeconds = this.seconds + time.seconds;
        int totalMinutes = this.minutes + time.minutes + totalSeconds / 60;
        int totalHours = this.hours + time.hours + totalMinutes / 60;

        int resultSeconds = totalSeconds % 60;
        int resultMinutes = totalMinutes % 60;
        int resultHours = totalHours % 24;

        return new Time(resultHours, resultMinutes, resultSeconds);
    }
    
    public boolean isHourCorrect(int hours){
        return hours >= 0 && hours < 24;
    }
    
    public boolean isMinuteCorrect(int minutes){
        return minutes >= 0 && minutes < 60;
    }
    
    public boolean isSecondCorrect(int seconds){
        return seconds >= 0 && seconds < 60;
    }
  


}