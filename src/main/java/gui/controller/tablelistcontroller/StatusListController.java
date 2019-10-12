package gui.controller.tablelistcontroller;

import gui.model.date.Status;
import gui.model.date.datamodel.StatusModel;
import gui.view.MainWindowView;
import javafx.collections.ObservableList;

public class StatusListController {

    protected StatusModel statusModel;

    protected StatusListController() {
    }

    public static StatusListController create(StatusModel statusModel) {

        if (statusModel == null)
            return null;

        StatusListController statusListController = new StatusListController();
        statusListController.statusModel = statusModel;
        return statusListController;
    }

    public void controll(Status status) {
        if (status != null) {
            String statusValue = status.getStatus();
            if (statusValue.equalsIgnoreCase("CREATE")) {
                addElementToStatusList(status);
            } else if (statusValue.equalsIgnoreCase("READY") || statusValue.equalsIgnoreCase("YIELD")) {
                updateValueList(status, "READY");
            } else if (statusValue.equalsIgnoreCase("SLEEPING")) {
                updateValueList(status, "SLEEPING");
            } else if (statusValue.contains("BLOCKED")) {
                updateValueList(status, "BLOCKED");
            } else if (statusValue.equalsIgnoreCase("EXIT") || statusValue.equalsIgnoreCase("DESTROY")) {
                updateValueList(status, "EXIT");
            } else if (statusValue.equalsIgnoreCase("SCHEDULING")) {
                updateValueList(status, "RUNNING");
            }
        }
    }

    protected void updateValueList(Status status, String value) {
        for (int i = 0; i < statusModel.listSize(); i++) {
            Status element = statusModel.getElementByIndex(i);
            if (element.getThreadId() == status.getThreadId()) {
                statusModel.updateElementStatus(i, value);
                reloadData();
            }
        }
    }

    protected void addElementToStatusList(Status status) {
        statusModel.addElement(status);
    }

    protected void reloadData() {
        MainWindowView.tableView.getTableView().refresh();
    }
}