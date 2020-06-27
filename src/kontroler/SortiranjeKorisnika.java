package kontroler;

import view.DijalogSortiranjeKorisnika;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SortiranjeKorisnika implements ActionListener {

    private DijalogSortiranjeKorisnika dijalog;

    public SortiranjeKorisnika(DijalogSortiranjeKorisnika dijalog) {
        this.dijalog = dijalog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable table = view.Korisnici.getInstance();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>((DefaultTableModel) table.getModel());
        table.setRowSorter(sorter);

        String parametar = dijalog.getParametar().getSelectedItem().toString();

        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        if(parametar.equals("Ime")) {
            sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        }
        if(parametar.equals("Prezime")) {
            sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
        }
        if(parametar.equals("Tip korisnika")) {
            sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
        }
        sorter.setSortKeys(sortKeys);

        dijalog.dispose();
    }
}
