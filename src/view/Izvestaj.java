package view;

import application.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class Izvestaj extends JTable {

    private static Izvestaj instance;

    public Izvestaj(DefaultTableModel model) {
        super(model);
        this.setIntercellSpacing(new Dimension(0,0));
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBackground(Main.nebeskoPlava);
        this.setShowVerticalLines(false);
        TableColumnModel tableColumnModel = this.getColumnModel();
        JTableHeader tableHeader = this.getTableHeader();
        tableHeader.setBackground(Main.nebeskoPlava);
        tableHeader.setForeground(Main.tamnoPlava);
        tableColumnModel.getColumn(0).setCellRenderer(renderer);
        tableColumnModel.getColumn(2).setCellRenderer(renderer);
        DefaultTableCellRenderer renderer2 = new DefaultTableCellRenderer();
        renderer2.setBackground(Main.svetloPlava);
        this.getColumnModel().getColumn(1).setCellRenderer(renderer2);
    }

    public static Izvestaj getInstance() {
        if(instance == null) {
            instance = new Izvestaj(model.Izvestaj.getInstance().getModel());
        }
        return instance;
    }

}
