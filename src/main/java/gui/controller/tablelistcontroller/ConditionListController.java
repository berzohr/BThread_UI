package gui.controller.tablelistcontroller;


import gui.model.date.Condition;
import gui.model.date.datamodel.ConditionModel;
import gui.view.MainWindowView;

public class ConditionListController extends ManageQueue {

    protected ConditionModel conditionModel;

    protected ConditionListController() {
    }

    public static ConditionListController create(ConditionModel conditionModel) {

        if (conditionModel == null)
            return null;

        ConditionListController conditionListController = new ConditionListController();
        conditionListController.conditionModel = conditionModel;
        return conditionListController;
    }

    public void controll(Condition condition) {
        String status = condition.getStatus();
        if (status.equalsIgnoreCase("CONDSIGNAL")) {
            condsignalFunction(condition);
        } else if (status.equalsIgnoreCase("CONDBROADCAST")) {
            condbroadcastFunction(condition);
        } else if (status.equalsIgnoreCase("CONDBLOCKED")) {
            condblockedFunction(condition);
        }
    }

    protected void condblockedFunction(Condition condition) {
        for (int i = 0; i < conditionModel.listSize(); i++) {
            Condition element = conditionModel.getElementByIndex(i);
            if (element.getAddress().equalsIgnoreCase(condition.getAddress())) {
                conditionModel.updateElementQueue(i, addElement(element.getQueue(), condition.getThreadId()));
                reloadData();
                return;
            }
        }
        condition.setQueue(addElement(condition.getQueue(), condition.getThreadId()));
        conditionModel.addElement(condition);
    }

    protected void condbroadcastFunction(Condition condition) {
        for (int i = 0; i < conditionModel.listSize(); i++) {
            Condition element = conditionModel.getElementByIndex(i);
            if (element.getAddress().equalsIgnoreCase(condition.getAddress())) {
                conditionModel.updateElementQueue(i, null);
                reloadData();
            }
        }
    }

    protected void condsignalFunction(Condition condition) {
        for (int i = 0; i < conditionModel.listSize(); i++) {
            Condition element = conditionModel.getElementByIndex(i);
            if (element.getAddress().equalsIgnoreCase(condition.getAddress())) {
                conditionModel.updateElementQueue(i, calculateNewQueue(element.getQueue()));
                reloadData();
            }
        }
    }

    protected void reloadData() {
        MainWindowView.conditionTable.getTableView().refresh();
    }
}
