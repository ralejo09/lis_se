package com.umanizales.lists_prog2.service;

import com.umanizales.lists_prog2.Exception.ListaDeException;
import com.umanizales.lists_prog2.Exception.ListaSeException;
import com.umanizales.lists_prog2.controller.dto.ResponseDTO;
import com.umanizales.lists_prog2.model.Boy;
import com.umanizales.lists_prog2.model.BoysByLocation;
import com.umanizales.lists_prog2.model.Location;
import com.umanizales.lists_prog2.model.listaDe.ListDe;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public class ListDeService {
    private ListDe listBoys;
    //private List<Location> locations;

    public ListDeService()
    {
        listBoys = new ListDe();
        //initializeLocations();
    }

    public ResponseEntity<ResponseDTO> addBoyDe(Boy boy) throws ListaDeException
    {
        listBoys.addDe(boy);
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado",boy,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> addBoyToStartDe(Boy boy) throws ListaDeException
    {
        listBoys.addToStart(boy);
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado",boy,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> deleteDe(String id) throws ListaDeException
    {
        listBoys.deleteBoyDe(id);
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Niño Borrado", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> changeXtremesDe() throws ListaDeException
    {
        listBoys.changeXtremesDe();
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",true,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> addBoyByPositionDe(Boy boy, int position) throws ListaDeException
    {
        listBoys.addPositionDe(boy,position);
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado",boy,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listBoysDe() throws ListaDeException
    {
        if (listBoys.getHead()== null){
            throw new ListaDeException("No hay datos en la lista");
        }
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(),null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listBoysFreeDe() throws ListaDeException
    {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.listDe(),null), HttpStatus.OK);
    }
}
