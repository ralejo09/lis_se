package com.umanizales.lists_prog2.service;

import com.umanizales.lists_prog2.Exception.ListaSeException;
import com.umanizales.lists_prog2.controller.dto.ResponseDTO;
import com.umanizales.lists_prog2.model.*;
import com.umanizales.lists_prog2.model.listaSe.ListSE;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class ListSeService {
    private ListSE listBoys;
    private List<Location> locations;
    private List<Gender1> genders;

    public ListSeService()
    {
        listBoys = new ListSE();
        initializeLocations();
        initializeGenders();
    }

    private void initializeLocations()
    {
        locations= new ArrayList<>();
        locations.add(new Location("1","Manizales"));
        locations.add(new Location("2","Bogota"));
        locations.add(new Location("3","Armenia"));
        locations.add(new Location("4","Pereira"));
    }

    private void initializeGenders()
    {
        genders= new ArrayList<>();
        genders.add(new Gender1("1","FEMENINO"));
        genders.add(new Gender1("2","MASCULINO"));
    }

    public boolean validateLocation(Location location)
    {
        for(Location loc: locations)
        {
            if(loc.getCode().equals(location.getCode()) && loc.getDescription().equals(location.getDescription()))
            {
                return true;
            }
        }
        return false;
    }

    public ResponseEntity<ResponseDTO> addBoy(Boy boy) throws ListaSeException
    {
        if(!validateLocation(boy.getLocation()))
        {
            throw new ListaSeException("La ubicacion ingresada no es valida");
        }
        listBoys.add(boy);
            return new ResponseEntity<>(new ResponseDTO("Niño adicionado",boy,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> addBoyByPosition(Boy boy, int position) throws ListaSeException
    {
        listBoys.addPosition(boy,position);
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado",boy,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> addBoyToStart(Boy boy) throws ListaSeException
    {
        listBoys.addToStart(boy);
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado",boy,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listBoys() throws ListaSeException
    {
        if (listBoys.getHead()== null){
            throw new ListaSeException("No hay datos en la lista");
        }
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(),null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> invertList() throws ListaSeException
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
    public ResponseEntity<ResponseDTO> variantList() throws ListaSeException
    {
        listBoys.variantBoys();
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(),null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> getBoysByLocation()
    {
        List<BoysByLocation> boysByLocations = new ArrayList<>();
        for(Location loc:locations)
        {
            int count = listBoys.getCountBoysByLocation(loc.getCode());
            boysByLocations.add(new BoysByLocation(loc,count));
        }
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",boysByLocations,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> getBoysByGender()
    {
        List<BoysByGender> boysByGenders = new ArrayList<>();
        for(Gender1 gender:genders)
        {
            int count = listBoys.getCountBoysByGender(gender.getCode());
            boysByGenders.add(new BoysByGender(gender,count));
        }
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",boysByGenders,null), HttpStatus.OK);
    }

    ///////////////////
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

    /*public ResponseEntity<ResponseDTO> countMunicipio(String municipio)
    {
        listBoys.countMunicipio(municipio);
        return new ResponseEntity<>(new ResponseDTO(""+municipio,listBoys.countMunicipio(municipio),null), HttpStatus.OK);
    }*/

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

