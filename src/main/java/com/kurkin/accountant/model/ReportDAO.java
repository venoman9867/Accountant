package com.kurkin.accountant.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "Report")
public class ReportDAO{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    protected Long id;
    @Embedded
    private Report report;

    public Long getId() {
        return id;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
