package edu.neu.hm3.todolist.data;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ToDoItemRepository implements Iterable<ToDo> {
    private static List<ToDo> todoSet;

    private static ToDoItemRepository singleton;

    private ToDoItemRepository() {
        todoSet = new ArrayList<ToDo>();
        this.createFakeData();
    }

    public List<ToDo> asList() {
        return todoSet;
    }

    public static ToDoItemRepository getAllTodos() {
        if (singleton == null) {
            singleton = new ToDoItemRepository();
        }
        return singleton;
    }

    public static void addToDo(ToDo newToDo) {
        getAllTodos().todoSet.add(newToDo);
    }

    private void createFakeData() {
        todoSet.add(ToDo.createTodo("Task todo 1", "do something, already"));
        todoSet.add(ToDo.createTodo("Task todo 2", "and another thign!"));

    }

    @NonNull
    @Override
    public Iterator<ToDo> iterator() {
        return todoSet.iterator();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void forEach(@NonNull Consumer<? super ToDo> action) {
        todoSet.forEach(action);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    public Spliterator<ToDo> spliterator() {
        return todoSet.spliterator();
    }
}
