package gui.view.table;

import gui.model.date.Mutex;
import gui.style.Style;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.NoArgsConstructor;

public class MutexTable {

    protected TableView<Mutex> tableView;

    protected MutexTable() {
    }

    public static MutexTable create(ObservableList list) {

        if (list == null)
            return null;

        MutexTable mutexTable = new MutexTable();
        mutexTable.tableView = new TableView<>();
        mutexTable.tableView.setItems(list);

        TableColumn mutexColumn = new TableColumn("MUTEX");
        TableColumn threadColumn = new TableColumn("THREAD");
        TableColumn queueColumn = new TableColumn("QUEUE");

        mutexColumn.setCellValueFactory(new PropertyValueFactory<Mutex, String>("address"));
        threadColumn.setCellValueFactory(new PropertyValueFactory<Mutex, Integer>("threadId"));
        queueColumn.setCellValueFactory(new PropertyValueFactory<Mutex, String>("queue"));

        mutexColumn.prefWidthProperty().bind(mutexTable.tableView.widthProperty().multiply(0.4));
        threadColumn.prefWidthProperty().bind(mutexTable.tableView.widthProperty().multiply(0.4));
        queueColumn.prefWidthProperty().bind(mutexTable.tableView.widthProperty().multiply(0.2));

        mutexTable.tableView.getStyleClass().add("tableView");
        mutexTable.tableView.getStylesheets().add(Style.getCSS());

        mutexTable.tableView.getColumns().addAll(mutexColumn, threadColumn, queueColumn);
        mutexTable.tableView.setEditable(false);
        return mutexTable;
    }

    public TableView<Mutex> getTableView() {
        return tableView;
    }
}
