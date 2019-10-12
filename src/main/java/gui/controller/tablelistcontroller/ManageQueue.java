package gui.controller.tablelistcontroller;

public abstract class ManageQueue {

    public String addElement(String oldQueue, int element) {
        if (oldQueue.isEmpty())
            return String.valueOf(element);
        else {
            return (oldQueue + " , " + element);
        }
    }

    public String calculateNewQueue(String oldQueue) {
        String[] elementsQueue = oldQueue.split(" , ");
        StringBuilder newQueue = new StringBuilder();
        for (int j = 1; j < elementsQueue.length; j++) {
            newQueue.append(elementsQueue[j]);
            if (j != elementsQueue.length - 1) {
                newQueue.append(" , ");
            }
        }
        return String.valueOf(newQueue);
    }
}
