package com.dev.delta.controllers;

import com.dev.delta.entities.Salary;
import com.dev.delta.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/salary")
@CrossOrigin
public class SalaryController {
    @Autowired
    SalaryService SalaryService;

    @PostMapping("/create")
    public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Salary projectSalary, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<String, String>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Salary newPT = SalaryService.save(projectSalary);

        return new ResponseEntity<Salary>(newPT, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Salary> getAllSalarys() {
        return SalaryService.getSalarys();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salary> getSalaryById(@PathVariable Long id) {
        Salary Salary = SalaryService.findById(id);
        return new ResponseEntity<Salary>(Salary, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSalary(@PathVariable Long id) {
        SalaryService.delete(id);
        return new ResponseEntity<String>("Salary was deleted", HttpStatus.OK);
    }
}
