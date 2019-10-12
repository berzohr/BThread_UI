package gui.controller.tablelistcontroller;

import gui.model.date.Mutex;
import gui.model.date.datamodel.MutexModel;
import gui.view.MainWindowView;

public class MutexListController extends ManageQueue {

    protected MutexModel mutexModel;

    protected MutexListController() {
    }

    public static MutexListController create(MutexModel mutexModel) {

        if (mutexModel == null)
            return null;

        MutexListController mutexListController = new MutexListController();
        mutexListController.mutexModel = mutexModel;
        return mutexListController;
    }

    public void controll(Mutex mutex) {
        if (mutex.getStatus().equalsIgnoreCase("MUTACQUIRE")) {
            mutacuireFunction(mutex);
        } else if (mutex.getStatus().equalsIgnoreCase("MUTRELEASE")) {
            mutreleaseFunction(mutex);
        }
    }

    protected void mutacuireFunction(Mutex mutex) {
        final int size = mutexModel.listSize();
        for (int i = 0; i < size; i++) {
            Mutex element = mutexModel.getElementByIndex(i);
            if (element.getAddress().equalsIgnoreCase(mutex.getAddress())) {
                if (element.getThreadId() == mutex.getThreadId())
                    return;
                mutexModel.updateElementQueue(i, addElement(element.getQueue(), mutex.getThreadId()));
                reloadData();
                return;
            }
        }
        mutexModel.addElement(mutex);
    }

    protected void mutreleaseFunction(Mutex mutex) {
        int size = mutexModel.listSize();
        for (int i = 0; i < size; i++) {
            Mutex element = mutexModel.getElementByIndex(i);
            if (element.getAddress().equalsIgnoreCase(mutex.getAddress())) {
                if (element.getThreadId() == mutex.getThreadId()) {
                    if (element.getQueue().isEmpty()) {
                        mutexModel.deleteElement(i);
                        size = mutexModel.listSize();
                    } else
                        mutexModel.updateElementQueue(i, calculateNewQueue(element.getQueue()));
                    reloadData();
                }
            }
        }
    }

    protected void reloadData() {
        MainWindowView.mutexTable.getTableView().refresh();
    }
}
