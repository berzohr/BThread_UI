package gui.mediator;

import gui.controller.tablelistcontroller.*;
import gui.event.myDataEvent.*;
import gui.model.date.*;
import gui.model.date.datamodel.*;
import lombok.Setter;

import java.util.Observable;
import java.util.Observer;

@Setter
public class EventMediator implements Observer {

    protected StatusListController statusListController;
    protected LockListController lockListController;
    protected MutexListController mutexListController;
    protected SemaphoreListController semaphoreListController;
    protected BarrierListController barrierListController;
    protected ConditionListController conditionListController;
    protected GanttListController ganttListController;

    protected EventMediator() {
    }

    public static EventMediator create(StatusModel statusModel, LockModel lockModel, MutexModel mutexModel, SemaphoreModel semaphoreModel,
                                       BarrierModel barrierModel, ConditionModel conditionModel, GanttModel ganttModel) {

        if (statusModel == null)
            return null;
        if (lockModel == null)
            return null;
        if (mutexModel == null)
            return null;
        if (semaphoreModel == null)
            return null;
        if (barrierModel == null)
            return null;
        if (conditionModel == null)
            return null;
        if (ganttModel == null)
            return null;

        EventMediator eventMediator = new EventMediator();
        eventMediator.statusListController = StatusListController.create(statusModel);
        eventMediator.lockListController = LockListController.create(lockModel);
        eventMediator.mutexListController = MutexListController.create(mutexModel);
        eventMediator.semaphoreListController = SemaphoreListController.create(semaphoreModel);
        eventMediator.barrierListController = BarrierListController.create(barrierModel);
        eventMediator.conditionListController = ConditionListController.create(conditionModel);
        return eventMediator;
    }

    @Override
    public void update(Observable o, Object event) {
        if (event instanceof MutexEvent) {
            mutexListController.controll((Mutex) ((MutexEvent) event).getData());
        } else if (event instanceof SemaphoreEvent) {
            semaphoreListController.controll((Semaphore) ((SemaphoreEvent) event).getData());
        } else if (event instanceof BarrierEvent) {
            barrierListController.controll((Barrier) ((BarrierEvent) event).getData());
        } else if (event instanceof ConditionEvent) {
            conditionListController.controll((Condition) ((ConditionEvent) event).getData());
        } else if (event instanceof StatusEvent) {
            statusListController.controll((Status) ((StatusEvent) event).getData());
        } else if (event instanceof LockEvent) {
            lockListController.controll((Lock) ((LockEvent) event).getData());
        } else if (event instanceof GanttEvent) {
            ganttListController.controll((Gantt) ((GanttEvent) event).getData());
        }
    }
}
