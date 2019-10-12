package gui.model.date.datamodel;


import gui.model.date.MyData;
import gui.model.date.Status;

import java.util.List;

public class StatusModel extends MyData {

    protected List<Status> statusList;

    protected StatusModel() {
    }

    public static StatusModel create(List<Status> statusList) {

        if (statusList == null)
            return null;

        StatusModel statusModel = new StatusModel();
        statusModel.statusList = statusList;
        return statusModel;
    }

    public void addElement(Status status) {
        statusList.add(status);
    }

    public void deleteElement(int i) {
        statusList.remove(i);
    }

    public void updateElementStatus(int i, String status) {
        statusList.get(i).setStatus(status);
    }

    public int listSize() {
        return statusList.size();
    }

    public Status getElementByIndex(int i) {
        return statusList.get(i);
    }
}