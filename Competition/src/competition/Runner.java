/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localTime;
/**
 *
 * @author kristyna kohoutova
 */
class Runner implements Comparable<Runner>{
    private String firstname;
    private String lastname;
    private int number;
    private LocalTime startTime;
    private LocalTime finishTime;
    public final static DateTimeFormatter dtfstart = DateTimeFormatter.ofPattern("HH:mm:ss");
    public final static DateTimeFormatter dtffinish = DateTimeFormatter.ofPattern("HH:mm:ss:SS");

    public Runner(String firstname, String lastname, int number) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.number = number;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getNumber() {
        return number;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
    public String getStartTimeString() {
        return startTime.format(dtfstart);
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }
    public String getFinishTimeString() {
        return finishTime.format(dtffinish);
    }

    public void setStartTime(String startTime) {
        this.startTime = LocalTime.parse(startTime, dtfstart);
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = LocalTime.parse(finishTime, dtffinish);
    }
    
    public LocalTime runningTime(){
        return LocalTime.ofNanoOfDay(finishTime.toNanoOfDay() - startTime.toNanoOfDay());
    }
    
    @Override
    public String toString(){
        return String.format("%-4d%-10s%-10s%-15s%-15s%-15s", number, firstname, lastname, 
                getStartTimeString(), getFinishTimeString(), runningTime().format(dtffinish));
    }
    
    public static void main(String[] args) {
        Runner r = new Runner("Alice", "Mala", 23);
        r.setStartTime("09:00:00");
        r.setFinishTime("10:20:10:019");
        System.out.println(r);
    }

    @Override
    public int compareTo(Runner o) {
        return this.runningTime().compareTo(o.runningTime());
    }
    
    
    
    
}
