package gui.view.table;

import gui.model.date.Semaphore;
import gui.style.Style;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SemaphoreTable {

    protected TableView<Semaphore> tableView;

    protected SemaphoreTable() {
    }

    public static SemaphoreTable create(ObservableList list) {

        if (list == null)
            return null;

        SemaphoreTable semaphoreTable = new SemaphoreTable();
        semaphoreTable.tableView = new TableView<>();
        semaphoreTable.tableView.setItems(list);

        TableColumn semaphoreColumn = new TableColumn("MUTEX");
        TableColumn counterColumn = new TableColumn("COUNTER");
        TableColumn queueColumn = new TableColumn("QUEUE");

        semaphoreColumn.setCellValueFactory(new PropertyValueFactory<Semaphore, String>("address"));
        counterColumn.setCellValueFactory(new PropertyValueFactory<Semaphore, Integer>("counter"));
        queueColumn.setCellValueFactory(new PropertyValueFactory<Semaphore, String>("queue"));

        semaphoreColumn.prefWidthProperty().bind(semaphoreTable.tableView.widthProperty().multiply(0.4));
        counterColumn.prefWidthProperty().bind(semaphoreTable.tableView.widthProperty().multiply(0.2));
        queueColumn.prefWidthProperty().bind(semaphoreTable.tableView.widthProperty().multiply(0.4));

        semaphoreTable.tableView.getStyleClass().add("tableView");
        semaphoreTable.tableView.getStylesheets().add(Style.getCSS());

        semaphoreTable.tableView.getColumns().addAll(semaphoreColumn, counterColumn, queueColumn);
        semaphoreTable.tableView.setEditable(false);

        return semaphoreTable;
    }

    public TableView<Semaphore> getTableView() {
        return tableView;
    }
}
