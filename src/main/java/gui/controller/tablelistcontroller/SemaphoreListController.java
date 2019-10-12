package gui.controller.tablelistcontroller;

import gui.model.date.Semaphore;
import gui.model.date.datamodel.SemaphoreModel;
import gui.view.MainWindowView;


public class SemaphoreListController extends ManageQueue {

    protected SemaphoreModel semaphoreModel;

    protected SemaphoreListController() {
    }

    public static SemaphoreListController create(SemaphoreModel semaphoreModel) {

        if (semaphoreModel == null)
            return null;

        SemaphoreListController semaphoreListController = new SemaphoreListController();
        semaphoreListController.semaphoreModel = semaphoreModel;
        return semaphoreListController;
    }

    public void controll(Semaphore semaphore) {
        if (semaphore.getStatus().equalsIgnoreCase("SEMWAIT")) {
            sewaitFunction(semaphore);
        } else if (semaphore.getStatus().equalsIgnoreCase("SEMACQUIRE")) {
            semacquireFunction(semaphore);
        } else if (semaphore.getStatus().equalsIgnoreCase("SEMPOST")) {
            sempostFunction(semaphore);
        }
    }

    public void sewaitFunction(Semaphore semaphore) {
        for (int i = 0; i < semaphoreModel.listSize(); i++) {
            Semaphore item = semaphoreModel.getElementByIndex(i);
            if (item.getAddress().equals(semaphore.getAddress())) {
                if (item.getCounter() == 0)
                    semaphoreModel.updateElementQueue(i, addElement(item.getQueue(), semaphore.getThreadId()));
                else
                    semaphoreModel.updateElementCounter(i, (item.getCounter() - 1));
                reloadData();
                return;
            }
        }
        if (semaphore.getCounter() == 0)
            semaphore.setQueue(String.valueOf(semaphore.getThreadId()));
        semaphoreModel.addElement(semaphore);
    }

    public void semacquireFunction(Semaphore semaphore) {
        for (int i = 0; i < semaphoreModel.listSize(); i++) {
            Semaphore item = semaphoreModel.getElementByIndex(i);
            if (item.getAddress().equals(semaphore.getAddress())) {
                if (!item.getQueue().isEmpty()) {
                    if (item.getCounter() > 0)
                        semaphoreModel.updateElementCounter(i, (item.getCounter() - 1));
                    semaphoreModel.updateElementQueue(i, calculateNewQueue(item.getQueue()));
                }
                reloadData();
            }
        }
    }

    public void sempostFunction(Semaphore semaphore) {
        for (int i = 0; i < semaphoreModel.listSize(); i++) {
            Semaphore item = semaphoreModel.getElementByIndex(i);
            if (item.getAddress().equalsIgnoreCase(semaphore.getAddress())) {
                semaphoreModel.updateElementCounter(i, (item.getCounter() + 1));
                reloadData();
                return;
            }
        }
        semaphore.setCounter(semaphore.getCounter() + 1);
        semaphoreModel.addElement(semaphore);
    }

    protected void reloadData() {
        MainWindowView.semaphoreTable.getTableView().refresh();
    }
}
