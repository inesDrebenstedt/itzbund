package com.itz.demo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itz.demo.demo.model.Dummy;
import com.itz.demo.demo.repository.DummyRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/dummy")
public class DummyController {

    @Autowired
    private DummyRepository dummyRepository;

    @Operation(summary = "Create a new Dummy", description = "Add a new Dummy object to the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully created"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public Dummy createDummy(@RequestBody Dummy dummy) {
        return dummyRepository.save(dummy);
    }

    @Operation(summary = "Get all Dummies", description = "Fetch all Dummy objects from the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<Dummy> getDummys() {
        return dummyRepository.findAll();
    }
    
    @Operation(summary = "Update an existing Dummy", description = "Update a Dummy object in the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated"),
        @ApiResponse(responseCode = "404", description = "Dummy not found"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping
    public Dummy updateDummy(@RequestBody Dummy dummy) {
        return dummyRepository.save(dummy);
    }
    
    @Operation(summary = "Delete a Dummy", description = "Delete a Dummy object from the database")
    @ApiResponse(responseCode = "204", description = "Successfully deleted")
    @DeleteMapping
    public void deleteDummy(@RequestBody Dummy dummy) {
        dummyRepository.delete(dummy);
    }
}
