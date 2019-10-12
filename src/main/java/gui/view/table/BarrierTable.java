package gui.view.table;

import gui.model.date.Barrier;
import gui.style.Style;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BarrierTable {

    protected TableView<Barrier> tableView;

    protected BarrierTable() {
    }

    public static BarrierTable create(ObservableList list) {

        if (list == null)
            return null;

        BarrierTable barrierTable = new BarrierTable();
        barrierTable.tableView = new TableView<>();
        barrierTable.tableView.setItems(list);

        TableColumn barrierColumn = new TableColumn("BARRIER");
        TableColumn counterColumn = new TableColumn("COUNTER");
        TableColumn queueColumn = new TableColumn("QUEUE");

        barrierColumn.setCellValueFactory(new PropertyValueFactory<Barrier, String>("address"));
        counterColumn.setCellValueFactory(new PropertyValueFactory<Barrier, Integer>("counter"));
        queueColumn.setCellValueFactory(new PropertyValueFactory<Barrier, String>("queue"));

        barrierColumn.prefWidthProperty().bind(barrierTable.tableView.widthProperty().multiply(0.4));
        counterColumn.prefWidthProperty().bind(barrierTable.tableView.widthProperty().multiply(0.2));
        queueColumn.prefWidthProperty().bind(barrierTable.tableView.widthProperty().multiply(0.4));

        barrierTable.tableView.getStyleClass().add("tableView");
        barrierTable.tableView.getStylesheets().add(Style.getCSS());

        barrierTable.tableView.getColumns().addAll(barrierColumn, counterColumn, queueColumn);
        barrierTable.tableView.setEditable(false);
        return barrierTable;
    }

    public TableView<Barrier> getTableView() {
        return tableView;
    }
}
