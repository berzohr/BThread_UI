package gui.controller.tablelistcontroller;

import gui.model.date.Barrier;
import gui.model.date.datamodel.BarrierModel;
import gui.view.MainWindowView;

public class BarrierListController extends ManageQueue {

    protected BarrierModel barrierModel;

    protected BarrierListController() {
    }

    public static BarrierListController create(BarrierModel barrierModel) {
        if (barrierModel == null)
            return null;

        BarrierListController barrierListController = new BarrierListController();
        barrierListController.barrierModel = barrierModel;
        return barrierListController;
    }

    public void controll(Barrier barrier) {
        String status = barrier.getStatus();
        if (status.equalsIgnoreCase("BARRIERWAIT")) {
            barrierWaitfunction(barrier);
        } else if (status.equalsIgnoreCase("BARRIERUNLOCK")) {
            barrierUnlockFunction(barrier);
        }

    }

    protected void barrierUnlockFunction(Barrier barrier) {
        for (int i = 0; i < barrierModel.listSize(); i++) {
            Barrier element = barrierModel.getElementByIndex(i);
            if (element.getAddress().equalsIgnoreCase(barrier.getAddress())) {
                if (barrier.getSize() == barrier.getCounter()) {
                    barrierModel.updateElementQueue(i, null);
                    barrierModel.updateElementCounter(i, 0);
                    reloadData();
                }
            }
        }

    }


    protected void barrierWaitfunction(Barrier barrier) {
        for (int i = 0; i < barrierModel.listSize(); i++) {
            Barrier element = barrierModel.getElementByIndex(i);
            if (element.getAddress().equalsIgnoreCase(barrier.getAddress())) {
                barrierModel.updateElementQueue(i, addElement(element.getQueue(), barrier.getThreadId()));
                barrierModel.updateElementCounter(i, barrier.getCounter());
                reloadData();
                return;
            }
        }
        barrierModel.addElement(barrier);
    }

    protected void reloadData() {
        MainWindowView.barrierTable.getTableView().refresh();
    }
}

