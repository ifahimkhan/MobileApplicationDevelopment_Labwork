package com.fahim.mobileapplicationdevelopment_labwork;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskRepository {

    private TaskDao taskDao;
    private LiveData<List<Task>> allTasks;
    private Future<LiveData<List<Task>>> liveDataFuture;
    private ExecutorService executorService;


    public TaskRepository(Application application) {
        executorService = Executors.newSingleThreadExecutor();
        TaskDatabase database = TaskDatabase.getInstance(application);
        taskDao = database.taskDao();
        allTasks = taskDao.getAllTasks();

    }


    public void insert(Task task) {
        executorService.execute(() -> taskDao.insert(task));
    }

    public void update(Task task) {
        executorService.execute(() -> taskDao.update(task));
    }

    public void delete(Task task) {
        executorService.execute(() -> taskDao.delete(task));
    }

    public void deleteAllTasks() {
        executorService.execute(() -> taskDao.deleteAllTasks());
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }

}
