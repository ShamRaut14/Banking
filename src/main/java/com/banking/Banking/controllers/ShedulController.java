package com.banking.Banking.controllers;

import com.banking.Banking.dto.SchedulDto;
import com.banking.Banking.entity.Schedule;
import com.banking.Banking.exceptionhandler.ApiResponse;
import com.banking.Banking.servises.SchedulServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShedulController {
    @Autowired
    private SchedulServise schedulServise;


    @PostMapping("/save-schedul")
    public ResponseEntity<?> saveSchedul(@RequestBody Schedule schedule) {
        // Create a new Schedul object and save it
        try {
            schedulServise.saveShedule(schedule);
            return ResponseEntity.ok(new ApiResponse("Schedule created successfully!", "true"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), "false"));
        }
    }
    @GetMapping("/getByScheduleId/{scheduleId}")
    public ResponseEntity<?> getScheduleByScheduleId(@PathVariable Long scheduleId) {


        try {
            SchedulDto schedulDto = schedulServise.getScheduleByScheduleId(scheduleId);
            //System.out.println("Schedule Data: " + schedulDto);
            if (schedulDto == null) {
                return new ResponseEntity<>(new ApiResponse("Data not found", "false"), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(schedulDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse("Error fetching data", "false"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all-schedule-ids")
    public ResponseEntity<List<SchedulDto>> getAllScheduleIds() {
        List<SchedulDto> schedules = schedulServise.getAllSchedule();
        schedules.forEach(schedule -> {
            //System.out.println("Schedule ID: " + schedule.getScheduleId() + ", Name: " + schedule.getName());
        });
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/allSchedule")
    public ResponseEntity<List<SchedulDto>> getAllSchedulelist() {
        List<SchedulDto> Schedules = schedulServise.getAllSchedule();
        return ResponseEntity.ok(Schedules);
    }
}
