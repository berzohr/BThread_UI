package gui.view.table;

import gui.model.date.Status;
import gui.style.Style;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StatusTable {

    protected TableView<Status> tableView;

    protected StatusTable() {
    }

    public static StatusTable create(ObservableList list) {

        if (list == null)
            return null;

        StatusTable statusTable = new StatusTable();
        statusTable.tableView = new TableView<>();
        statusTable.tableView.setItems(list);

        TableColumn threadColumn = new TableColumn("THREAD");
        TableColumn statusColumn = new TableColumn("STATUS");

        threadColumn.setCellValueFactory(new PropertyValueFactory<Status, Integer>("threadId"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Status, String>("status"));

        threadColumn.prefWidthProperty().bind(statusTable.tableView.widthProperty().multiply(0.5));
        statusColumn.prefWidthProperty().bind(statusTable.tableView.widthProperty().multiply(0.5));

        statusTable.tableView.getStyleClass().add("tableView");
        statusTable.tableView.getStylesheets().add(Style.getCSS());

        statusTable.tableView.getColumns().addAll(threadColumn, statusColumn);
        statusTable.tableView.setEditable(false);
        return statusTable;
    }

    public TableView<Status> getTableView() {
        return tableView;
    }
}