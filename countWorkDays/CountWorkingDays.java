import java.time.DayOfWeek;
import java.time.LocalDate;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.temporal.ChronoUnit.WEEKS;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

public class CountWorkingDays {

    public static void main(String[] args) {
        System.out.println(count(LocalDate.of(2017, 6, 1), LocalDate.of(2017, 6, 1))); // 20
		System.out.println(countBetter(LocalDate.of(2017, 6, 1), LocalDate.of(2017, 6, 1))); // 20
    }
	
	static long count(final LocalDate start, final LocalDate end) {
		LocalDate newStart = LocalDate.of(start.getYear(), start.getMonth(), 1);
		boolean isMonday = newStart.getDayOfWeek().equals(DayOfWeek.MONDAY);
		if (!isMonday) {
			int weekDayValue = start.getDayOfWeek().getValue();
			int diff = Math.abs(7 - weekDayValue) + 1;
			newStart = newStart.plusDays(diff);
		}
      
		int daysInMonth = end.lengthOfMonth();
        LocalDate newEnd = LocalDate.of(end.getYear(), end.getMonth(), daysInMonth);
		
        while (!newEnd.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
			newEnd = newEnd.minusDays(1);
        }
		
		return (WEEKS.between(newStart, newEnd) + 1) * 5;
    }

	static long countBetter(final LocalDate start, final LocalDate end) {
		LocalDate startMonday = start.with(nextOrSame(DayOfWeek.MONDAY));
        LocalDate endFriday = end
                .with(lastDayOfMonth())
                .with(previousOrSame(DayOfWeek.FRIDAY));

		return (WEEKS.between(startMonday, endFriday) +1) * 5;
	}
}