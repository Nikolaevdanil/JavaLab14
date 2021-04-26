package com.example.demo;

import com.example.demo.components.Manufacture;
import com.example.demo.components.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {
    @Autowired
    private Work ManufactureWork;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/home/show")
    public @ResponseBody String show(){
        String buff = "<h>Производство</h><table border=1>";
        int i = 0;
        for (Manufacture item:ManufactureWork.getManufactures()) {
            buff += "<tr><td>" + item.getName() + "</td><td>" + item.getAddress() + "</td><td><a href='removeManufacture?id=" + i + "'>Delete</a></td></tr>";
            i++;
        }
        if (i == 0)
        {
            buff+= "<tr><td>Список производств пуст</td></tr>";
        }
        i = 0;
        buff += "</table>";
        buff += "<h></h>Работники<table border=1>";
        for (Worker item:ManufactureWork.getWorkers()) {
            buff += "<tr><td>" + item.getFirstName() + "</td><td>" + item.getLastName()+ "</td><td>" + item.getMiddleName() + "</td><td><a href='removeWorker?id=" + i + "'>Delete</a></td></tr>";
            i++;
        }
        if (i == 0)
        {
            buff+= "<tr><td>Список работников пуст</td></tr>";
        }
        buff += "</table>";
        return buff;
    }

    @PostMapping("/home/addManufacture")
    public String add(@RequestParam String name,
                      @RequestParam String address){
        Manufacture manufacture = new Manufacture();
        manufacture.setName(name);
        manufacture.setAddress(address);
        ManufactureWork.saveManufacture(manufacture);
        return "home";
    }
    @PostMapping("/home/addWorker")
    public String add(@RequestParam String firstName,
                      @RequestParam String lastName,
                      @RequestParam String middleName){
        Worker worker = new Worker();
        worker.setFirstName(firstName);
        worker.setLastName(lastName);
        worker.setMiddleName(middleName);
        ManufactureWork.saveWorker(worker);
        return "home";
    }
    @GetMapping("/home/removeWorker")
    public @ResponseBody String removeWorker(@RequestParam int id){
        ManufactureWork.removeWorkers(id);
        return show();
    }
    @GetMapping("/home/removeManufacture")
    public @ResponseBody String removeManufactur(@RequestParam int id){
        ManufactureWork.removeManufactures(id);
        return show();
    }

}
