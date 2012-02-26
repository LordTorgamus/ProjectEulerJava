package probs;

import utils.collections.CircularLinkedList;
import utils.euler.EulerProblem;
import utils.time.Day;
import utils.time.Month;

/**
 * Project Euler problem 19
 * 
 * You are given the following information, but you may prefer to do some research for yourself.
 * 
 * <ul>
 * <li>1 Jan 1900 was a Monday.
 * <li>Thirty days has September, April, June and November. All the rest have thirty-one, Saving February alone, Which has twenty-eight, rain or
 * shine. And on leap years, twenty-nine.
 * <li>A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * </ul>
 * 
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 * 
 * @author Lord Torgamus
 */
public class Problem0019 extends EulerProblem {
    static int                     START_YEAR;
    static int                     END_YEAR;
    static int                     DAYS_IN_WEEK;
    static CircularLinkedList<Day> dayList;

    static {
        START_YEAR = 1901;
        END_YEAR = 2000;

        DAYS_IN_WEEK = 7;

        dayList = new CircularLinkedList<Day>();
        dayList.append(Day.SUNDAY);
        dayList.append(Day.MONDAY);
        dayList.append(Day.TUESDAY);
        dayList.append(Day.WEDNESDAY);
        dayList.append(Day.THURSDAY);
        dayList.append(Day.FRIDAY);
        dayList.append(Day.SATURDAY);

        // Jan. 1, 1901 was a Tuesday
        while(dayList.getCurrentValue() != Day.TUESDAY) {
            dayList.advanceCurrent();
        }
    }

    public static void main(String[] args) throws Exception {
        run(new Problem0019());
    }

    @Override
    protected long doProblemSpecificStuff() {
        int numOfFirstSundays = 0;

        for(int year = START_YEAR; year <= END_YEAR; year++) {
            for(Month month : Month.values()) {
                if(isSunday()) {
                    numOfFirstSundays++;
                }
                advanceToNextMonth(month, year);
            }
        }

        return numOfFirstSundays;
    }

    private static boolean isSunday() {
        return dayList.getCurrentValue() == Day.SUNDAY;
    }

    private static void advanceToNextMonth(Month curMonth, int curYear) {
        int daysInCurMonth;
        switch(curMonth) {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                daysInCurMonth = 31;
                break;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                daysInCurMonth = 30;
                break;
            case FEBRUARY:
                daysInCurMonth = getDaysInFeb(curYear);
                break;
            default:
                throw new IllegalArgumentException();
        }

        int dayOffset = daysInCurMonth % DAYS_IN_WEEK;
        for(int i = 0; i < dayOffset; i++) {
            dayList.advanceCurrent();
        }
    }

    private static int getDaysInFeb(int curYear) {
        boolean leapYear;

        if(curYear % 400 == 0) {
            leapYear = true;
        } else if(curYear % 100 == 0) {
            leapYear = false;
        } else if(curYear % 4 == 0) {
            leapYear = true;
        } else {
            leapYear = false;
        }

        if(leapYear) {
            return 29;
        }
        return 28;
    }
}
