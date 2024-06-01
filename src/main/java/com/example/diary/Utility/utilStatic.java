package com.example.diary.Utility;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class utilStatic {
    public static LocalDate[] yearDaysList(){
        List<LocalDate> days = new LinkedList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldFirst = LocalDate.of(2023,1,1);
        LocalDate ldNow = LocalDate.now();
        Period period = Period.between(ldFirst, ldNow);
        int months = period.getMonths() + period.getYears() * 12;

        int addYear = 0;
        for (int i = 1; i <= months + 1; i++){
            int month = i % 12;
            StringBuilder yearDay = new StringBuilder();
            yearDay.append(2023 + addYear)
            .append("-")
            .append(String.format("%02d", month == 0 ? 12 : month))
            .append("-01");
            LocalDate date = LocalDate.parse(yearDay.toString(), dtf);
            days.add(date);
            if (month == 0)
                addYear++;
        }
        return days.toArray(new LocalDate[0]);
    }
}
