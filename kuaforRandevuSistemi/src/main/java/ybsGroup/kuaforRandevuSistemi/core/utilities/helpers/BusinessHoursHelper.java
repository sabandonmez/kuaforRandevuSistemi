package ybsGroup.kuaforRandevuSistemi.core.utilities.helpers;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.EnumSet;
import java.util.Set;

public class BusinessHoursHelper {

	public static final Set<DayOfWeek> working_days=EnumSet.of(
		DayOfWeek.MONDAY , DayOfWeek.TUESDAY ,DayOfWeek.WEDNESDAY,
		DayOfWeek.THURSDAY,DayOfWeek.FRIDAY,DayOfWeek.SATURDAY
	);
	
	public static final LocalTime start_hour=LocalTime.of(9, 0);
	public static final LocalTime end_hour=LocalTime.of(21, 0);
	
}
