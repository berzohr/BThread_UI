package gui.event.myDataEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyDataEventFactory {

    protected MyDataEventFactory() {
    }

    public static MyDataEvent create(String name, String line) {

        if (name == null)
            return null;

        if (line == null)
            return null;

        Class c;
        MyDataEvent myDataEvent = null;

        try {
            c = Class.forName("gui.event.myDataEvent." + name);
            Method method = c.getMethod("create", String.class);
            myDataEvent = (MyDataEvent) method.invoke(method, line);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return myDataEvent;
    }
}
