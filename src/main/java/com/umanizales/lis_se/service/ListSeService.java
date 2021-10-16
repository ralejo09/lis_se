package com.umanizales.lis_se.service;

import com.umanizales.lis_se.Exception.ListaSeException;
import com.umanizales.lis_se.controller.dto.ResponseDTO;
import com.umanizales.lis_se.model.Boy;
import com.umanizales.lis_se.model.ListSE;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Service
public class ListSeService {
    private ListSE listBoys;

    public ListSeService() {
        listBoys = new ListSE();
    }

    public ResponseEntity<ResponseDTO> addBoy(Boy boy)
    {
        if(listBoys.add(boy)){
            return new ResponseEntity<>(new ResponseDTO("Niño adicionado",true,null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseDTO("Niño no adicionado",false,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> addBoyToStart(Boy boy)
    {
        listBoys.addToStart(boy);
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado",true,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listBoys() throws ListaSeException
    {
        if (listBoys.getHead()== null){
            throw new ListaSeException("No hay datos en la lista");
        }
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(),null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> invertList()
    {
        listBoys.invertList();
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(),null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> getCount()
    {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getCount(),null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> count()
    {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.count(),null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listBoysFree() throws ListaSeException
    {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.list(),null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> changeXtremes() throws ListaSeException
    {
        listBoys.changeXtremes();
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",true,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> delete(String id) throws ListaSeException
    {
        listBoys.delete(id);
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Niño Borrado", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> forGender(String gender) throws ListaSeException
    {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.list().stream().filter(boy -> boy.getGender().equals(gender)), null), HttpStatus.OK);
    }

    /*
    public ResponseEntity<ResponseDTO> forGenderList(String gender)
    {
        listBoys.forGenderList(gender);
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",true, null), HttpStatus.OK);
    }
    */

    public ResponseEntity<ResponseDTO> countMunicipio(String municipio)
    {
        listBoys.countMunicipio(municipio);
        return new ResponseEntity<>(new ResponseDTO(""+municipio,listBoys.countMunicipio(municipio),null), HttpStatus.OK);
    }

    /*
    public ResponseEntity<ResponseDTO> noRepeat(Boy boy)
    {
        listBoys.noRepeat(boy);
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Niño Adicionado",true,null), HttpStatus.OK);

        /*if(listBoys.noRepeat(boy)== true)
        {
            listBoys.noRepeat(boy);
            return new ResponseEntity<ResponseDTO>(new ResponseDTO("Niño Adicionado",true,null), HttpStatus.OK);
        }else{
            listBoys.noRepeat(boy);
            return new ResponseEntity<ResponseDTO>(new ResponseDTO("Niño Respetido",true,null), HttpStatus.OK);
        }

    }*/

    /*
    public Boy getBoySex(String gender) {
            return boyList.stream().filter(boy -> boy.getGender().equals(gender)).findFirst().orElse(null);
    }

    /*
    public ResponseEntity<ResponseDTO> noRepeat()
    {
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("esta repetido",,null))
    }

    public Boy getMotorcycleByLicensePlate(String identification)
    {
        //Recorrer listado de motocicletas y buscar por placa y retornarlos
    }
    */

    /*public ResponseEntity<ResponseDTO> forGender(String gender)
    {

        listBoys.forGender("Femenino");
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.forGender("Femenino"),null), HttpStatus.OK);
    }*/

}

