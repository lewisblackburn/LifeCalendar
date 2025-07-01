package calendar;

import javax.swing.*;
import java.awt.*;

public class WeekCellPanel extends JPanel {
    private final WeekCell cell;

    public WeekCellPanel(WeekCell cell) {
        this.cell = cell;
        setToolTipText(cell.getDate().toString());
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setOpaque(true);
        setBackground(getColorForCell());
    }

    private Color getColorForCell() {
        if (cell.isCurrent()) return Color.BLUE;
        if (cell.isLived()) return Color.DARK_GRAY;
        return Color.LIGHT_GRAY;
    }

    @Override
    public Dimension getPreferredSize() {
        int width = getParent() != null ? getParent().getWidth() / 52 : 14;
        return new Dimension(width, width);
    }
}
