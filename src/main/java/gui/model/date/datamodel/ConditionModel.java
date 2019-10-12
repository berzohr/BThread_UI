package gui.model.date.datamodel;

import gui.model.date.Condition;
import gui.model.date.MyData;

import java.util.List;

public class ConditionModel extends MyData {

    protected List<Condition> conditionList;

    protected ConditionModel() {
    }

    public static ConditionModel create(List<Condition> conditionList) {

        if (conditionList == null)
            return null;

        ConditionModel conditionModel = new ConditionModel();
        conditionModel.conditionList = conditionList;
        return conditionModel;
    }

    public void addElement(Condition condition) {
        conditionList.add(condition);
    }

    public void deleteElement(int i) {
        conditionList.remove(i);
    }

    public void updateElementQueue(int i, String queue) {
        conditionList.get(i).setQueue(queue);
    }

    public int listSize() {
        return conditionList.size();
    }

    public Condition getElementByIndex(int i) {
        return conditionList.get(i);
    }
}

