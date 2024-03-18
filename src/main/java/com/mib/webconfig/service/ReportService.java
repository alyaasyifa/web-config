package com.mib.webconfig.service;

import com.mib.webconfig.entity.Guru;
import com.mib.webconfig.entity.Movie;
import com.mib.webconfig.repository.GuruRepository;
import com.mib.webconfig.repository.MovieRepository;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class ReportService {


    @Autowired
    private GuruRepository guruRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DataSource dataSource;

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            return null;
        }
    }

    // Product
    public void createGuruReport(String exportType, HttpServletResponse response) throws JRException, IOException {
        List<Guru> guruList = guruRepository.findAll();
        exportGuruReport(guruList, exportType, response);
    }

    private void exportGuruReport(Collection<?> beanCollection, String exportType, HttpServletResponse response) throws JRException, IOException {
        InputStream transactionReportStream =
                getClass()
                        .getResourceAsStream(
                                "/report/guru_" + exportType.toLowerCase() + ".jrxml");
        if (transactionReportStream == null) {
            throw new RuntimeException("Template file not found!");
        }

        String titleTransactionBy = "Products Report";

        JasperReport jasperReport = JasperCompileManager.compileReport(transactionReportStream);
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(beanCollection);
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("title", titleTransactionBy);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        var dateTimeNow = LocalDateTime.now().format(formatter);
        var fileName = titleTransactionBy.replace(" ", "") + "-" + dateTimeNow;

        if (exportType.equalsIgnoreCase("PDF")) {
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
            response.setContentType("application/pdf");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName + ".pdf;");
            exporter.exportReport();
        } else if (exportType.equalsIgnoreCase("EXCEL")) {
            JRXlsxExporter exporter = new JRXlsxExporter();
            SimpleXlsxReportConfiguration reportConfigXLS = new SimpleXlsxReportConfiguration();
            reportConfigXLS.setSheetNames(new String[]{titleTransactionBy});
            reportConfigXLS.setDetectCellType(true);
            reportConfigXLS.setCollapseRowSpan(false);
            exporter.setConfiguration(reportConfigXLS);
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName + ".xlsx;");
            response.setContentType("application/octet-stream");
            exporter.exportReport();
        } else if (exportType.equalsIgnoreCase("CSV")) {
            JRCsvExporter exporter = new JRCsvExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            var outputStream = response.getOutputStream();
            exporter.setExporterOutput((new SimpleWriterExporterOutput(outputStream)));
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName + ".csv;");
            response.setContentType("text/csv");
            exporter.exportReport();
        } else if (exportType.equalsIgnoreCase("DOCX")) {
            JRDocxExporter exporter = new JRDocxExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName + ".docx;");
            response.setContentType("application/octet-stream");
            exporter.exportReport();
        } else {
            throw new RuntimeException("File Format isn't supported!");
        }

    }

    public void createMovieReport(String exportType, HttpServletResponse response) throws JRException, IOException {
        List<Movie> movieList = movieRepository.findAll();
        exportMovieReport(movieList, exportType, response);
    }

    public void exportMovieReport(Collection<?> beanCollection, String exportType, HttpServletResponse response) throws JRException, IOException {
        InputStream transactionReportStream = getClass().getResourceAsStream("/report/movie_" + exportType.toLowerCase() + ".jrxml");
        if (transactionReportStream == null) {
            throw new RuntimeException("Template file not found!");
        }

        String titleTransactionBy = "Movie Report";

        JasperReport jasperReport = JasperCompileManager.compileReport(transactionReportStream);
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(beanCollection);
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("title", titleTransactionBy);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        var dateTimeNow = LocalDateTime.now().format(formatter);
        var fileName = titleTransactionBy.replace(" ", "") + "-" + dateTimeNow;

        if (exportType.equalsIgnoreCase("PDF")) {
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
            response.setContentType("application/pdf");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName + ".pdf;");
            exporter.exportReport();
        } else if (exportType.equalsIgnoreCase("EXCEL")) {
            JRXlsxExporter exporter = new JRXlsxExporter();
            SimpleXlsxReportConfiguration reportConfigXLS = new SimpleXlsxReportConfiguration();
            reportConfigXLS.setSheetNames(new String[]{titleTransactionBy});
            reportConfigXLS.setDetectCellType(true);
            reportConfigXLS.setCollapseRowSpan(false);
            exporter.setConfiguration(reportConfigXLS);
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName + ".xlsx;");
            response.setContentType("application/octet-stream");
            exporter.exportReport();
        } else if (exportType.equalsIgnoreCase("CSV")) {
            JRCsvExporter exporter = new JRCsvExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            var outputStream = response.getOutputStream();
            exporter.setExporterOutput((new SimpleWriterExporterOutput(outputStream)));
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName + ".csv;");
            response.setContentType("text/csv");
            exporter.exportReport();
        } else if (exportType.equalsIgnoreCase("DOCX")) {
            JRDocxExporter exporter = new JRDocxExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName + ".docx;");
            response.setContentType("application/octet-stream");
            exporter.exportReport();
        } else {
            throw new RuntimeException("File Format isn't supported!");
        }
    }
}

