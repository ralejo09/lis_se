package com.umanizales.lists_prog2.controller;

import com.umanizales.lists_prog2.Exception.ListaDeException;
import com.umanizales.lists_prog2.Exception.ListaSeException;
import com.umanizales.lists_prog2.controller.dto.ResponseDTO;
import com.umanizales.lists_prog2.model.Boy;
import com.umanizales.lists_prog2.service.ListDeService;
import com.umanizales.lists_prog2.service.ListSeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "boys")
public class BoysController {
    @Autowired
    private ListSeService listSeService;
    @Autowired
    private ListDeService listDeService;

    @PostMapping
    public ResponseEntity<ResponseDTO> addBoy(@RequestBody @Valid Boy boy) throws ListaSeException { return listSeService.addBoy(boy);}

    @GetMapping
    public ResponseEntity<ResponseDTO> listBoys() throws ListaSeException {

        return listSeService.listBoys();
    }

    @GetMapping(path = "free")
    public ResponseEntity<ResponseDTO> listBoysFree() throws ListaSeException { return listSeService.listBoysFree();}

    @GetMapping(path = "invert")
    public ResponseEntity<ResponseDTO> invertList() throws ListaSeException { return listSeService.invertList();}

    @PostMapping(path = "addtostart")
    public ResponseEntity<ResponseDTO> addBoyToStart(@RequestBody @Valid Boy boy) throws ListaSeException { return listSeService.addBoyToStart(boy);}

    @PostMapping(path = "addtoposition/{position}")
    public ResponseEntity<ResponseDTO> addBoyByposition(@PathVariable @Valid int position, @RequestBody @Valid Boy boy) throws ListaSeException
    { return listSeService.addBoyByPosition(boy,position);}

    @PostMapping(path= "addboys")
    public ResponseEntity<ResponseDTO> addBoys(@RequestBody @Valid List<Boy> boys) throws ListaSeException
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

    @GetMapping(path = "variant")
    public ResponseEntity<ResponseDTO> variantList() throws ListaSeException { return listSeService.variantList();}

    @GetMapping(path = "boysbylocation")
    public ResponseEntity<ResponseDTO> boysByLocation(){return listSeService.getBoysByLocation();}

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Lista doblemente enlazada

    @PostMapping(path = "addde")
    public ResponseEntity<ResponseDTO> addBoyToStartDe(@RequestBody @Valid Boy boy) throws ListaDeException
    {
        return listDeService.addBoyDe(boy);
    }

    @PostMapping(path = "addtostartde")
    public ResponseEntity<ResponseDTO> addBoyDe(@RequestBody @Valid Boy boy) throws ListaDeException
    {
        return listDeService.addBoyToStartDe(boy);
    }

    @GetMapping (path = "/deletede/{id}")
    public ResponseEntity<ResponseDTO> deleteDe(@PathVariable String id) throws ListaDeException { return listDeService.deleteDe(id);}

    @GetMapping(path = "changextremesde")
    public ResponseEntity<ResponseDTO> chageXtremesDe() throws ListaDeException { return listDeService.changeXtremesDe();}

    @PostMapping(path = "addtopositionde/{position}")
    public ResponseEntity<ResponseDTO> addBoyBypositionDe(@PathVariable @Valid int position, @RequestBody @Valid Boy boy) throws ListaDeException
    { return listDeService.addBoyByPositionDe(boy,position);}

    @GetMapping(path = "listde")
    public ResponseEntity<ResponseDTO> listBoysDe() throws ListaDeException {
        return listDeService.listBoysDe();
    }

    @GetMapping(path = "freede")
    public ResponseEntity<ResponseDTO> listBoysFreeDe() throws ListaDeException
    {
        return listDeService.listBoysFreeDe();
    }

    /////////////////////
    @GetMapping(path = "/list/{gender}")
    public ResponseEntity<ResponseDTO> forGender(@PathVariable String gender) throws ListaSeException { return listSeService.forGender(gender);}

    /*
    @GetMapping(path = "/lista/{gender}")
    public ResponseEntity<ResponseDTO> forGenderList(@PathVariable String gender) { return listSeService.forGenderList(gender);}
    */

    /*
    @GetMapping(path = "/count/{municipio}")
    public ResponseEntity<ResponseDTO> countMunicipio(@PathVariable String municipio) { return listSeService.countMunicipio(municipio);}
    */

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
