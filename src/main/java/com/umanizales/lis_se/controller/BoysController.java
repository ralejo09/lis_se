package com.umanizales.lis_se.controller;

import com.umanizales.lis_se.Exception.ListaSeException;
import com.umanizales.lis_se.controller.dto.ResponseDTO;
import com.umanizales.lis_se.model.Boy;
import com.umanizales.lis_se.service.ListSeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "boys")
public class BoysController {
    @Autowired
    private ListSeService listSeService;

    @PostMapping
    public ResponseEntity<ResponseDTO> addBoy(@RequestBody Boy boy) { return listSeService.addBoy(boy);}

    @GetMapping
    public ResponseEntity<ResponseDTO> listBoys() throws ListaSeException {

        return listSeService.listBoys();
    }

    @GetMapping(path = "free")
    public ResponseEntity<ResponseDTO> listBoysFree() throws ListaSeException { return listSeService.listBoysFree();}

    @GetMapping(path = "invert")
    public ResponseEntity<ResponseDTO> invertList() { return listSeService.invertList();}

    @PostMapping(path = "addtostart")
    public ResponseEntity<ResponseDTO> addBoyToStart(@RequestBody Boy boy) { return listSeService.addBoyToStart(boy);}

    @PostMapping(path= "addboys")
    public ResponseEntity<ResponseDTO> addBoys(@RequestBody List<Boy> boys) throws ListaSeException
    {
        for(Boy boy:boys)
        {
            listSeService.addBoy(boy);
        }
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Satisfactorio",listSeService.listBoys(), null), HttpStatus.OK);
    }

    @GetMapping(path = "getcount")
    public ResponseEntity<ResponseDTO> getCount() { return listSeService.getCount();}

    @GetMapping(path = "count")
    public ResponseEntity<ResponseDTO> count() { return listSeService.getCount();}

    @GetMapping(path = "changextremes")
    public ResponseEntity<ResponseDTO> chageXtremes() throws ListaSeException { return listSeService.changeXtremes();}

    @GetMapping (path = "/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable String id) throws ListaSeException { return listSeService.delete(id);}

    @GetMapping(path = "/list/{gender}")
    public ResponseEntity<ResponseDTO> forGender(@PathVariable String gender) throws ListaSeException { return listSeService.forGender(gender);}

    /*
    @GetMapping(path = "/lista/{gender}")
    public ResponseEntity<ResponseDTO> forGenderList(@PathVariable String gender) { return listSeService.forGenderList(gender);}
    */
    @GetMapping(path = "/count/{municipio}")
    public ResponseEntity<ResponseDTO> countMunicipio(@PathVariable String municipio) { return listSeService.countMunicipio(municipio);}

    /*
    @PostMapping (path = "norepeat")
    public ResponseEntity<ResponseDTO> noRepeat(@RequestBody Boy boy)
    {
        return listSeService.noRepeat(boy);
    }*/

    /*
    @GetMapping("/list/{gender}")
    public Boy getBoySex(@PathVariable String gender)
    {
        return listSeService.getBoySex(gender);

    }*/

    /*@GetMapping("/list/{gender}")
    public Boy forGender(@PathVariable String gender)
    {
        return listSeService.forGender(forGender().toString());

    }*/
}
