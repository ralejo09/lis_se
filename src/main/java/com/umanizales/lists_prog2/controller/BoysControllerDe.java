/*package com.umanizales.lists_prog2.controller;

import com.umanizales.lists_prog2.Exception.ListaDeException;
import com.umanizales.lists_prog2.Exception.ListaSeException;
import com.umanizales.lists_prog2.controller.dto.ResponseDTO;
import com.umanizales.lists_prog2.model.Boy;
import com.umanizales.lists_prog2.service.ListDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "boys")
public class BoysControllerDe {
    @Autowired
    private ListDeService listDeService;

    @PostMapping(path = "addtostart")
    public ResponseEntity<ResponseDTO> addBoyToStart(@RequestBody @Valid Boy boy) throws ListaDeException
    {
        return listDeService.addBoyToStart(boy);
    }
    @GetMapping
    public ResponseEntity<ResponseDTO> listBoys() throws ListaDeException {

        return listDeService.listBoys();
    }
}*/
