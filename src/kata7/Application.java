package kata7;

import application.swing.HistogramPanel;
import application.swing.Toolbar;
import control.CalculateCommand;
import control.Command;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.PopupMenu;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import view.AttributeDialog;
import view.HistogramDisplay;
import view.PopulationDialog;

public class Application extends JFrame {

    private Map<String,Command> commands = new HashMap<>();
    private AttributeDialog attributeDialog;
    private PopulationDialog populationDialog;
    private HistogramDisplay histogramDisplay;
    
    public static void main(String[] args) {
        new Application().setVisible(true);
    }
    
    public Application() {
        this.deployUI();
        this.createCommands();
    }

    private void deployUI() {
        this.setTitle("Histogram viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500,500));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(histogramPanel());
        this.getContentPane().add(toolbar(commands),BorderLayout.NORTH);
    }

    private void createCommands() {
        commands.put("calculate", new CalculateCommand(attributeDialog, populationDialog, histogramDisplay));
    }

    private HistogramPanel histogramPanel() {
        HistogramPanel panel = new HistogramPanel();
        this.histogramDisplay = panel;
        return panel;
    }

    private JPanel toolbar(Map<String, Command> commands) {
        Toolbar panel = new Toolbar(commands);
        this.attributeDialog = panel;
        this.populationDialog = panel;
        return panel;
    }
    
}
