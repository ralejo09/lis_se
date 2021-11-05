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
/**
 * Clase creada para hacer el llamado de listas y generar las respectivas respuestas a los metodos
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class ListSeService {
    /**
     * atributo creado para llamar la respectiva lista de niños
     */
    private ListSE listBoys;
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
    public ListSeService()
    {
        listBoys = new ListSE();
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
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> addBoy(Boy boy) throws ListaSeException
    {
        /**
         * validamos que la localizacion si sea valida a la que vamos a adicionar y si exista en nuestro listado
         */
        if(!validateLocation(boy.getLocation()))
        {
            /**
             * se lanza una excepcion si la ubicacion ingreda no es valida, haciendo esto que nos añada al niño
             */
            throw new ListaSeException("La ubicacion ingresada no es valida");
        }
        /**
         * invocamos al metodo de adicionar al final, para que nos adicione el niño
         */
        listBoys.add(boy);
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
     * @throws ListaSeException
     */
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

    public ResponseEntity<ResponseDTO> listForAgeAndLoca(int age, String code) throws ListaSeException
    {
        listBoys.listForAgeAndLocations(age,code);
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listForAgeAndGender(int age, String code) throws ListaSeException
    {
        listBoys.listForAgeAndGender(age,code);
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> deleteForAge(byte age) throws ListaSeException {
        listBoys.deleteForAge(age);
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> deleteForGender(String code) throws ListaSeException {
        listBoys.deleteForGender(code);
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listForGrade(byte grade) throws ListaSeException
    {
        listBoys.listForGrade(grade);
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> locationMax()
    {
        List<BoysByLocation> boysByLocations = new ArrayList<>();
        int maxLocation=0;
        for(Location loc:locations)
        {
            int count = listBoys.getCountBoysByLocation(loc.getCode());
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

    public ResponseEntity<ResponseDTO> orderBoysAges() throws ListaSeException
    {
        listBoys.orderBoysAge();
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> deleteForPosition(int position) throws ListaSeException {
        listBoys.deleteByPosition(position);
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }


    ///////////////////

    /*public ResponseEntity<ResponseDTO> deleteBoyByPosition(int position) throws ListaSeException
    {
        listBoys.deleteByPosition(position);
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado",true,null), HttpStatus.OK);
    }*/

    /*
    public ResponseEntity<ResponseDTO> forGender(String gender) throws ListaSeException
    {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.list().stream().filter(boy -> boy.getGender().equals(gender)), null), HttpStatus.OK);
    }

     */

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

