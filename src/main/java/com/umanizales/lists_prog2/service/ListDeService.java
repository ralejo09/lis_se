package com.umanizales.lists_prog2.service;

import com.umanizales.lists_prog2.Exception.ListaDeException;
import com.umanizales.lists_prog2.controller.dto.ResponseDTO;
import com.umanizales.lists_prog2.model.*;
import com.umanizales.lists_prog2.model.listaDe.ListDe;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
/**
 * Clase creada para hacer el llamado de listas y generar las respectivas respuestas a los metodos
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class ListDeService {
    /**
     * atributo creado para llamar la respectiva lista de niños
     */
    private ListDe listBoys;
    /**
     * atributo creado para hacer referencia a el arraylist que tenemos para la localizacion
     */
    private List<Location> locations;
    /**
     * atributo creado para hacer referencia a el arraylist que tenemos para el genero
     */
    private List<Gender1> genders;


    /**
     * constructor creado para inicializar las listas
     */
    public ListDeService()
    {
        listBoys = new ListDe();
        initializeLocations();
        initializeGenders();
    }

    /**
     * arraylist de lozalizaciones por codigo y descripcion
     */
    private void initializeLocations()
    {
        locations= new ArrayList<>();
        locations.add(new Location("1","Manizales"));
        locations.add(new Location("2","Bogota"));
        locations.add(new Location("3","Armenia"));
        locations.add(new Location("4","Pereira"));
        locations.add(new Location("5","Cali"));
    }

    /**
     * arraylist de generos por codigo y descripcion
     */
    private void initializeGenders()
    {
        genders= new ArrayList<>();
        genders.add(new Gender1("1","FEMENINO"));
        genders.add(new Gender1("2","MASCULINO"));
    }


    /**
     * metodo que me valida si es una localizacion valida o no
     * @param location le entra como parametro la localizacion del niño
     * @return retorna una respuesta boolean
     */
    public boolean validateLocation(Location location)
    {
        /**
         * generamos un ciclo para que nos recorra todas las localizaciones de cada niño
         */
        for(Location loc: locations)
        {
            /**
             * si el codigo es igual al codigo que ingresamos al niño y si la descripcion es igual a la
             * descripcion que ingresamos al niño
             */
            if(loc.getCode().equals(location.getCode()) && loc.getDescription().equals(location.getDescription()))
            {
                /**
                 * retorneme que la localizacion si es buena, acertada, correcta, TRUE
                 */
                return true;
            }
        }
        /**
         * retorneme que la localizacion es falsa FALSE
         */
        return false;
    }

    /**
     * Metodo que nos adiciona un niño al final de la lista
     * @param boy le entra como parametro todos los atributos del niño
     * @return retorna una respuesta de si fue satisfactoria la adicion
     * @throws ListaDeException
     */
    public ResponseEntity<ResponseDTO> addBoyDe(Boy boy) throws ListaDeException
    {
        /**
         * validamos que la localizacion si sea valida a la que vamos a adicionar y si exista en nuestro listado
         */
        if(!validateLocation(boy.getLocation()))
        {
            /**
             * se lanza una excepcion si la ubicacion ingreda no es valida, haciendo esto que nos añada al niño
             */
            throw new ListaDeException("La ubicacion ingresada no es valida");
        }
        /**
         * invocamos al metodo de adicionar al final, para que nos adicione el niño
         */
        listBoys.addDe(boy);
        /**
         * retornamos una respuesta indicando que la adicion del niño esta correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado",boy,null), HttpStatus.OK);
    }

    /**
     * Metodo que nos adiciona un niño en la posicion de la lista que le indiquemos
     * @param boy le entra como parametro todos los atributos del niño
     * @param position le entra como parametro la posicion para saber en que posicion se va a adicionar el niño
     * @return retorna una respuesta de si fue satisfactoria la adicion
     * @throws ListaDeException
     */
    public ResponseEntity<ResponseDTO> addBoyByPositionDe(Boy boy, int position) throws ListaDeException
    {
        listBoys.addPositionDe(boy,position);
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado",boy,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> addBoyToStartDe(Boy boy) throws ListaDeException
    {
        listBoys.addToStartDe(boy);
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado",boy,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listBoysDe() throws ListaDeException
    {
        if (listBoys.getHead()== null){
            throw new ListaDeException("No hay datos en la lista");
        }
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.listDe(),null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> invertListDe() throws ListaDeException
    {
        listBoys.invertListDe();
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.listDe(),null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> getCountDe()
    {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getCount(),null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> countDe()
    {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.countDe(),null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> changeXtremesDe() throws ListaDeException
    {
        listBoys.changeXtremesDe();
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",true,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> deleteDe(String id) throws ListaDeException
    {
        listBoys.deleteDe(id);
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Niño Borrado", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> variantListDe() throws ListaDeException
    {
        listBoys.variantBoysDe();
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.listDe(),null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> getBoysByLocationDe()
    {
        List<BoysByLocation> boysByLocations = new ArrayList<>();
        for(Location loc:locations)
        {
            int count = listBoys.getCountBoysByLocationDe(loc.getCode());
            boysByLocations.add(new BoysByLocation(loc,count));
        }
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",boysByLocations,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> getBoysByGenderDe()
    {
        List<BoysByGender> boysByGenders = new ArrayList<>();
        for(Gender1 gender:genders)
        {
            int count = listBoys.getCountBoysByGenderDe(gender.getCode());
            boysByGenders.add(new BoysByGender(gender,count));
        }
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",boysByGenders,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listForAgeAndLocaDe(int age, String code) throws ListaDeException
    {
        listBoys.listForAgeAndLocationsDe(age,code);
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.listDe(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listForAgeAndGenderDe(int age, String code) throws ListaDeException
    {
        listBoys.listForAgeAndGenderDe(age,code);
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.listDe(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> deleteForAgeDe(byte age) throws ListaDeException {
        listBoys.deleteForAgeDe(age);
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> deleteForGenderDe(String code) throws ListaDeException {
        listBoys.deleteForGenderDe(code);
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listForGradeDe(byte grade) throws ListaDeException
    {
        listBoys.listForGradeDe(grade);
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.listDe(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> locationMaxDe()
    {
        List<BoysByLocation> boysByLocations = new ArrayList<>();
        int maxLocation=0;
        for(Location loc:locations)
        {
            int count = listBoys.getCountBoysByLocationDe(loc.getCode());
            if(count> maxLocation){
                maxLocation=count;
                boysByLocations.clear();
                boysByLocations.add(new BoysByLocation(loc,maxLocation));
            }
            else {
                if (count == maxLocation) {
                    boysByLocations.add(new BoysByLocation(loc, maxLocation));
                }
            }
        }
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",boysByLocations,null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> orderBoysAgesDe() throws ListaDeException
    {
        listBoys.orderBoysAgeDe();
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.listDe(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> deleteForPositionDe(int position) throws ListaDeException {
        listBoys.deleteByPositionDe(position);
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }













   /* private ListDe listBoys;
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
    }*/
}
