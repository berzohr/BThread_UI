package gui.model.date.datamodel;

import gui.model.date.Lock;
import gui.model.date.MyData;

import java.util.List;

public class LockModel extends MyData {

    protected List<Lock> lockList;

    protected LockModel() {
    }

    public static LockModel create(List<Lock> lockList) {

        if (lockList == null)
            return null;

        LockModel lockModel = new LockModel();
        lockModel.lockList = lockList;
        return lockModel;
    }

    public void addElement(Lock lock) {
        lockList.add(lock);
    }

    public void deleteElement(int i) {
        lockList.remove(i);
    }

    public void updateElementStatus(int i, String status) {
        lockList.get(i).setStatus(status);
    }

    public int listSize() {
        return lockList.size();
    }

    public Lock getElementByIndex(int i) {
        return lockList.get(i);
    }

}