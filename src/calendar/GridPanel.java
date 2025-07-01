package calendar;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GridPanel extends JPanel {
    public GridPanel(LocalDate birthDate, int lifespanYears) {
        setLayout(new GridLayout(0, 52)); // 52 weeks per row

        LocalDate today = LocalDate.now();
        LocalDate endDate = birthDate.plusYears(lifespanYears);
        long totalWeeks = ChronoUnit.WEEKS.between(birthDate, endDate);

        for (int i = 0; i < totalWeeks; i++) {
            LocalDate weekDate = birthDate.plusWeeks(i);
            WeekCell cell = new WeekCell(i, weekDate);
            cell.setLived(!weekDate.isAfter(today));

            LocalDate weekStart = weekDate;
            LocalDate weekEnd = weekDate.plusDays(6);
            if (!today.isBefore(weekStart) && !today.isAfter(weekEnd)) {
                cell.setCurrent(true);
            }

            add(new WeekCellPanel(cell));
        }
    }
}
