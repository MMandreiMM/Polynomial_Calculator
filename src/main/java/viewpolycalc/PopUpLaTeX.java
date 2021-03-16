package viewpolycalc;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class PopUpLaTeX extends JPopupMenu {
    private String mathExp;
    public PopUpLaTeX() {
        JMenuItem item = new JMenuItem("Genereaza LaTeX");
        item.addActionListener(e -> initJFrame());
        add(item);
    }

    private void initJFrame() {
        JFrame latexFrame = new JFrame("LaTeX");
        TeXFormula formula = new TeXFormula(mathExp);
        TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 40);
        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        icon.paintIcon(new JLabel(), bufferedImage.getGraphics(), 0, 0);
        JLabel label = new JLabel();
        label.setIcon(icon);
        latexFrame.add(label);
        latexFrame.pack();
        latexFrame.setLocationRelativeTo(null);
        latexFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        latexFrame.setVisible(true);
    }

    public void setMathExp(String mathExp) {
        this.mathExp = mathExp;
    }

}
