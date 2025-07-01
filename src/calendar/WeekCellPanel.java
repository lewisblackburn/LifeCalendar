package calendar;

import javax.swing.*;
import java.awt.*;

public class WeekCellPanel extends JPanel {
    public WeekCellPanel(WeekCell cell) {
        setBackground(getColorForCell(cell));
        setToolTipText(cell.getDate().toString());
    }

    private Color getColorForCell(WeekCell cell) {
        if (cell.isCurrent()) return Color.BLUE;
        if (cell.isLived()) return Color.DARK_GRAY;
        return Color.LIGHT_GRAY;
    }
}
