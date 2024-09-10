package com.banking.Banking.serviceImpl;

import com.banking.Banking.dto.SchedulDto;
import com.banking.Banking.entity.Schedule;
import com.banking.Banking.repo.ScheduleRepo;
import com.banking.Banking.servises.SchedulServise;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShedulServiceImpl implements SchedulServise {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ScheduleRepo scheduleRepo;

    @Override
    public void saveShedule(Schedule schedule) {
        if (scheduleRepo.existsByScheduleId(schedule.getScheduleId())) {
            throw new IllegalArgumentException("Schedule with scheduleId " + schedule.getScheduleId() + " already exists.");
        }
         scheduleRepo.save(schedule);
    }

    @Override
    public int getNextScheduleId() {
        Optional<Schedule> lastSchedule = scheduleRepo.findTopByOrderByScheduleIdDesc();
        return lastSchedule.map(schedule -> schedule.getScheduleId() + 1).orElse(1);
    }

    @Override
    public SchedulDto getScheduleByScheduleId(Long scheduleId) {
        Schedule schedule = scheduleRepo.findByScheduleId(scheduleId);

        return modelMapper.map(schedule, SchedulDto.class);
    }

//    @Override
//    public List<Long> getAllScheduleIds() {
//        return scheduleRepo.findAllScheduleIds();
//    }

    @Override
    public List<SchedulDto> getAllSchedule() {
        List<Schedule> Schedules =this.scheduleRepo.findAll();
        return Schedules.stream()
                .map(Schedule -> modelMapper.map(Schedule, SchedulDto.class))
                .collect(Collectors.toList());
    }


}
