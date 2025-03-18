public final class Date {
    private int year; 
    private int month;
    private int day;

    public Date(int year, int month, int day){    
        assert year > 0 && month > 0 && day > 0 : "Invalid date";
        assert isMonthCorrect(month) : "Invalid month";
        assert isDayCorrect(day) : "Invalid day"; 

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isDateEqual(Date date) {
        return this.year == date.year && this.month == date.month && this.day == date.day;
    }	

    public boolean isDateBefore(Date date){
        return !isDateAfter(date);
    }

    public boolean isDateAfter(Date date){
        if (this.year > date.year) {
            return true;
        } else if (this.year == date.year) {
            if (this.month > date.month) {
                return true;
            } else if (this.month == date.month) {
                return this.day > date.day;
            }
        }
        return false;
    }
    
    public int compareTo(Date date)	{
        return isDateEqual(date) ? 0 : isDateAfter(date) ? 1 : -1;
    }

    @Override
    public String toString() {
        return this.year + "/" + this.month + "/" + this.day;
    }

    public void  next(){
        this.day++;
        if(!isDayCorrect(this.day)){
            this.day = 1;
            this.month++;
            if (!isMonthCorrect(this.month)){
                this.month = 1;
                this.year++;
            }
        }
    }
   
    public void previus(){
        this.day--;
        if(!isDayCorrect(this.day)){
            this.month--;
            if (!isMonthCorrect(this.month)){
                this.month = 12;
                this.year--;
            }
        }
    }
 
    public boolean isMonthCorrect(int month){
        return month >= 1 && month <= 12;
    }
    
    public boolean isDayCorrect(int day){
        return switch (this.month) {
            case 2 -> isLeapYear() ? day <= 29 : day <= 28;
            case 4, 6, 9, 11 -> day <= 30; 
            default -> day <= 31;};
    }

    private boolean isLeapYear() {
        return (this.year % 4 == 0 && this.year % 100 != 0 || this.year % 400 == 0);
    }
}