package kontroler;

import view.DijalogSortiranjeRecepata;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SortiranjeRecepta implements ActionListener {

    private DijalogSortiranjeRecepata dijalog;

    public SortiranjeRecepta(DijalogSortiranjeRecepata dijalog) {
        this.dijalog = dijalog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable table = view.Recepti.getInstance();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>((DefaultTableModel) table.getModel());
        table.setRowSorter(sorter);

        String parametar = dijalog.getParametar().getSelectedItem().toString();

        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        if(parametar.equals("Sifri")) {
            sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        }
        if(parametar.equals("Lekaru")) {
            sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        }
        if(parametar.equals("Datumu")) {
            sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
        }
        sorter.setSortKeys(sortKeys);

        dijalog.dispose();

    }
}
