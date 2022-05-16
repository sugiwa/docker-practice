package com.example.demo.db_test.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:8081/"})
public class ScheduleController {
    
    @Autowired
    ScheduleRepository repository;

    @RequestMapping(value = "/api/schedules", method = RequestMethod.GET)
    public List<Schedule> getAllSchedules() {
        List<Schedule> scheduleList = repository.findAll();
        return scheduleList;
    }

    @RequestMapping(value = "/api/schedules/users/{userId}", method = RequestMethod.GET)
    public List<Schedule> getUserSchedule(@PathVariable("userId") int userId){
        List<Schedule> scheduleList = repository.findByUserId(userId);
        return scheduleList;
    }

    @RequestMapping(value = "/api/schdules", method = RequestMethod.POST)
    public Schedule createSchedule(@RequestBody ScheduleForm form){
        Schedule schedule = new Schedule();

        schedule.setUser_id(form.getUser_id());
        schedule.setTitle(form.getTitle());
        schedule.setContent(form.getContent());
        schedule.setStarted_at(form.getStarted_at());
        schedule.setFinished_at(form.getFinished_at());
        repository.save(schedule);

        return schedule;
    }
}
