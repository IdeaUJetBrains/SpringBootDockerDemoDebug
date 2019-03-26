package rest;

import entity.Entitybus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rep.EntitybusRepository;

import java.util.Random;

@RestController
@RequestMapping("/entitybus")
public class EntitybusController {
    @Autowired
    private EntitybusRepository entitybusRepository;

    @GetMapping
    public Iterable findAll1() {
        return entitybusRepository.findAll();
    }

    @RequestMapping("/post")
    public Iterable postEntity() {
        Entitybus o = new Entitybus();
        int num = (int) (Math.random()*10);
        o.setEid(num);
        o.setEnumber("blah" + num);
        entitybusRepository.save(o);
        return entitybusRepository.findAll();
    }


}