package calendar;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class GridPanel extends JPanel {
    private final List<WeekCell> weeks = new ArrayList<WeekCell>();
    private final LocalDate birthDate;
    private final int lifespanYears;

    public GridPanel(LocalDate birthDate, int  lifespanYears) {
        this.birthDate = birthDate;
        this.lifespanYears = lifespanYears;
        generateWeeks();
        setPreferredSize(new Dimension(1000, 600));
    }

    private void generateWeeks() {
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

            weeks.add(cell);
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cols = 52;
        int cellSize = 12;
        int padding = 2;

        for (WeekCell cell : weeks) {
            int x = (cell.getIndex() % cols) * (cellSize + padding);
            int y = (cell.getIndex() / cols) * (cellSize + padding);

            if (cell.isCurrent()) {
                g.setColor(Color.BLUE);
            } else if (cell.isLived()) {
                g.setColor(Color.DARK_GRAY);
            } else {
                g.setColor(Color.LIGHT_GRAY);
            }

            g.fillRect(x, y, cellSize, cellSize);
        }
    }
}
