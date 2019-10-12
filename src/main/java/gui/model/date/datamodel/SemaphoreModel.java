package gui.model.date.datamodel;

import gui.model.date.MyData;
import gui.model.date.Semaphore;

import java.util.List;

public class SemaphoreModel extends MyData {

    protected List<Semaphore> semaphoreList;

    protected SemaphoreModel() {
    }

    public static SemaphoreModel create(List<Semaphore> semaphoreList) {

        if (semaphoreList == null)
            return null;

        SemaphoreModel semaphoreModel = new SemaphoreModel();
        semaphoreModel.semaphoreList = semaphoreList;
        return semaphoreModel;
    }

    public void addElement(Semaphore semaphore) {
        semaphoreList.add(semaphore);
    }

    public void deleteElement(int i) {
        semaphoreList.remove(i);
    }

    public void updateElementQueue(int i, String queue) {
        semaphoreList.get(i).setQueue(queue);
    }

    public void updateElementCounter(int i, int counterValue) {
        semaphoreList.get(i).setCounter(counterValue);
    }

    public int listSize() {
        return semaphoreList.size();
    }

    public Semaphore getElementByIndex(int i) {
        return semaphoreList.get(i);
    }
}
