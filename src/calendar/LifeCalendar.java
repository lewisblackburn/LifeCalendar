package calendar;

import javax.swing.*;
import java.time.LocalDate;

public class LifeCalendar {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Life Calendar");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            LocalDate birthDate = LocalDate.of(2004, 4, 14);
            int lifespanYears = 80;

            GridPanel panel = new GridPanel(birthDate, lifespanYears);

            JScrollPane scrollPane = new JScrollPane(panel);
            frame.add(scrollPane);

            frame.setSize(1000, 800);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
