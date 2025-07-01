package calendar;

import javax.swing.*;
import java.time.LocalDate;

public class LifeCalendar {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LocalDate birthDate = LocalDate.of(2004, 4, 14);
            int lifespanYears = 80;

            JFrame frame = new JFrame("Life Calendar");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            GridPanel panel = new   GridPanel(birthDate, lifespanYears);
            frame.add(new JScrollPane(panel));

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

