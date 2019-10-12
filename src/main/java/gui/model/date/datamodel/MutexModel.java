package gui.model.date.datamodel;

import gui.model.date.Mutex;
import gui.model.date.MyData;

import java.util.List;

public class MutexModel extends MyData {

    protected List<Mutex> mutexList;

    protected MutexModel() {
    }

    public static MutexModel create(List<Mutex> mutexList) {

        if (mutexList == null)
            return null;

        MutexModel mutexModel = new MutexModel();
        mutexModel.mutexList = mutexList;
        return mutexModel;
    }

    public void addElement(Mutex mutex) {
        mutexList.add(mutex);
    }

    public void deleteElement(int i) {
        mutexList.remove(i);
    }

    public void updateElementQueue(int i, String queue) {
        mutexList.get(i).setQueue(queue);
    }

    public int listSize() {
        return mutexList.size();
    }

    public Mutex getElementByIndex(int index) {
        return mutexList.get(index);
    }
}
