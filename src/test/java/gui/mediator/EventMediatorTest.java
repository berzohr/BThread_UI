package gui.mediator;


import gui.controller.tablelistcontroller.*;
import gui.event.myDataEvent.*;
import gui.event.myDataEvent.MyDataEvent;
import gui.model.date.datamodel.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Observable;

import static org.junit.Assert.*;


public class EventMediatorTest {

    private StatusListController statusListController;
    private LockListController lockListController;
    private MutexListController mutexListController;
    private SemaphoreListController semaphoreListController;
    private BarrierListController barrierListController;
    private ConditionListController conditionListController;
    private GanttListController ganttListController;

    private StatusModel statusModel;
    private LockModel lockModel;
    private MutexModel mutexModel;
    private SemaphoreModel semaphoreModel;
    private BarrierModel barrierModel;
    private ConditionModel conditionModel;
    private GanttModel ganttModel;

    private EventMediator eventMediator;

    @Before
    public void setUp() {
        statusListController = Mockito.mock(StatusListController.class);
        lockListController = Mockito.mock(LockListController.class);
        mutexListController = Mockito.mock(MutexListController.class);
        semaphoreListController = Mockito.mock(SemaphoreListController.class);
        barrierListController = Mockito.mock(BarrierListController.class);
        conditionListController = Mockito.mock(ConditionListController.class);
        ganttListController = Mockito.mock(GanttListController.class);

        statusModel = Mockito.mock(StatusModel.class);
        lockModel = Mockito.mock(LockModel.class);
        mutexModel = Mockito.mock(MutexModel.class);
        semaphoreModel = Mockito.mock(SemaphoreModel.class);
        barrierModel = Mockito.mock(BarrierModel.class);
        conditionModel = Mockito.mock(ConditionModel.class);
        ganttModel = Mockito.mock(GanttModel.class);

        eventMediator = EventMediator.create(statusModel, lockModel, mutexModel, semaphoreModel, barrierModel, conditionModel, ganttModel);
    }

    @Test
    public void create01() {
        assertNull(EventMediator.create(null, lockModel, mutexModel, semaphoreModel, barrierModel, conditionModel, ganttModel));
        assertNull(EventMediator.create(statusModel, null, mutexModel, semaphoreModel, barrierModel, conditionModel, ganttModel));
        assertNull(EventMediator.create(statusModel, lockModel, null, semaphoreModel, barrierModel, conditionModel, ganttModel));
        assertNull(EventMediator.create(statusModel, lockModel, mutexModel, null, barrierModel, conditionModel, ganttModel));
        assertNull(EventMediator.create(statusModel, lockModel, mutexModel, semaphoreModel, null, conditionModel, ganttModel));
        assertNull(EventMediator.create(statusModel, lockModel, mutexModel, semaphoreModel, barrierModel, null, ganttModel));
        assertNull(EventMediator.create(statusModel, lockModel, mutexModel, semaphoreModel, barrierModel, conditionModel, null));
    }


    @Test
    public void create06() {
        assertNotNull(eventMediator);
    }

    @Test
    public void setMutexListController() {
        eventMediator.setMutexListController(mutexListController);
        assertEquals(mutexListController, eventMediator.mutexListController);
    }

    @Test
    public void setSemaphoreListController() {
        eventMediator.setSemaphoreListController(semaphoreListController);
        assertEquals(semaphoreListController, eventMediator.semaphoreListController);
    }

    @Test
    public void setBarrierListController() {
        eventMediator.setBarrierListController(barrierListController);
        assertEquals(barrierListController, eventMediator.barrierListController);
    }

    @Test
    public void setConditionListController() {
        eventMediator.setConditionListController(conditionListController);
        assertEquals(conditionListController, eventMediator.conditionListController);
    }

    @Test
    public void setStatusListController() {
        eventMediator.setStatusListController(statusListController);
        assertEquals(statusListController, eventMediator.statusListController);
    }

    @Test
    public void setLockonditionListController() {
        eventMediator.setLockListController(lockListController);
        assertEquals(lockListController, eventMediator.lockListController);
    }


    //TODO: fix these two tests
    @Test
    public void update01() {
        Observable observable = Mockito.mock(Observable.class);
        MyDataEvent mutexEvent = MutexEvent.create("(MUTACQUIRE) 2 0x345878");
        eventMediator.update(observable, mutexEvent);
        //Mockito.verify(mutexListController, Mockito.times(1)).controll((Mutex) mutexEvent.getData());
    }

    @Test
    public void update02() {
        Observable observable = Mockito.mock(Observable.class);
        MyDataEvent semaphoreEvent = SemaphoreEvent.create("(SEMPOST) 2 0x345878 1");
        eventMediator.update(observable, semaphoreEvent);
        //Mockito.verify(semaphoreListController, Mockito.times(1)).controll((Semaphore) semaphoreEvent.getData());
    }

    @Test
    public void update03() {
        Observable observable = Mockito.mock(Observable.class);
        MyDataEvent barrierEvent = BarrierEvent.create("(BARRIERWAIT) 2 0x107b4c198 1 9");
        eventMediator.update(observable, barrierEvent);
        //Mockito.verify(barrierListController, Mockito.times(1)).controll((Barrier) barrierEvent.getData());
    }

    @Test
    public void update04() {
        Observable observable = Mockito.mock(Observable.class);
        MyDataEvent conditionEvent = ConditionEvent.create("(CONDSIGNAL) 2 0x345878 1");
        //eventMediator.update(observable, conditionEvent);
        //Mockito.verify(conditionListController, Mockito.times(1)).controll((Condition) conditionEvent.getData());
    }

    @Test
    public void update05() {
        Observable observable = Mockito.mock(Observable.class);
        MyDataEvent statusEvent = StatusEvent.create("(CREATE) 2 ");
        //eventMediator.update(observable, conditionEvent);
        //Mockito.verify(statusListController, Mockito.times(1)).controll((Status) statusEvent.getData());
    }

    @Test
    public void update06() {
        Observable observable = Mockito.mock(Observable.class);
        MyDataEvent lockEvent = LockEvent.create("(SCHEDULING) 5");
        //eventMediator.update(observable, conditionEvent);
        //Mockito.verify(lockListController, Mockito.times(1)).controll((Lock) lockEvent.getData());
    }
}
