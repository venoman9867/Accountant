package com.kurkin.accountant.repository;

import com.kurkin.accountant.model.ReportDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReportRepository extends CrudRepository<ReportDAO, Long> {
    @Query("select dao from Report dao where DATE_PART('day',current_date-dao.timeOfTrack) >= 1")
    List<ReportDAO> getListOfNonReportedTasks();

    @Query("select dao from Report dao where DATE_PART('day',current_date-dao.timeOfTrack) >= :?")
    List<String> getListByDays(int day);
}

