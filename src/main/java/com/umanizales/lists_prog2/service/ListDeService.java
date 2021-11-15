package com.umanizales.lists_prog2.service;

import com.umanizales.lists_prog2.Exception.ListaDeException;
import com.umanizales.lists_prog2.Exception.ListaSeException;
import com.umanizales.lists_prog2.controller.dto.*;
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
        locations.add(new Location("1","Armenia"));
        locations.add(new Location("2","Bogota"));
        locations.add(new Location("3","Cali"));
        locations.add(new Location("4","Manizales"));
        locations.add(new Location("5","Pereira"));
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
        /**
         * invocamos el metodo de adicionar por posicion, para que dada una posicion no lo elimine
         */
        listBoys.addPositionDe(boy,position);
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
    public ResponseEntity<ResponseDTO> addBoyToStartDe(Boy boy) throws ListaDeException
    {
        /**
         * invocamos el metodo de adicionar al inicio para que cuando entre un dato nos lo deje de primero en la lista
         */
        listBoys.addToStartDe(boy);
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
    public ResponseEntity<ResponseDTO> listBoysDe() throws ListaDeException
    {
        /**
         * ponemos un condicional que nos indica que si la cabeza es null
         */
        if (listBoys.getHead()== null){
            /**
             * retorna una respuesta, no hay datos en la lista
             */
            throw new ListaDeException("No hay datos en la lista");
        }
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.listDe(),null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos invierte el orden de la lisa y luego nos devuelve una respuesta
     * @return retorna una respuesta de si fue satisfactoria la adicion
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> invertListDe() throws ListaDeException
    {
        /**
         * invocamos el metodo para invertir la lista, esto cambiara su orden y lo pondra de manera inversa
         */
        listBoys.invertListDe();
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.listDe(),null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos retorna la cantidad de niños que hay en la lista
     * @return
     */
    public ResponseEntity<ResponseDTO> getCountDe()
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
    public ResponseEntity<ResponseDTO> countDe()
    {
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.countDe(),null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos retorna la lista pero con el cambio de extremos
     * @return retorna una respuesta si la operacion fue exitosa
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> changeXtremesDe() throws ListaDeException
    {
        /**
         * invocamos el metodo que nos cambia los extremos, el ultimo niño y el niño del inicio
         */
        listBoys.changeXtremesDe();
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
    public ResponseEntity<ResponseDTO> deleteDe(String id) throws ListaDeException
    {
        /**
         * invocamos al metodo que nos elimina el niño segun el id
         */
        listBoys.deleteDe(id);
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
    public ResponseEntity<ResponseDTO> variantListDe() throws ListaDeException
    {
        /**
         * invocamos al metodo que nos intercala todos los niños, lo hace por el genero
         */
        listBoys.variantBoysDe();
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.listDe(),null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos obtiene una lista con todos los municipios y en cada municipio
     * la cantidad de niños que hay
     * @return retorna una respuesta si fue correcto la operacion
     */
    public ResponseEntity<ResponseDTO> getBoysByLocationDe()
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
            int count = listBoys.getCountBoysByLocationDe(loc.getCode());
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
    public ResponseEntity<ResponseDTO> getBoysByGenderDe()
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
            int count = listBoys.getCountBoysByGenderDe(gender.getCode());
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
     * @throws ListaDeException
     */
    public ResponseEntity<ResponseDTO> listForAgeAndLocaDe(int age, String code) throws ListaDeException
    {
        /**
         * invocamos el metodo que nos lista los niños que tengan la edad menos o igual a la edada, teniendo en cuenta
         * un municipio
         */
        listBoys.listForAgeAndLocationsDe(age,code);
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.listDe(), null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo para listar al inicio los que tengan una edad mayor a la dada teniendo
     * encuenta tambien su genero
     * @param age parametro que nos pide una edad
     * @param code parametro que nos pide el codigo de genero, este debe de ser valido
     * @return retorna una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> listForAgeAndGenderDe(int age, String code) throws ListaDeException
    {
        /**
         * invocamos el metodo de listar por genero y por la edad dada, teniendo en cuenta que los que sean mayores
         * a las de la edad dada los lista al inicio
         */
        listBoys.listForAgeAndGenderDe(age,code);
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.listDe(), null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que borra segun la edad que le demos
     * @param age parametro que nos pide la edad
     * @return retorna una respuesta si el proceso fue exitoso
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> deleteForAgeDe(byte age) throws ListaDeException {
        /**
         * invocamos al metodo que nos elimina un niño segun la edad dada
         */
        listBoys.deleteForAgeDe(age);
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
    public ResponseEntity<ResponseDTO> deleteForGenderDe(String code) throws ListaDeException {
        /**
         * invocamos el metodo que nos borra todos lo niños segun un genero
         */
        listBoys.deleteForGenderDe(code);
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
    public ResponseEntity<ResponseDTO> listForGradeDe(byte grade) throws ListaDeException
    {
        /**
         * invocamos el metodo que nos lista solo los niños que hagan parte del grado dado
         */
        listBoys.listForGradeDe(grade);
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.listDe(), null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos mira la localizacion maxima, que tiene mas niños
     * @return
     */
    public ResponseEntity<ResponseDTO> locationMaxDe()
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
            int count = listBoys.getCountBoysByLocationDe(loc.getCode());
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
    public ResponseEntity<ResponseDTO> orderBoysAgesDe() throws ListaDeException
    {
        /**
         * invocamos el metodo que nos ordena los niños por edad
         */
        listBoys.orderBoysAgeDe();
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.listDe(), null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo que nos borra a un niño por su posicion
     * @param position parametro que se le damos como la posicion
     * @return retornamos una respuesta si el proceso fue exitoso
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> deleteForPositionDe(int position) throws ListaDeException {
        /**
         * invocamos al metodo que nos borra a un niño dada una posicion
         */
        listBoys.deleteByPositionDe(position);
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo propuesto en clase de la tabla de huerfanos
     * @return la estructura con sus datos
     * @throws ListaDeException
     */
    public ResponseEntity<ResponseDTO>  getOrphansByGradeByLocation() throws ListaDeException
    {
        /**
         * creamos una lista para almacenar todos los datos
         */
        List<GradesByLocationDTO> gradeByLocationDTOS = new ArrayList<>();
        /**
         * recorremos las localizaciones
         */
        for (Location loc: locations)
        {
            /**
             * adicionaremos las localizaciones a nuestra lista
             */
            gradeByLocationDTOS.add(listBoys.getGradesByLocation(loc));
        }
        /**
         * retornamos una respuesta indicando que la accion fue correcta y tambien retornaremos
         * toda la estructura de la tabla
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", gradeByLocationDTOS, null), HttpStatus.OK);
    }

    /**
     * respuesta que nos lanza al ordenar las localizaciones
     * @return retornamos una respuesta
     * @throws ListaDeException
     */
    public ResponseEntity<ResponseDTO>  orderLocation() throws ListaDeException
    {
        /**
         * creamos una lista temporal
         */
        ListDe listTemp = new ListDe();
        /**
         * creamos un ciclo que nos recorra las localizaciones
         */
        for (Location loc: locations)
        {
            /**
             * creamos una lista en donde se listaran en orden las localizaciones
             */
            ListDe listloc = this.listBoys.listDeLocation(loc);
            /**
             *  si la cabeza de nuestra lista tiene algun dato, nos agrega el node a la lista temporal
             */
            if(listloc.getHead()!=null){
                /**
                 * le agregamos los nodos a nuestra lista temporal
                 */
                listTemp.addNode(listloc.getHead());
            }
        }
        /**
         * retornamos una respuesta indicando que la lista
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", listTemp.listDe(), null), HttpStatus.OK);
    }

    /**
     * respuesta que le damos al metodo propuesto en clase de la tabla de listar y mostras los rh por grados
     * @return retornamos una respuesta satisfactoria a todo el proceso
     * @throws ListaDeException
     */
    public ResponseEntity<ResponseDTO>  getGenderByLocation() throws ListaDeException
    {
        /**
         * creamos una lista para almacenar todos los datos
         */
        List<GenderByLocationDTO> genderByLocationDTOS = new ArrayList<>();
        /**
         * recorremos las localizaciones
         */
        for (Location loc: locations)
        {
            /**
             * adicionaremos las localizaciones a nuestra lista
             */
            genderByLocationDTOS.add(listBoys.getGenderByLocation(loc));
        }
        /**
         * retornamos una respuesta indicando que la accion fue correcta y tambien retornaremos
         * toda la estructura de la tabla
         */
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", genderByLocationDTOS, null), HttpStatus.OK);
    }






    /*public ResponseEntity<ResponseDTO> getBoysByGenderOrphanDe()throws ListaDeException
    {
        /**
         * creamos una lista para guardar el genero con su cantidad
         */
    /*    List<BoysByGender> boysByGenders = new ArrayList<>();
        /**
         * hacemos un ciclo for que nis recorra la lista
         */
    /*    for(Gender1 gender:genders)
        {
            /**
             * recorremos la lista y va contando el genero por medio del codigo
             */
    /*        int count = listBoys.getCountBoysByGenderStructurDe(gender.getCode());
            /**
             * adicionamos cada genero contado es forma de lista con sus cantidades
             */
    /*        boysByGenders.add(new BoysByGender(gender,count));
        }
        /**
         * retornamos una respuesta indicando que la accion fue correcta
         */
    /*    return new ResponseEntity<>(new ResponseDTO("Satisfactorio",boysByGenders,null), HttpStatus.OK);
    }*/

    /*
    public ResponseEntity<ResponseDTO> ListForGradeAndGenderDe(byte grade, String code) throws ListaDeException
    {
        return new ResponseEntity<>(new ResponseDTO("Eliminado", listBoys.listForGradeAndGenderDe(grade,code), null), HttpStatus.OK);
    }*/

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
