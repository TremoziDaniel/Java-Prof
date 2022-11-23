package lesson6;

import sun.java2d.pipe.SpanShapeRenderer;

public class SimpleBox<T> {
    private T obj;
    public SimpleBox(T obj) {
        this.obj = obj;
    }

    public T getObject() {
        return obj;
    }

    public void setObject(T obj) {
        this.obj = obj;
    }
}
