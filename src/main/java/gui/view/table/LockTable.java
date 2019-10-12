package gui.view.table;

import gui.model.date.Lock;
import gui.style.Style;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LockTable {

    protected TableView<Lock> tableView;

    protected LockTable() {
    }

    public static LockTable create(ObservableList list) {

        if (list == null)
            return null;

        LockTable lockTable = new LockTable();
        lockTable.tableView = new TableView<>();
        lockTable.tableView.setItems(list);
        lockTable.tableView.setEditable(false);
        TableColumn threadColumn = new TableColumn("THREAD");
        TableColumn lockStatusTable = new TableColumn("LOCK STATUS");
        lockTable.tableView.getColumns().addAll(threadColumn, lockStatusTable);

        threadColumn.prefWidthProperty().bind(lockTable.tableView.widthProperty().multiply(0.5));
        lockStatusTable.prefWidthProperty().bind(lockTable.tableView.widthProperty().multiply(0.5));

        threadColumn.setCellValueFactory(new PropertyValueFactory<Lock, Integer>("threadId"));
        lockStatusTable.setCellValueFactory(new PropertyValueFactory<Lock, String>("status"));

        lockTable.tableView.getStyleClass().add("tableView");
        lockTable.tableView.getStylesheets().add(Style.getCSS());
        return lockTable;
    }

    public TableView<Lock> getTableView() {
        return tableView;
    }
}