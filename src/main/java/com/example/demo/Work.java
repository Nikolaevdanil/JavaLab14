package com.example.demo;

import com.example.demo.components.Manufacture;
import com.example.demo.components.Worker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Work {

    private final List<Manufacture> manufactures = new ArrayList<>();
    private final List<Worker> workers = new ArrayList<>();

    public void saveManufacture(Manufacture manufacture) {
        if (!(manufactures.contains(manufacture))){
            manufactures.add(manufacture);
        }
    }
    public void saveWorker(Worker worker) {
        if (!(workers.contains(worker))){
            workers.add(worker);
        }
    }

    public void removeWorkers (int id){
        workers.remove(id);
    }

    public void removeManufactures (int id){
        manufactures.remove(id);;
    }

    public List<Manufacture> getManufactures(){
        return manufactures;
    }

    public List<Worker> getWorkers(){
        return workers;
    }

}
