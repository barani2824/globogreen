/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.web.rest;

import com.kdi.onboardinghelper.service.PdfService;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author subasb
 */
@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;

//    @GetMapping("/basic_form/{email}")
//    public ResponseEntity<InputStreamResource> getBasicForm(@PathVariable String email) throws IOException {
//        File file = pdfService.fillAndGetBasicForm(email);
//        ByteArrayInputStream in = getByteStreamFromFile(file);
//
//        if (in == null) {
//            return null;
//        }
//        return ResponseEntity
//                .ok()
//                .headers(getAppropriateHeaders(file.getName()))
//                .body(new InputStreamResource(new FileInputStream(file)));
//    }
//
//    @GetMapping("/personal_form/{id}")
//    public ResponseEntity<InputStreamResource> getPersonalForm(@PathVariable Long id) throws IOException {
//        File file = pdfService.fillAndGetPersonalForm(id);
//        ByteArrayInputStream in = getByteStreamFromFile(file);
//
//        if (in == null) {
//            return null;
//        }
//        return ResponseEntity
//                .ok()
//                .headers(getAppropriateHeaders(file.getName()))
//                .body(new InputStreamResource(in));
//    }
//
//    @GetMapping("/pf_form/{id}")
//    public ResponseEntity<InputStreamResource> getProvidentFundForm(@PathVariable Long id) throws IOException {
//        File file = pdfService.fillAndGetProvidentFundForm(id);
//        ByteArrayInputStream in = getByteStreamFromFile(file);
//
//        if (in == null) {
//            return null;
//        }
//        return ResponseEntity
//                .ok()
//                .headers(getAppropriateHeaders(file.getName()))
//                .body(new InputStreamResource(in));
//    }
//
//    @GetMapping("/form_f/{id}")
//    public ResponseEntity<InputStreamResource> getFormF(@PathVariable Long id) throws IOException {
//        File file = pdfService.fillAndGetFormF(id);
//        ByteArrayInputStream in = getByteStreamFromFile(file);
//
//        if (in == null) {
//            return null;
//        }
//        return ResponseEntity
//                .ok()
//                .headers(getAppropriateHeaders(file.getName()))
//                .body(new InputStreamResource(in));
//    }
//
//    @GetMapping("/form_i/{id}")
//    public ResponseEntity<InputStreamResource> getFormI(@PathVariable Long id) throws IOException {
//        File file = pdfService.fillAndGetFormI(id);
//        ByteArrayInputStream in = getByteStreamFromFile(file);
//
//        if (in == null) {
//            return null;
//        }
//        return ResponseEntity
//                .ok()
//                .headers(getAppropriateHeaders(file.getName()))
//                .body(new InputStreamResource(in));
//    }
//
//    @GetMapping("/form_q/{id}")
//    public ResponseEntity<InputStreamResource> getFormQ(@PathVariable Long id) throws IOException {
//        File file = pdfService.fillAndGetFormQ(id);
//        ByteArrayInputStream in = getByteStreamFromFile(file);
//
//        if (in == null) {
//            return null;
//        }
//        return ResponseEntity
//                .ok()
//                .headers(getAppropriateHeaders(file.getName()))
//                .body(new InputStreamResource(in));
//    }

    @GetMapping("/allForms/{email}")
    public ResponseEntity<InputStreamResource> getAllForms(@PathVariable String email) throws IOException {
        File file = pdfService.mergeAllForms(email);
        ByteArrayInputStream in = getByteStreamFromFile(file);

        if (in == null) {
            return null;
        }
        return ResponseEntity
                .ok()
                .headers(getAppropriateHeaders(file.getName()))
                .body(new InputStreamResource(in));
    }

    private HttpHeaders getAppropriateHeaders(String filename) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + filename);
        return headers;
    }

    private ByteArrayInputStream getByteStreamFromFile(File file) {
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(
                    FileUtils.readFileToByteArray(file));
            return in;
        } catch (IOException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
