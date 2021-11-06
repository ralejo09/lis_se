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
     * respuesta que le damos al metodo que me valida si es una localizacion valida o no
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
     * respuesta que le damos al Metodo que nos adiciona un niño al final de la lista
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
     * respuesta que le damos al Metodo que nos adiciona un niño en la posicion de la lista que le indiquemos
     * @param boy le entra como parametro todos los atributos del niño
     * @param position le entra como parametro la posicion para saber en que posicion se va a adicionar el niño
     * @return retorna una respuesta de si fue satisfactoria la adicion
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> addBoyByPosition(Boy boy, int position) throws ListaSeException
    {
        /**
         * invocamos el metodo de adicionar por posicion, para que dada una posicion no lo elimine
         */
        listBoys.addPosition(boy,position);
        /**
         * retornamos una respuesta indicando que la adicion del niño esta correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado",boy,null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos adiciona un niño al inicio y nos retorna una respuesta
     * @param boy le entra como parametro todos los atributos del niño
     * @return retorna una respuesta de si fue satisfactoria la adicion
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> addBoyToStart(Boy boy) throws ListaSeException
    {
        /**
         * invocamos el metodo de adicionar al inicio para que cuando entre un dato nos lo deje de primero en la lista
         */
        listBoys.addToStart(boy);
        /**
         * retornamos una respuesta indicando que la adicion del niño esta correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado",boy,null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos lista a los niños en cadena y nos retorna una respuesta
     * @return retorna una respuesta de si fue satisfactoria la adicion
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> listBoys() throws ListaSeException
    {
        /**
         * ponemos un condicional que nos indica que si la cabeza es null
         */
        if (listBoys.getHead()== null){
            /**
             * retorna una respuesta, no hay datos en la lista
             */
            throw new ListaSeException("No hay datos en la lista");
        }
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(),null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos invierte el orden de la lisa y luego nos devuelve una respuesta
     * @return retorna una respuesta de si fue satisfactoria la adicion
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> invertList() throws ListaSeException
    {
        /**
         * invocamos el metodo para invertir la lista, esto cambiara su orden y lo pondra de manera inversa
         */
        listBoys.invertList();
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(),null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos retorna la cantidad de niños que hay en la lista
     * @return
     */
    public ResponseEntity<ResponseDTO> getCount()
    {
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getCount(),null), HttpStatus.OK);
    }
    /**
     * metodo que nos retorna la cantidad de niños que hay en la lista
     * @return
     */
    public ResponseEntity<ResponseDTO> count()
    {
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.count(),null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos lista los niños de manera suelta
     * @return una respuesta si fue satisfactorio el listado
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> listBoysFree() throws ListaSeException
    {
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.list(),null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos retorna la lista pero con el cambio de extremos
     * @return retorna una respuesta si la operacion fue exitosa
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> changeXtremes() throws ListaSeException
    {
        /**
         * invocamos el metodo que nos cambia los extremos, el ultimo niño y el niño del inicio
         */
        listBoys.changeXtremes();
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",true,null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos borra un niño
     * @param id parametro que le ingresamos para poder borrar
     * @return retorna una respuesta de si se borro con exito
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> delete(String id) throws ListaSeException
    {
        /**
         * invocamos al metodo que nos elimina el niño segun el id
         */
        listBoys.delete(id);
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Niño Borrado", true, null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos intercala todos los niños en la lista
     * @return retorna una respuesta de si se borro con exito
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> variantList() throws ListaSeException
    {
        /**
         * invocamos al metodo que nos intercala todos los niños, lo hace por el genero
         */
        listBoys.variantBoys();
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(),null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos obtiene una lista con todos los municipios y en cada municipio
     * la cantidad de niños que hay
     * @return retorna una respuesta si fue correcto la operacion
     */
    public ResponseEntity<ResponseDTO> getBoysByLocation()
    {
        /**
         * creamos una lista para guardar el municipio con su cantidad
         */
        List<BoysByLocation> boysByLocations = new ArrayList<>();
        /**
         * hacemos un ciclo for que nis recorra la lista
         */
        for(Location loc:locations)
        {
            /**
             * recorremos la lista y va contando la localizacion por medio del codigo
             */
            int count = listBoys.getCountBoysByLocation(loc.getCode());
            /**
             * adicionamos cada municipio contado es forma de lista con sus cantidades
             */
            boysByLocations.add(new BoysByLocation(loc,count));
        }
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",boysByLocations,null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos retorna la lista de la cantidad de niños que hay por cada genero
     * @return retorna una respuesta si fue correcta la operacion
     */
    public ResponseEntity<ResponseDTO> getBoysByGender()
    {
        /**
         * creamos una lista para guardar el genero con su cantidad
         */
        List<BoysByGender> boysByGenders = new ArrayList<>();
        /**
         * hacemos un ciclo for que nis recorra la lista
         */
        for(Gender1 gender:genders)
        {
            /**
             * recorremos la lista y va contando el genero por medio del codigo
             */
            int count = listBoys.getCountBoysByGender(gender.getCode());
            /**
             * adicionamos cada genero contado es forma de lista con sus cantidades
             */
            boysByGenders.add(new BoysByGender(gender,count));
        }
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",boysByGenders,null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos retorna un listado de los niños por edad y localizacion, pero solo
     * los que sean menores o iguales a la edad dada
     * @param age parametro que nos pide una edad
     * @param code parametro que nos pide el codigo de localizacion, este debe de ser valido
     * @return restorna una respuesta al metodo
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> listForAgeAndLoca(int age, String code) throws ListaSeException
    {
        /**
         * invocamos el metodo que nos lista los niños que tengan la edad menos o igual a la edada, teniendo en cuenta
         * un municipio
         */
        listBoys.listForAgeAndLocations(age,code);
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(), null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo para listar al inicio los que tengan una edad mayor a la dada teniendo
     * encuenta tambien su genero
     * @param age parametro que nos pide una edad
     * @param code parametro que nos pide el codigo de genero, este debe de ser valido
     * @return retorna una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> listForAgeAndGender(int age, String code) throws ListaSeException
    {
        /**
         * invocamos el metodo de listar por genero y por la edad dada, teniendo en cuenta que los que sean mayores
         * a las de la edad dada los lista al inicio
         */
        listBoys.listForAgeAndGender(age,code);
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(), null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que borra segun la edad que le demos
     * @param age parametro que nos pide la edad
     * @return retorna una respuesta si el proceso fue exitoso
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> deleteForAge(byte age) throws ListaSeException {
        /**
         * invocamos al metodo que nos elimina un niño segun la edad dada
         */
        listBoys.deleteForAge(age);
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos borra todos los niños segun el genero ingresado
     * @param code parametro que nos pide el codigo de un genero
     * @return retorna una respuesta si fue exitoso
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> deleteForGender(String code) throws ListaSeException {
        /**
         * invocamos el metodo que nos borra todos lo niños segun un genero
         */
        listBoys.deleteForGender(code);
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos lista a los niños pertenecientes a el grado dado
     * @param grade parametro que nos pide un grado para la operacion
     * @return retorna una respuesta si el proceso fue correcto
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> listForGrade(byte grade) throws ListaSeException
    {
        /**
         * invocamos el metodo que nos lista solo los niños que hagan parte del grado dado
         */
        listBoys.listForGrade(grade);
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(), null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos mira la localizacion maxima, que tiene mas niños
     * @return
     */
    public ResponseEntity<ResponseDTO> locationMax()
    {
        /**
         * creamos una lista para almacenar al municipio que mas tenga
         */
        List<BoysByLocation> boysByLocations = new ArrayList<>();
        /**
         * inicializamos las localizaciones en 0
         */
        int maxLocation=0;
        /**
         * creamos un ciclo que nos recorra todos los municipios
         */
        for(Location loc:locations)
        {
            /**
             * inicializamos al contador para que tome valos por valor, del metodo que nos retorna el metodo que nos
             * obtiene la cantidad de niños por cada municipio
             */
            int count = listBoys.getCountBoysByLocation(loc.getCode());
            /**
             * se analiza dato por dato si el dato es mayor al que ya tiene nuestro maslocation
             */
            if(count> maxLocation){
                /**
                 * el dato que tiene el count es nuestro maxlocation
                 */
                maxLocation=count;
                /**
                 * limpiamos la lista
                 */
                boysByLocations.clear();
                /**
                 * adicionamos el que es mayor a la lista y pasa a ser nuestro nuevo maximo
                 */
                boysByLocations.add(new BoysByLocation(loc,maxLocation));
            }
            /**
             * sino
             */
            else {
                /**
                 * validamos si nuestro dato es igual al que ya tenemos
                 */
                if (count == maxLocation) {
                    /**
                     * si es igual tambien lo adicionamos teniendo ya los dos mayores
                     */
                    boysByLocations.add(new BoysByLocation(loc, maxLocation));
                }
            }
        }
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",boysByLocations,null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos ordena los niños por su edad
     * @return retorna una respuesta al metodo
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> orderBoysAges() throws ListaSeException
    {
        /**
         * invocamos el metodo que nos ordena los niños por edad
         */
        listBoys.orderBoysAge();
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(), null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos borra a un niño por su posicion
     * @param position parametro que se le damos como la posicion
     * @return retornamos una respuesta si el proceso fue exitoso
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> deleteForPosition(int position) throws ListaSeException {
        /**
         * invocamos al metodo que nos borra a un niño dada una posicion
         */
        listBoys.deleteByPosition(position);
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
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

