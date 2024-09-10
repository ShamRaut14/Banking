package com.banking.Banking.repo;

import com.banking.Banking.dto.SchedulDto;
import com.banking.Banking.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepo extends JpaRepository<Schedule,Long> {
    Optional<Schedule> findTopByOrderByScheduleIdDesc();

    Schedule findByScheduleId(Long scheduleId);
    @Query("SELECT s.scheduleId FROM Schedule s")
    List<SchedulDto> findAllScheduleIds();

    boolean existsByScheduleId(Integer scheduleId);
}
