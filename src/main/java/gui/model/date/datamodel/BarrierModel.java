package gui.model.date.datamodel;

import gui.model.date.Barrier;
import gui.model.date.MyData;

import java.util.List;

public class BarrierModel extends MyData {

    protected List<Barrier> barrierList;

    protected BarrierModel() {
    }

    public static BarrierModel create(List<Barrier> barrierList) {

        if (barrierList == null)
            return null;

        BarrierModel barrierModel = new BarrierModel();
        barrierModel.barrierList = barrierList;
        return barrierModel;
    }

    public void addElement(Barrier barrier) {
        barrierList.add(barrier);
    }

    public void deleteElement(int i) {
        barrierList.remove(i);
    }

    public void updateElementQueue(int i, String queue) {
        barrierList.get(i).setQueue(queue);
    }

    public void updateElementCounter(int i, int counterValue) {
        barrierList.get(i).setCounter(counterValue);
    }

    public int listSize() {
        return barrierList.size();
    }

    public Barrier getElementByIndex(int i) {
        return barrierList.get(i);
    }
}
