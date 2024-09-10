package com.banking.Banking.servises;

import com.banking.Banking.dto.CustomerDto;
import com.banking.Banking.dto.SchedulDto;
import com.banking.Banking.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface SchedulServise {
  void saveShedule(Schedule schedule);
  int getNextScheduleId();

  SchedulDto getScheduleByScheduleId(Long scheduleId);
 // List<SchedulDto> getAllScheduleIds();

    List<SchedulDto> getAllSchedule();
}
