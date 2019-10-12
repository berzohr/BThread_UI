package gui.view.table;

import gui.model.date.Condition;
import gui.style.Style;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConditionTable {

    protected TableView<Condition> tableView;

    protected ConditionTable() {
    }

    public static ConditionTable create(ObservableList list) {

        if (list == null)
            return null;

        ConditionTable conditionTable = new ConditionTable();
        conditionTable.tableView = new TableView<>();
        conditionTable.tableView.setItems(list);

        TableColumn conditionColumn = new TableColumn("CONDITION");
        TableColumn queueColumn = new TableColumn("QUEUE");

        conditionColumn.setCellValueFactory(new PropertyValueFactory<Condition, String>("address"));
        queueColumn.setCellValueFactory(new PropertyValueFactory<Condition, String>("queue"));

        conditionColumn.prefWidthProperty().bind(conditionTable.tableView.widthProperty().multiply(0.5));
        queueColumn.prefWidthProperty().bind(conditionTable.tableView.widthProperty().multiply(0.5));

        conditionTable.tableView.getStyleClass().add("tableView");
        conditionTable.tableView.getStylesheets().add(Style.getCSS());

        conditionTable.tableView.getColumns().addAll(conditionColumn, queueColumn);
        conditionTable.tableView.setEditable(false);

        return conditionTable;
    }

    public TableView<Condition> getTableView() {
        return tableView;
    }
}

