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

    @GetMapping(path = "list")
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

    @GetMapping(path = "boysbygender")
    public ResponseEntity<ResponseDTO> boysByGender()
    {return listSeService.getBoysByGender();}

    @GetMapping(path = "/listforageandloc/{age}/{code}")
    public ResponseEntity<ResponseDTO> listForAgeAndLoca(@PathVariable int age, @PathVariable String code) throws ListaSeException
    { return listSeService.listForAgeAndLoca(age,code);}

    @GetMapping(path = "/listforageandgender/{age}/{code}")
    public ResponseEntity<ResponseDTO> listForAgeAndGender(@PathVariable int age, @PathVariable String code) throws ListaSeException
    { return listSeService.listForAgeAndGender(age,code);}

    @GetMapping(path = "/deleteforage/{age}")
    public ResponseEntity<ResponseDTO> deleteBoyForAge(@PathVariable byte age) throws ListaSeException {
        return listSeService.deleteForAge(age);
    }

    @GetMapping(path = "/deleteforgender/{code}")
    public ResponseEntity<ResponseDTO> deleteBoyForGender(@PathVariable String code) throws ListaSeException {
        return listSeService.deleteForGender(code);
    }

    @GetMapping(path = "/listforgrade/{grade}")
    public ResponseEntity<ResponseDTO> listForGrade(@PathVariable byte grade) throws ListaSeException
    { return listSeService.listForGrade(grade);
    }

    @GetMapping(path = "locationmax")
    public ResponseEntity<ResponseDTO> locationMax(){return listSeService.locationMax();}

    @GetMapping(path = "/orderboysAge")
    public ResponseEntity<ResponseDTO> orderBoysAge() throws ListaSeException
    { return listSeService.orderBoysAges();}

    @GetMapping(path = "/deleteforposition/{position}")
    public ResponseEntity<ResponseDTO> deleteBoyForPosition(@PathVariable int position) throws ListaSeException {
        return listSeService.deleteForPosition(position);
    }




    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Lista doblemente enlazada//Lista doblemente enlazada//Lista doblemente enlazada//Lista doblemente enlazada//

    @PostMapping(path = "addde")
    public ResponseEntity<ResponseDTO> addBoyDe(@RequestBody @Valid Boy boy) throws ListaDeException
    { return listDeService.addBoyDe(boy);}

    @GetMapping(path = "listde")
    public ResponseEntity<ResponseDTO> listBoysDe() throws ListaDeException {

        return listDeService.listBoysDe();
    }

    @GetMapping(path = "invertde")
    public ResponseEntity<ResponseDTO> invertListDe() throws ListaDeException
    { return listDeService.invertListDe();}

    @PostMapping(path = "addtostartde")
    public ResponseEntity<ResponseDTO> addBoyToStartDe(@RequestBody @Valid Boy boy) throws ListaDeException
    { return listDeService.addBoyToStartDe(boy);}

    @PostMapping(path = "addtopositionde/{position}")
    public ResponseEntity<ResponseDTO> addBoyBypositionDe(@PathVariable @Valid int position, @RequestBody @Valid Boy boy) throws ListaDeException
    { return listDeService.addBoyByPositionDe(boy,position);}

    @PostMapping(path= "addboysde")
    public ResponseEntity<ResponseDTO> addBoysDe(@RequestBody @Valid List<Boy> boys) throws ListaDeException
    {
        for(Boy boy:boys)
        {
            listDeService.addBoyDe(boy);
        }
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Satisfactorio",listDeService.listBoysDe(), null), HttpStatus.OK);
    }

    @GetMapping(path = "getcountde")
    public ResponseEntity<ResponseDTO> getCountDe()
    { return listDeService.getCountDe();}

    @GetMapping(path = "countde")
    public ResponseEntity<ResponseDTO> countDe()
    { return listDeService.getCountDe();}

    @GetMapping(path = "changextremesde")
    public ResponseEntity<ResponseDTO> chageXtremesDe() throws ListaDeException
    { return listDeService.changeXtremesDe();}

    @GetMapping (path = "/deletede/{id}")
    public ResponseEntity<ResponseDTO> deleteDe(@PathVariable String id) throws ListaDeException
    { return listDeService.deleteDe(id);}

    @GetMapping(path = "variantde")
    public ResponseEntity<ResponseDTO> variantListDe() throws ListaDeException
    { return listDeService.variantListDe();}

    @GetMapping(path = "boysbylocationde")
    public ResponseEntity<ResponseDTO> boysByLocationDe(){return listDeService.getBoysByLocationDe();}

    @GetMapping(path = "boysbygenderde")
    public ResponseEntity<ResponseDTO> boysByGenderDe()
    {return listDeService.getBoysByGenderDe();}

    @GetMapping(path = "/listforageandlocde/{age}/{code}")
    public ResponseEntity<ResponseDTO> listForAgeAndLocaDe(@PathVariable int age, @PathVariable String code) throws ListaDeException
    { return listDeService.listForAgeAndLocaDe(age,code);}

    @GetMapping(path = "/listforageandgenderde/{age}/{code}")
    public ResponseEntity<ResponseDTO> listForAgeAndGenderDe(@PathVariable int age, @PathVariable String code) throws ListaDeException
    { return listDeService.listForAgeAndGenderDe(age,code);}

    @GetMapping(path = "/deleteforagede/{age}")
    public ResponseEntity<ResponseDTO> deleteBoyForAgeDe(@PathVariable byte age) throws ListaDeException {
        return listDeService.deleteForAgeDe(age);
    }

    @GetMapping(path = "/deleteforgenderde/{code}")
    public ResponseEntity<ResponseDTO> deleteBoyForGenderDe(@PathVariable String code) throws ListaDeException {
        return listDeService.deleteForGenderDe(code);
    }

    @GetMapping(path = "/listforgradede/{grade}")
    public ResponseEntity<ResponseDTO> listForGradeDe(@PathVariable byte grade) throws ListaDeException
    { return listDeService.listForGradeDe(grade);
    }

    @GetMapping(path = "locationmaxde")
    public ResponseEntity<ResponseDTO> locationMaxDe(){return listDeService.locationMaxDe();}

    @GetMapping(path = "/orderboysAgede")
    public ResponseEntity<ResponseDTO> orderBoysAgeDe() throws ListaDeException
    { return listDeService.orderBoysAgesDe();}

    @GetMapping(path = "/deleteforpositionde/{position}")
    public ResponseEntity<ResponseDTO> deleteBoyForPositionDe(@PathVariable int position) throws ListaDeException {
        return listDeService.deleteForPositionDe(position);
    }










    /*
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
     */

    /////////////////////

    /*@GetMapping(path = "deletetoposition/{position}")
    public ResponseEntity<ResponseDTO> deleteByposition(@PathVariable @Valid int position) throws ListaSeException
    { return listSeService.deleteBoyByPosition(position);}*/

    /*
    @GetMapping(path = "/list/{gender}")
    public ResponseEntity<ResponseDTO> forGender(@PathVariable String gender) throws ListaSeException { return listSeService.forGender(gender);}
    */

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
