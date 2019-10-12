package gui.model.date;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyDataFactory {

    protected MyDataFactory() {
    }

    public static MyData create(final String name, final String line) {

        if (name == null)
            return null;

        if (line == null)
            return null;

        Class c;
        MyData data = null;

        try {
            c = Class.forName("gui.model.date." + name);
            Method method = c.getMethod("create", String.class);
            data = (MyData) method.invoke(method, line);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return data;
    }
}
