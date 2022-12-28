package AssignmentK;

import java.time.*;
import java.util.*;

public class Task {
	public void addDaysSkippingWeekends(LocalDate date, int timeRequired, List<LocalDate> leave,
			LocalTime workStartTime) {
		System.out.println("Task start date and time: " + date + " " + workStartTime);
		Collections.sort(leave);
		LocalDate result = date;
		float day = timeRequired / 8;
		int addDays = 0;

		while (addDays < day) {
			result = result.plusDays(1);
			if (result.getDayOfWeek() != DayOfWeek.SATURDAY && result.getDayOfWeek() != DayOfWeek.SUNDAY) {
				if (leave.contains(result)) {
					System.out.print("");
				} else
					++addDays;

			}
		}
		int t = timeRequired % 8;
		LocalTime resultTime = workStartTime.plusHours(t);
		if (timeRequired % 8 > 0) {
			result = result.plusDays(1);
			while (true) {
				if (leave.contains(result)) {
					result = result.plusDays(1);
				} else if (result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY) {
					result = result.plusDays(1);
				} else
					break;

			}
		}
		LocalTime checkStartTime = LocalTime.of(23, 00, 00, 00);
		LocalDate temp = result;
		if (timeRequired % 8 > 1 && workStartTime == checkStartTime) {

			while (true) {
				temp = result;
				result = result.plusDays(1);
				if (!(leave.contains(result) || result.getDayOfWeek() == DayOfWeek.SATURDAY
						|| result.getDayOfWeek() == DayOfWeek.SUNDAY)) {

					break;
				}
			}
			if (result.getDayOfWeek() == DayOfWeek.SUNDAY) {
				result = result.plusDays(1);
			}

		}

		System.out.println("Time required to complete this task: " + timeRequired + "H");
		System.out.println("Task end date and time : " + result + " " + resultTime);

	
	}

	public static void main(String[] args) {
		//Obeject  of Task class
		Task x = new Task(); 
		int timeRequired = 20; //Pass total time require to complete the task
		
		LocalTime workStartTime = LocalTime.of(9, 00, 00, 00);//Pass employee workstart time
    
		LocalDate date1 = LocalDate.of(2022, 12, 24);//Work start date
		
		//list of leaves
		LocalDate l2 = LocalDate.of(2022, 12, 27);
		LocalDate l1 = LocalDate.of(2022, 12, 28);

		List<LocalDate> leave = new ArrayList<LocalDate>();
		leave.add(l1);
		leave.add(l2);
		
		 x.addDaysSkippingWeekends(date1, timeRequired, leave, workStartTime);// call method to find the work completion date and time 

	}
}
