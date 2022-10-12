package com.kurkin.accountant.controller;

import com.kurkin.accountant.model.Report;
import com.kurkin.accountant.model.ReportDAO;
import com.kurkin.accountant.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportRepository repository;

    @GetMapping("nonReportedTasks")
    public Object nonReportedTasks() {
        return repository.getListOfNonReportedTasks();
    }

    @GetMapping("withoutThreeTrack")
    public Object withoutThreeTrack() {
        return repository.getListByDays(3);
    }

    @GetMapping("withoutOneTrack")
    public Object withoutOneTrack() {
        return repository.getListByDays(1);
    }

    @PostMapping("insertNewTrack")
    public void insertNewTrack(@Validated Report report) {
        var dao = new ReportDAO();
        dao.setReport(report);
        repository.save(dao);
    }
}

