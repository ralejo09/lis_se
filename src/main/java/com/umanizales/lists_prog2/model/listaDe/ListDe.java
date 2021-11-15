package com.umanizales.lists_prog2.model.listaDe;

import com.umanizales.lists_prog2.Exception.ListaDeException;
import com.umanizales.lists_prog2.controller.dto.*;
import com.umanizales.lists_prog2.model.*;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
/**
 * Clase creada que me permite gestionar la lista Doblemente Enlazadas
 * Esta clase contiene metodos, operaciones y atributos.
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class ListDe {
    /**
     * atributo head, representa al niño inicial, o al inicio de la lista
     */
    private Node head;
    /**
     * atributo count, cuenta la cantidad de niños que son registrados
     */
    private int count;

    //-----METODOS-----METODOS-----METODOS-----METODOS-----METODOS-----METODOS-----METODOS-----METODOS-----METODOS-----

    //METODO ADICIONAR AL FINAL

    /**
     * Metodo que me adiciona un niño al final de la lista
     *
     * @param boy niño con todos sus datos
     * @throws ListaDeException
     */
    public void addDe(Boy boy) throws ListaDeException {
        /**
         * Se llama el metodo que me busca los niños por la identificacion y me dice si el niño ya exite o no
         */
        Boy boyExist = findByIdDe(boy.getIdentification());
        /**
         * Se crea un if con el fin de indicarle al metodo que si  el niño ya existe me lance una Execepcion
         */
        if (boyExist != null) {
            /**
             * Si el niño ya existe se lanza una excepcion para que el usuario ya sepa que existe el niño
             */
            throw new ListaDeException("La identificacion ya existe");
        }
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño) es nula se cree un niño
         */
        if (head == null) {
            /**
             * Se crea un niño nuevo
             */
            head = new Node(boy);
        }
        /**
         * Se crea un else con el fin de indicarle al metodo que si la cabeza no es nula me adicione un niño
         */
        else {
            /**
             * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
             */
            Node temp = head;
            /**
             * Creo un ciclo para recorrer la lista DE de principio a fin
             * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
             */
            while (temp.getNext() != null) {


                /**
                 * el ayudante cambia al siguiente node de el que ya esta
                 */
                temp = temp.getNext();
            }
            /**
             * el ayudante ya debe de estar parado en el ultimo y se le indica que en el siguiente
             * del ultimo adicione un nuevo niño
             */
            temp.setNext(new Node(boy));
            /**
             * Le decimos al ayudante que su siguiente agarre al ayudante
             */
            temp.getNext().setPrevious(temp);
        }
        /**
         * incrementamos el contador con el fin de llevar el conteo de los niños
         */
        count++;
    }

    //METODO ADICIONAR AL INICIO

    /**
     * Metodo que me adiciona un niño al inicio de la lista
     *
     * @param boy niño con todos sus datos
     * @throws ListaDeException
     */
    public void addToStartDe(Boy boy) throws ListaDeException {
        /**
         * Se llama el metodo que me busca los niños por la identificacion y me dice si el niño ya exite o no
         */
        Boy boyExist = findByIdDe(boy.getIdentification());
        /**
         * Se crea un if con el fin de indicarle al metodo que si  el niño ya existe me lance una Execepcion
         */
        if (boyExist != null) {
            /**
             * Si el niño ya existe se lanza una excepcion para que el usuario ya sepa que existe el niño
             */
            throw new ListaDeException("La identificacion ya existe");
        }
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño) es nula se cree un niño
         */
        if (this.head == null) {
            /**
             * Se crea un niño nuevo
             */
            this.head = new Node(boy);
        }
        /**
         * Se crea un else con el fin de indicarle al metodo que si la cabeza no es nula me adicione un niño
         */
        else {
            /**
             * Se crea un niño nuevo
             */
            Node temp = new Node(boy);
            /**
             * El nuevo niño se lo asignamos a la cabeza
             */
            temp.setNext(this.head);
            /**
             * la cabeza va ser igual a lo que tenga el ayudante
             */
            this.head = temp;
            /**
             * al siguiente de la cabeza me coja la cabeza ;)
             */
            head.getNext().setPrevious(head);
        }
        /**
         * incrementamos el contador con el fin de llevar el conteo de los niños
         */
        count++;
    }

    //METODO ADICIONAR POR POSICION

    /**
     * Metodo que me adiciona un niño a la pocision dada en el parametro
     *
     * @param boy      niño con todos sus datos
     * @param position es el numero donde se va a adicionar a el niño
     * @throws ListaDeException
     */
    public void addPositionDe(Boy boy, int position) throws ListaDeException {
        /**
         * Se llama el metodo que me busca los niños por la identificacion y me dice si el niño ya exite o no
         */
        Boy boyExist = findByIdDe(boy.getIdentification());
        /**
         * Se crea un if con el fin de indicarle al metodo que si  el niño ya existe me lance una Execepcion
         */
        if (boyExist != null) {
            /**
             * Si el niño ya existe se lanza una excepcion para que el usuario ya sepa que existe el niño
             */
            throw new ListaDeException("La identificacion ya existe");
        }
        //validar posicion
        /**
         * Validamos si la posicion ingresada, es mayor a la catidad que tiene el contador
         */
        if (position > count) {
            /**
             * si la posicion ingresada es mayor, se llama el metodo de adicionar al final para que adicione
             * un nuevo niño
             */
            this.addDe(boy);
            return;
            //throw new ListaSeException("La posicion ingresada no es valida");
        }
        /**
         * validamos si la posicion ingresada es la 1
         */
        if (position == 1) {
            /**
             * si la posicion ingresada es la 1, llamamos al metodo de adicionar al inicio para que nos guarde
             * el niño en la primera posicion
             */
            addToStartDe(boy);
        }
        /**
         * sino
         */
        else {
            /**
             * inicializamos un contador(cont) en 1
             */
            int cont = 1;
            /**
             * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
             */
            Node temp = this.head;
            /**
             * Creo un ciclo para recorrer la lista DE de principio a fin
             * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
             */
            while (temp != null) {
                /**
                 * validamos si el contador(cont) es igual a la posicion ingresada menos 1
                 */
                if (cont == position - 1) {
                    /**
                     freanamos el ciclo
                     */
                    break;
                }
                /**
                 * el ayudante cambia al siguiente node de el que ya esta
                 */
                temp = temp.getNext();
                /**
                 * incrementamos el contador(cont)
                 */
                cont++;
            }
            /**
             * llamamos un ayudante nuevo para que nos adicione el niño nuevo
             */
            Node nodeNew = new Node(boy);
            /**
             * le decimos a nuestro nuevo ayudante que tome lo que tiene nuestro primer ayudante
             */
            nodeNew.setNext(temp.getNext());
            /**
             * le decimos a nuestro primer ayudante que coja el niño nuevo que tiene nuestro segundo ayudante
             */
            temp.setNext(nodeNew);
            /**
             * el que le sigue al nuevo nodo me tome al nuevo nodo
             */
            nodeNew.getNext().setPrevious(nodeNew);
            /**
             * el aterior del nuevo nodo tome a nuestro ayudante
             */
            nodeNew.setPrevious(temp);
            /**
             * incrementamos el contador con el fin de llevar el conteo de los niños
             */
            count++;
        }
    }

    //METODO PARA ENCONTRAR POR IDENTIFICACION

    /**
     * Se crea este metodo para poder encontrar a un niño por su identificacion
     *
     * @param id se pide que se ingrese la identificacion, porque es un dato unico de cada niño
     * @return retorna un null si no encuentra nada
     */
    public Boy findByIdDe(String id) {
        /**
         * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
         */
        Node temp = this.head;
        /**
         * Creo un ciclo para recorrer la lista DE de principio a fin
         * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
         */
        while (temp != null) {
            /**
             * creamos un if donde indicamos que a el dato que tiene el ayudante le tomamos la identificacion
             * y miramos si es igual a la identificacion ingresada
             */
            if (temp.getData().getIdentification().equals(id)) {
                /**
                 * retorna el niño o el dato que tiene nuestro ayudante
                 */
                return temp.getData();
            }
            /**
             * el ayudante cambia al siguiente node de el que ya esta
             */
            temp = temp.getNext();
        }
        /**
         * retornamos un null si no hay datos en la lista
         */
        return null;
    }

    //METODO PARA INVERTIR LA LISTA

    /**
     * metodo creado para invertir la lista
     *
     * @throws ListaDeException
     */
    public void invertListDe() throws ListaDeException {
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño) es nula,
         * no hay datos en la lista
         */
        if (this.head != null) {
            /**
             * Cojemos la lista que ya tenemos y le cremos una temporal
             */
            ListDe listTemp = new ListDe();
            /**
             * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
             */
            Node temp = this.head;
            /**
             * Creo un ciclo para recorrer la lista DE de principio a fin
             * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
             */
            while (temp != null) {
                /**
                 * a la lista temporal le asignamos de primero lo que tiene el ayudante
                 */
                listTemp.addToStartDe(temp.getData());
                /**
                 * el ayudante cambia al siguiente node de el que ya esta
                 */
                temp = temp.getNext();
            }
            /**
             * la cabeza agarra la lista temporal para poderla mostrar invertida
             */
            this.head = listTemp.getHead();
        }

    }

    //METODO PARA CONTAR

    /**
     * cremos un metodo que nos cuente la cantidad de niños
     *
     * @return se retorna la cantidad
     */
    public int countDe() {
        /**
         * inicializamos un contador(cont) en 0
         */
        int cont = 0;
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño)
         * es nula se retorna el contador en 0
         */
        if (this.head != null) {
            /**
             * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
             */
            Node temp = this.head;
            /**
             * Creo un ciclo para recorrer la lista DE de principio a fin
             * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
             */
            while (temp != null) {
                /**
                 * incrementamos el contador(cont)
                 */
                cont++;
                /**
                 * el ayudante cambia al siguiente node de el que ya esta
                 */
                temp = temp.getNext();
            }
        }
        /**
         * retornamos la cantidad de niños
         */
        return cont;
    }

    //METODO PARA LISTAR LOS NIÑOS

    /**
     * Creamos un metodo que nos liste todos los datos(niños) que ya tenemos
     *
     * @return retorna la lista aramadita
     * @throws ListaDeException
     */
    public List<Boy> listDe() throws ListaDeException {
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño) es nula, retorne
         * que no hay datos en la lista
         */
        if (this.head != null) {
            /**
             * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
             */
            Node temp = this.head;
            /**
             * creamos una lista, para ubicar todos los niños en ella
             */
            List<Boy> list = new ArrayList<>();
            /**
             * Creo un ciclo para recorrer la lista DE de principio a fin
             * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
             */
            while (temp != null) {
                /**
                 * agregamos a la lista el dato que tiene el ayudante en su momento
                 */
                list.add(temp.getData());
                /**
                 * el ayudante cambia al siguiente node de el que ya esta
                 */
                temp = temp.getNext();
            }
            /**
             * retornamos la lista
             */
            return list;
        }
        /**
         * si la cabeza no tiene ningun dato se retorna esta excepcion, para indicar
         * que no hay niños o que no hay datos existentes
         */
        throw new ListaDeException("no hay datos en la lista");
        //return null;
    }

    //METODO CAMBIAR EXTREMOS

    /**
     * creamos este metodo para hacer el cambio de ubicacion de los extremos osea el primer y ultimo niño
     *
     * @throws ListaDeException
     */
    public void changeXtremesDe() throws ListaDeException {
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño) es nula
         * Y si el que sigue de la cabeza tambien es null, esto va a retornar que no es posible hacer el cambio.
         * pero si no es nulo entra al if y continua su operacion
         */
        if (this.head != null && this.head.getNext() != null) {
            //Sacar niño de la cabeza
            /**
             * se crea una variable para indicar que en este se va a almacenar el primer niño
             */
            Boy start = this.head.getData();
            /**
             * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
             */
            Node temp = head;
            /**
             * Creo un ciclo para recorrer la lista DE de principio a fin
             * hasta llegar al niño antes del ultimo, ya que el ultimo en su siguiente seria nulo
             */
            while (temp.getNext() != null) {
                /**
                 * el ayudante cambia al siguiente node de el que ya esta
                 */
                temp = temp.getNext();
            }
            /**
             * la cabeza obtiene el dato que tiene el ayudante
             */
            this.head.setData(temp.getData());
            /**
             * el ayudante que esta ubicado en el ultimo dato toma el dato que tiene start que seria el primer niño
             */
            temp.setData(start);
        }
        /**
         * sino
         */
        else {
            /**
             * si la cabeza no tiene ningun dato y si su siguiente tampoco tiene ningun dato,
             * se retorna esta excepcion para indicar que no es posible hacer el cambio de los extremos
             */
            throw new ListaDeException("No es posible ejecutar el cambio de extremos");
        }
    }

    //METODO DE ELIMINAR

    /**
     * se crea este metodo para eliminar un dato de la lista
     *
     * @param identification se pide que se ingrese la identificacion, porque es un dato unico de cada niño
     * @throws ListaDeException
     */
    public void deleteDe(String identification) throws ListaDeException {
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño) es nula, retorne
         * que no hay datos en la lista
         */
        if (this.head != null) {
            /**
             * Se crea un if con el fin de indicarle al metodo que de el dato que tiene la cabeza, si la
             * identificacion es igual a la identificacion ingresada entra al if y continua su operacion
             */
            if (this.head.getData().getIdentification().equals(identification)) {
                /**
                 * le asigna a la cabeza lo que hay en su siguiente
                 */
                this.head = this.head.getNext();
                /**
                 *
                 */
                if (head != null) {
                    /**
                     *
                     */
                    this.head.setPrevious(null);
                }
                /**
                 *
                 */
                count--;
            }
            /**
             * sino
             */
            else {
                /**
                 * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
                 */
                Node temp = this.head;
                /**
                 * Creo un ciclo para recorrer la lista DE de principio a fin
                 * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
                 */
                while (temp != null) {
                    /**
                     * a el dato que tiene actualmente el ayudante se le va a analizar si su siguien te es nulo y si
                     * la identificacion del siguiente es igual a la identificacion ingresada
                     */
                    if (temp.getNext() != null && temp.getNext().getData().getIdentification().equals(identification)) {
                        /**
                         * se pararia en el anterior al que se quiere eliminar
                         */
                        break;
                    }
                    /**
                     * el ayudante cambia al siguiente node de el que ya esta
                     */
                    temp = temp.getNext();
                }
                /**
                 * se crea este id donde el ayudante debe de ser diferente de nulo, sino se manda una excepcion
                 */
                if (temp != null) {
                    /**
                     * el ayudante toma al siguiente del siguiente para que el siguiente quede eliminado
                     */
                    temp.setNext(temp.getNext().getNext());
                    temp.getNext().setPrevious(temp);
                    count--;
                }
                /**
                 * sino
                 */
                else {
                    /**
                     * se retorna esta excepxion si nuestro ayudante no tiene nada, para indicarnos que la
                     * identificacion ingresada no existe
                     */
                    throw new ListaDeException("La identificacion " + identification + " no existe en la lista");
                }
            }
        }
        /**
         * sino
         */
        else {
            /**
             * se llama este metodo que nos indica que no hay datos en la lista
             */
            validateListEmpty();
        }
    }

    //METODO QUE NOS RETORNA UNA LISTA POR GENERO QUE LE INGRESEMOS

    /**
     * se crea el metodo con el fin de generar una ista dependiendo al genero que le ingresemos por parametro
     *
     * @param gender parametro que necesitamos para evaluar y poder sacar la lista
     * @return retorna una lista dependiendo del genero
     * @throws ListaDeException
     */
    public ListDe getListSeBoysByGenderDe(String gender) throws ListaDeException {
        /**
         * llamamos este metodo para indicar si la lista tiene algo o no
         */
        validateListEmpty();
        /**
         * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
         */
        Node temp = this.head;
        /**
         * creamos una lista temporal
         */
        ListDe listTemp = new ListDe();
        /**
         * Creo un ciclo para recorrer la lista DE de principio a fin
         * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
         */
        while (temp != null) {
            /**
             * creamos el if para evaluar el dato que tiene el ayudante agarrado, a ese dato le evaluamos
             * de que genero es y si es igual a el que se le ingreso
             */
            if (temp.getData().getGender().getDescription().equals(gender)) {
                /**
                 * si el genero es igual al que se le ingreso llamamos al metodo adicionar y le decimos que
                 * nos adicione el que tiene el ayudante a la lista temporal
                 */
                listTemp.addDe(temp.getData());
            }
            /**
             * el ayudante cambia al siguiente node de el que ya esta
             */
            temp = temp.getNext();
        }
        /**
         * retornamos la lista temporal
         */
        return listTemp;
    }

    //METODO QUE INTERCALA LOS NIÑOS POR GENERO

    /**
     * creamos un metodo que nos intercale los niños por edades segun el genero que le ingresemos
     *
     * @throws ListaDeException
     */
    public void variantBoysDe() throws ListaDeException {
        /**
         * llamamos este metodo para indicar si la lista tiene algo o no
         */
        validateListEmpty();
        /**
         * se toma la lista de los niños, llamando al metodo de ontener lista por genero
         */
        ListDe kids = this.getListSeBoysByGenderDe("MASCULINO");
        /**
         * se toma la lista de los niñas, llamando al metodo de ontener lista por genero
         */
        ListDe girls = this.getListSeBoysByGenderDe("FEMENINO");
        /**
         * inicializamos variables para poner la lista que menos niños tenga, para saber la minList
         */
        ListDe minList = null;
        /**
         * inicializamos variables para poner la lista que mas niños tenga, para saber la maxlist
         */
        ListDe maxList = null;
        /**
         * creamos el if llamando el metodo que nos cuenta la cantidad para saber si la cantidad de
         * los niños es mayor a la cantidad de las niñas
         */
        if (kids.getCount() > girls.getCount()) {
            /**
             * si la lista de los niños es mayor, tomamos primero la lista menor que seria la de las niñas
             * y luego la lista mayor que seria la de los niños
             */
            minList = girls;
            maxList = kids;
        } else {
            /**
             * si la lista de las niñas es mayor, tomamos primero la lista menor que seria la de los niños
             * y luego la lista mayor que seria la de las niñas
             */
            minList = kids;
            maxList = girls;
        }
        /**
         * llamamos a un ayudante para que nos coja la lista menor y no la asigne a la cabeza
         */
        Node temp = minList.getHead();
        /**
         * inicializamos una variable llamada pos en 2
         */
        int pos = 2;
        /**
         * Creo un ciclo para recorrer la lista DE de principio a fin
         * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
         */
        while (temp != null) {
            /**
             * tomamos la lista mayor y llamamos al adicionar por posicion, le damos el dato que tiene nuestro
             * ayudante y la posicion que inicializamos en 2
             */
            maxList.addPositionDe(temp.getData(), pos);
            /**
             * le decimos a la posicion que se incremente de 2 en 2 para poder que quede intercalado
             */
            pos = pos + 2;
            /**
             * el ayudante cambia al siguiente node de el que ya esta
             */
            temp = temp.getNext();
        }
        /**
         * la lista mayor la tiene la cabeza
         */
        this.head = maxList.getHead();
    }

    //METODO QUE NOS CUENTA LA CANTIDAD POR MUNICIPIO

    /**
     * creamos un metodo que nos permitira saber cuantos niños hay por cada localizacion
     *
     * @param code le entra como parametro el codigo de la localizacion
     * @return retorna una lista con la cantidad por municipios
     */
    public int getCountBoysByLocationDe(String code) {
        /**
         * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
         */
        Node temp = this.getHead();
        /**
         * inicializamos un contador en 0
         */
        int count = 0;
        /**
         * Creo un ciclo para recorrer la lista DE de principio a fin
         * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
         */
        while (temp != null) {
            /**
             * tomamos el dato que tenga el ayudante y miramos la localizacion y a la localizacion le miramos el codico
             * y miramos si es igual al que le entramos por parametro
             */
            if (temp.getData().getLocation().getCode().equals(code)) {
                /**
                 * incrementamos el contador de la localizacion en la que este el ayudante
                 */
                count++;
            }
            /**
             * el ayudante cambia al siguiente node de el que ya esta
             */
            temp = temp.getNext();
        }
        /**
         * retornamos el calculo del incremento de el contador, para cada localizacion
         */
        return count;
    }

    //METODO QUE NOS CUENTA LA CANTIDAD POR GENERO

    /**
     * creamos un metodo que nos permitira saber cuantos niños hay por cada genero
     *
     * @param code le entra como parametro el codigo del genero
     * @return retorna una lista con la cantidad por genero
     */
    public int getCountBoysByGenderDe(String code) {
        /**
         * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
         */
        Node temp = this.getHead();
        /**
         * inicializamos un contador en 0
         */
        int count = 0;
        /**
         * Creo un ciclo para recorrer la lista DE de principio a fin
         * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
         */
        while (temp != null) {
            /**
             * tomamos el dato que tenga el ayudante y miramos el genero y al genero le miramos el codico
             * y miramos si es igual al que le entramos por parametro
             */
            if (temp.getData().getGender().getCode().equals(code)) {
                /**
                 * incrementamos el contador del genero en el que este el ayudante
                 */
                count++;
            }
            /**
             * el ayudante cambia al siguiente node de el que ya esta
             */
            temp = temp.getNext();
        }
        /**
         * retornamos el calculo del incremento de el contador, para cada localizacion
         */
        return count;
    }

    //METODO QIE NOS LISTA POR EDAD Y POR LOCALIZACION

    /**
     * creamos un metodo que dada la edad y la localizacion nos liste los niños que pertenezcan a esta localizacion
     * y que su edad sea menos o igual a la dada
     *
     * @param age  le entra como parametro el edad del niño
     * @param code le entra como parametro el codigo del la localizacion
     * @throws ListaDeException
     */
    public void listForAgeAndLocationsDe(int age, String code) throws ListaDeException {
        /**
         * llamamos este metodo para indicar si la lista tiene algo o no
         */
        validateListEmpty();
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño) es nula, retorne
         * que no hay datos en la lista
         */
        if (this.head != null) {
            /**
             * Cojemos la lista que ya tenemos y le cremos una temporal
             */
            ListDe listTemp = new ListDe();
            /**
             * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
             */
            Node temp = this.head;
            /**
             * Creo un ciclo para recorrer la lista DE de principio a fin
             * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
             */
            while (temp != null) {
                /**
                 * tomamos el dato que tenga el ayudante y miramos si la edad es menor o igual a la ingresada
                 * y si ademas el codigo de la localizacion es correcto, si es correcto lo adicionamos al inicio
                 * de la nueva lista temporal
                 */
                if (temp.getData().getAge() <= age && temp.getData().getLocation().getCode().equals(code)) {
                    listTemp.addToStartDe(temp.getData());
                }
                /**
                 * el ayudante cambia al siguiente node de el que ya esta
                 */
                temp = temp.getNext();
            }
            /**
             * le decimos a la cabeza que agarre nuestra nueva lista temporal
             */
            this.head = listTemp.getHead();
        }
    }

    //METODO QUE NOS LISTA AL INICIO DE LA LISTA LOS NIÑOS POR EDAD Y EL GENERO

    /**
     * creamos un metodo que dada la edad y su genero nos liste los niños al inicio de la lista
     * que tengan el mismo genero y que su edad sea menor o igual a la dada
     *
     * @param age  le entra como parametro el edad del niño
     * @param code le entra como parametro el codigo del genero
     * @throws ListaDeException
     */
    public void listForAgeAndGenderDe(int age, String code) throws ListaDeException {
        /**
         * llamamos este metodo para indicar si la lista tiene algo o no
         */
        validateListEmpty();
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño) es nula, retorne
         * que no hay datos en la lista
         */
        if (this.head != null) {
            /**
             * Cojemos la lista que ya tenemos y le cremos una temporal
             */
            ListDe listTemp = new ListDe();
            /**
             * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
             */
            Node temp = this.head;
            /**
             * Creo un ciclo para recorrer la lista DE de principio a fin
             * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
             */
            while (temp != null) {
                  /*if(temp.getData().getAge()!=age){
                    throw new ListaSeException("No es posible hacer la busqueda pruebe otros datos");
                 }*/
                /**
                 * tomamos el dato que tenga el ayudante y miramos si la edad es menor o igual a la ingresada
                 * y si ademas el codigo del genero es correcto, si es correcto lo adicionamos al inicio
                 * de la nueva lista temporal
                 */
                if (temp.getData().getAge() <= age && temp.getData().getGender().getCode().equals(code)) {
                    /**
                     * le decimos a nuestro ayudante que lo adicione al inicio de nuestra lista temporal
                     */
                    listTemp.addToStartDe(temp.getData());
                }
                /**
                 * sino
                 */
                else {
                    /**
                     * tomamos el dato que tenga el ayudante y lo adicionamos al final de la nueva lista temporal
                     */
                    listTemp.addDe(temp.getData());
                }
                /**
                 * el ayudante cambia al siguiente node de el que ya esta
                 */
                temp = temp.getNext();
            }
            /**
             * le decimos a la cabeza que agarre nuestra nueva lista temporal
             */
            this.head = listTemp.getHead();
        }
    }

    //METODO QUE ME ELIMINA A LOS NIÑOS MAYORES A LA EDAD DADA

    /**
     * Creamos un metodo para que dada una edad el metodo me borre a los que tengan una edad mayor a la ingresada
     *
     * @param age le entra como parametro el edad del niño
     * @throws ListaDeException
     */
    public void deleteForAgeDe(byte age) throws ListaDeException {
        /**
         * llamamos este metodo para indicar si la lista tiene algo o no
         */
        validateListEmpty();
        /**
         * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
         */
        Node temp = this.head;
        /**
         * Creo un ciclo para recorrer la lista DE de principio a fin
         * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
         */
        while (temp != null) {
            /**
             * tomamos el dato que tenga el ayudante y miramos si la edad es mayor a la suministrada
             */
            if (temp.getData().getAge() > age) {
                /**
                 * si si es mayor borramos a los niños mayores
                 */
                deleteDe(temp.getData().getIdentification());
            }
            /**
             * el ayudante cambia al siguiente node de el que ya esta
             */
            temp = temp.getNext();
        }
    }

    //METODO QUE ELIMINA A TODOS LOS NIÑOS DE UN GENERO DE LA LISTA

    /**
     * creamos un metodo para que dado un genero por el codigo, nos retire a todos los de ese genero de la lista
     *
     * @param code le entra como parametro el codigo del genero
     * @throws ListaDeException
     */
    public void deleteForGenderDe(String code) throws ListaDeException {
        /**
         * llamamos este metodo para indicar si la lista tiene algo o no
         */
        validateListEmpty();
        /**
         * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
         */
        Node temp = this.head;
        /**
         * Creo un ciclo para recorrer la lista DE de principio a fin
         * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
         */
        while (temp != null) {
            /**
             * tomamos el dato que tenga el ayudante y miramos si el codigo del genero pertenece al codigo ingresado
             */
            if (temp.getData().getGender().getCode().equals(code)) {
                /**
                 * si pertenece el codigo a algun genero lo retira, la idea es retirar todos los del mismo genero
                 */
                deleteDe(temp.getData().getIdentification());
            }
            /**
             * el ayudante cambia al siguiente node de el que ya esta
             */
            temp = temp.getNext();
        }
    }

    //METODO QUE PERMITE LISTAR A TODOS LOS NIÑOS POR EL GRADO

    /**
     * Creamos un metodo para que dado un grado me liste a los niños pertenecientes a ese grado
     *
     * @param grade parametro ingresado para saber el grado que debe de buscar y listar
     * @throws ListaDeException
     */
    public void listForGradeDe(byte grade) throws ListaDeException {
        /**
         * llamamos este metodo para indicar si la lista tiene algo o no
         */
        validateListEmpty();
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño) es nula, retorne
         * que no hay datos en la lista
         */
        if (this.head != null) {
            /**
             * Cojemos la lista que ya tenemos y le cremos una temporal
             */
            ListDe listTemp = new ListDe();
            /**
             * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
             */
            Node temp = this.head;
            /**
             * Creo un ciclo para recorrer la lista DE de principio a fin
             * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
             */
            while (temp != null) {
                /**
                 * tomamos el dato que tenga el ayudante y miramos si el grado es igual al grado ingresado
                 */
                if (temp.getData().getGrade() == grade) {
                    /**
                     * le decimos a nuestro ayudante que lo adicione al inicio de nuestra lista temporal
                     */
                    listTemp.addToStartDe(temp.getData());
                }
                /**
                 * el ayudante cambia al siguiente node de el que ya esta
                 */
                temp = temp.getNext();
            }
            /**
             * le decimos a la cabeza que agarre nuestra nueva lista temporal
             */
            this.head = listTemp.getHead();
        }
    }

    //Metodo que nos ordena todos los niños por edad

    /**
     * Creamos un metodo con el fin de ordenar todos los niños de menor a mayor segun su edad
     *
     * @throws ListaDeException
     */
    public void orderBoysAgeDe() throws ListaDeException {
        /**
         * llamamos este metodo para indicar si la lista tiene algo o no
         */
        validateListEmpty();
        /**
         * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
         */
        Node temp = this.head;
        /**
         * Creo un ciclo para recorrer la lista DE de principio a fin
         * llego al final cuando mi ayudante ya quede parado el el niño antes del ultimo niño antes del null
         */
        while (temp.getNext() != null) {
            /**
             * tomamos el dato que tenga el ayudante y miramos si la edad es mayor a la edad del siguiente
             */
            if (temp.getData().getAge() > temp.getNext().getData().getAge()) {
                /**
                 * creamos un espacio para el niño que tiene nuestro ayudante mayor al niño siguiente
                 */
                Boy boy = temp.getData();
                /**
                 * borramos al que tiene agarrado el ayudante, porque ya lo guardamos en otro espacio
                 */
                deleteDe(temp.getData().getIdentification());
                /**
                 * adicionamos al niño que tenemos separado al final de la lista
                 */
                addDe(boy);
                /**
                 * nuestro ayudante vuelve y va a la cabeza
                 */
                temp = this.head;
            }
            /**
             * sino
             */
            else {
                /**
                 * el ayudante cambia al siguiente node de el que ya esta
                 */
                temp = temp.getNext();
            }
        }
    }

    //METODO QUE ME BORRA SEGUN UNA POSICION INGRESADA

    /**
     * Creamos un metodo con el fin de borrar un niño de una posicion ingresada
     *
     * @param position es el parametro que le ingresamos para poder saber la posicion a eliminar
     * @throws ListaDeException
     */
    public void deleteByPositionDe(int position) throws ListaDeException {
        /**
         * llamamos este metodo para indicar si la lista tiene algo o no
         */
        validateListEmpty();
        /**
         * tomamos la posicion ingresada y comparamos si es mayor que el contador
         */
        if (position > count) {
            /**
             * si la posicion es mayor que el contador retornamos una excepcion indicando que la posicion no es valida
             */
            throw new ListaDeException("la posicion no es valida");
        }
        /**
         * tomamos la posicion ingresada y comparamos si es igual a 1
         */
        if (position == 1) {
            /**
             * borramos lo que tenga la cabeza ya que este seria la primera posicion
             */
            deleteDe(head.getData().getIdentification());
        }
        /**
         * sino
         */
        else {
            /**
             * iniciamos un contador en 1
             */
            int cont = 1;
            /**
             * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
             */
            Node temp = this.head;
            /**
             * Creo un ciclo para recorrer la lista DE de principio a fin
             * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
             */
            while (temp != null) {
                /**
                 * tomamos el contador y evaluamos si es igual a la posicion que tenemos -1, si esto pasa
                 * frenamos el condicional
                 */
                if (cont == position - 1) {
                    break;
                }
                /**
                 * el ayudante cambia al siguiente node de el que ya esta
                 */
                temp = temp.getNext();
                /**
                 * incrementamos el contador
                 */
                cont++;
            }
            /**
             * borramos el dato que tenga el ayudante en su momento, porque ese dato seria el de la posicion ingresada
             */
            deleteDe(temp.getNext().getData().getIdentification());
        }
    }

    /**
     * creamos un metodo que nos permitira filtrar una informacion como si estuviera puesta en alguna tabla
     * @param grade el parametro grado es unos de los requisitos que tiene la tabla
     * @param location el parametro de localizacaion es importante, pues la localizacion viene ciendo un valot
     *                 muy importante, solicitado para la tabla
     * @return nos retorna la repuesta de la lista bien conformada
     * @throws ListaDeException
     */
    public GendersByGradesDTO listForGradeAndGenderDe(byte grade, Location location) throws ListaDeException {
        /**
         * llamamos este metodo para indicar si la lista tiene algo o no
         */
        validateListEmpty();
        /**
         * creamos una lista paea listar ni niños de un grado por un genero
         */
        List<CountByGenderDTO> countByGenderDTOS = new ArrayList<>();
        /**
         * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
         */
        Node temp = this.head;
        /**
         * inicializamos un contador en 0 el cual me va a hacer un conteo en todo momento sin importar el
         * sexo
         */
        int count = 0;
        /**
         * inicializamos un contador el sucal se va ir incrementando 1 por 1 siempre mirando de que genero
         * pertenece, en este caso es el contador de mujeres
         */
        int countF = 0;
        /**
         * inicializamos un contador el sucal se va ir incrementando 1 por 1 siempre mirando de que genero
         * pertenece, en este caso es el contador de hombres
         */
        int countM = 0;

        /**
         * Creo un ciclo para recorrer la lista DE de principio a fin
         * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
         */
        while (temp != null) {
            /**
             * Se evalua si el dato en el que esta parado tiene la misma localizacion del metodo y si el grado
             * igual al dado por el metodo
             */
            if (temp.getData().getLocation().getCode().equals(location) && temp.getData().getGrade() == grade) {
                /**
                 * incrementamos el contador general
                 */
                count++;
                /**
                 * se valida si el niño es huerfano
                 */
                if (temp.getData().isOrphan()) {
                    /**
                     * si el nixo es huerfano, se valida a que genero pertenece, si es una mujer
                     */
                    if (temp.getData().getGender().getCode().equals("2")) {
                        /**
                         * se incrementa el contador de las mujeres
                         */
                        countM++;
                        /**
                         * sino
                         */
                    } else {
                        /**
                         * se inchrementa el contador de los hombres
                         */
                        countF++;
                    }
                }
            }
            /**
             * el ayudante cambia al siguiente node de el que ya esta
             */
            temp = temp.getNext();
        }
        /**
         * cremoa una estructura de la lista como respuesta para nuestro DTO, donde enviaremos el tipo
         * de genero y su contador respectivo
         */
        countByGenderDTOS.add(new CountByGenderDTO("2", countM));
        countByGenderDTOS.add(new CountByGenderDTO("1", countF));

        /**
         * creamos una estructura de la lista como respuesta a nuestra lista donde se mostrara el grado,
         * luego el genero con la cantidad de niños y luego el conteo de todos los niños sin importar el
         * genero
         */
        GendersByGradesDTO genderByGradeDTO = new GendersByGradesDTO(grade, countByGenderDTOS, count);

        /**
         * retornamos esta respuesta y estructura
         */
        return genderByGradeDTO;
    }

    /**
     * creamos un metodo que nos va a recorrerla lista y nos va a ubicar los grados 1 por 1
     * @param location nos entra como parametro la localizacion, pues la ibicacion de los grados se hara
     * por cada municipio
     * @return retornamos la estructura de la lita
     * @throws ListaDeException
     */
    public GradesByLocationDTO getGradesByLocation(Location location) throws ListaDeException {
        /**
         * creamos una lista en donde generaremos una respuesta de una estructura
         */
        List<GendersByGradesDTO> genderByGradeDTOS = new ArrayList<>();
        /**
         * recorremos la cantidad de grados, con el fin de que nos enseñe los grados del 1 al 5
         */
        for (byte i = 1; i <= 5; i++) {
            /**
             *  por cada grado se creara su numero y su localizacion
             */
            genderByGradeDTOS.add(listForGradeAndGenderDe(i, location));
        }
        /**
         * crearemos la nueva estructura mostrando primero el municipio y luego la estructura que hicimos con el
         * de generos por grado
         */
        GradesByLocationDTO gradeByLocationDTO = new GradesByLocationDTO(location, genderByGradeDTOS);
        /**
         * returnamos esta respuesta
         */
        return gradeByLocationDTO;
    }

    /**
     * creammos un metodo que nos adiciona un nodo
     * @param nodeint recibimos como parametro el nodo
     * @throws ListaDeException
     */
    public void addNode(Node nodeint)throws ListaDeException{
        /**
         * decimos que si la cabeza es igual a null no coloque lo que ya tenemos
         */
        if(this.head == null){
            /**
             * nodo int es la lista ya existente
             *
             */
            this.head = nodeint;
        }
        /**
         * sino
         */
        else {
            /**
             * llamamos un ayudante
             */
            Node temp = head;
            /**
             * creamos un ciclo que nos recorra la lista hasta parar en el ultimo
             */
            while (temp.getNext() != null) {
                /**
                 * ya estamos parados en el ultimo
                 */
                temp = temp.getNext();
            }
            /**
             * le decimos a nuestro ayudante que tome el nodo
             */
            temp.setNext(nodeint);
            /**
             * el nodo agarra a su anterior que es el temp
             */
            nodeint.setPrevious(temp);
        }
    }

    /**
     * creamos un metodo que nos de una lista por cada localizacion
     * @param location parametro que solicita el metodo
     * @return retorna la lista de cada lozalizacion
     * @throws ListaDeException
     */
    public ListDe listDeLocation (Location location)throws ListaDeException{
        /**
         * validamos que la lista tenga datos
         */
        validateListEmpty();
        /**
         * creamos una lista temporal
         */
        ListDe listemp = new ListDe();
        /**
         * llamamos un ayudante
         */
        Node temp = this.head;
        /**
         * creamos un ciclo para recorrer la lista
         */
        while(temp!= null){
            /**
             * los que sean iguales a la localizacion entregada
             */
            if (temp.getData().getLocation().equals(location)){
                /**
                 * los agrega ese dato a la lista temporal
                 */
                listemp.addDe(temp.getData());
            }
            /**
             * nuestro ayudante pasa a el siguiente
             */
            temp = temp.getNext();
        }
        /**
         * retornamos la lista
         */
        return listemp;
    }

    /**
     * crearemos un metodo que nos listara los genereros por su codigo correspondiente, pero los niños
     * se agregaran de primeros y las niñas despues
     * @throws ListaDeException
     */
    public void listBoysForCode() throws ListaDeException{
        /**
         * validamos que la lista no este vacia
         */
        validateListEmpty();
        /**
         * llamamos un ayudante
         */
        Node temp=this.head;
        /**
         * crearemos una lista temporal donde se ira organizando los datos con queremos
         */
        ListDe listTemp = new ListDe();
        /**
         * recorremos la lista
         */
        while (temp!= null){
            /**
             * validamos si el condigo del genero del dato que tiene nuestro ayudante es igual a el codigo
             * del genero del niño
             */
            if(temp.getData().getGender().getCode().equals("2")){
                /**
                 * adicionamos al inicio a nuestro dato si es niño
                 */
                listTemp.addToStartDe(temp.getData());
                /**
                 * sino
                 */
            }else{
                /**
                 * adicionamos al niño al final
                 */
                listTemp.addDe(temp.getData());
            }
            /**
             * nuestro ayudante pasa a el siguiente
             */
            temp=temp.getNext();
        }
        /**
         * le asiganamos a nuestra cabeza la nueva lista temporal
         */
        this.head = listTemp.getHead();
    }

    /**
     * crearemos un metodo donde obtendremos los rh por el grado ingresado, teniendo encuenta que en la
     * tabla va tambien por genero
     * @param grade tedremos en cuentra el parametro de los grados para que dependiendo de su grado se opere
     * con el nodo
     * @param gender tendremos como parametro el genero con el fin de hacer el conteo y mostrar el resultado
     * por cada genero
     * @return retornaremos una respuesta de una estructura
     * @throws ListaDeException
     */
    public RhByGradesDTO getGradesRhDTOByGrades(byte grade,Gender1 gender)throws ListaDeException{
        /**
         * validamos que la lista tenga datos
         */
        validateListEmpty();
        /**
         * llamamos un ayudante
         */
        Node temp = this.head;
        /**
         * inicializamos una variable para el RH porque la idea es mostrar los rh pertenecientes a ese grado
         */
        String rh = " ";
        /**
         * inicializaremos un contador el cual nos contara la cantidad de niños por grado
         */
        int count = 0;
        /**
         * creamos un ciclo para recorrer la lista
         */
        while (temp != null){
            /**
             * validamos si el grado del dato que tiene nuestro ayudante es igual al grado en el que esta parado y
             * si el codigo del genero del dato en el que tiene nuestro ayudante es igual a el codigo en el que esta
             * parado
             */
            if(temp.getData().getGrade() == grade && temp.getData().getGender().getCode().equals(gender.getCode())) {
                /**
                 * si el rh es diferente a lo que contiene nuestro dato en su rh
                 */
                if (!rh.contains(temp.getData().getRh())) {
                    /**
                     * me va a comenzar a ubicar el rh uno por uno sin repetirlo, pero si separados por una ","
                     */
                    rh = rh + ", " + temp.getData().getRh();
                }
                /**
                 * retornamos el contador que nos dira la cantidad por grado
                 */
                count++;
            }
            /**
             * nuestro ayudante pasa a el siguiente
             */
            temp = temp.getNext();
        }
        /**
         * retornamos la lista de nuestro rh por cada grado, con si estructura en  la cual primero enseñara
         * el grado, luego el rh separados por comas, y por ultimo la cantidad por grado
         */
        return new RhByGradesDTO(grade,rh,count);
    }

    /**
     * creamos un metodo en el que obtendremos los grados por el genero
     * @param gender tendremos en cuenta este parametro porque de acuerdo al genero se ubicara cada dato
     * @return retornaremos la respueta, la estructura de la lista
     * @throws ListaDeException
     */
    public GradesByGenderDTO getGradesByGenderDTO(Gender1 gender)throws ListaDeException{
        /**
         * validamos que la lista tenga datos
         */
        validateListEmpty();
        /**
         * creamos un arreglo con un tamaño de 5 posiciones
         */
        RhByGradesDTO[] rhByGradesDTOS = new RhByGradesDTO[5];
        /**
         * recorreremos las 5 posiciones
         */
        for (byte i = 0; i < 5; i++) {
            /**
             * por cada posicion ubicaremos el grado y el genero al que pertenece
             */
            rhByGradesDTOS[i]= getGradesRhDTOByGrades((byte)(i+1),gender);
        }
        /**
         * retornaremos la estructura donde tendremos primero el genero y luego nuestra estructura de
         * grados por rh
         */
        return new GradesByGenderDTO(gender,rhByGradesDTOS);
    }

    /**
     * creamos un metodo el cual nos pondra los generos por la localizacion
     * @param location ingresaremos como parametro la locacizacion para poder ubicar los niños por municipio
     * @return retornamos la respuesta, la estrutura de nuestro listado
     * @throws ListaDeException
     */
    public GenderByLocationDTO getGenderByLocation(Location location) throws ListaDeException {
        /**
         * validamos que la lista tenga datos
         */
        validateListEmpty();
        /**
         * crearemos una lista de gradod por cada Genero
         */
        List<GradesByGenderDTO> gradesByGenderDTOS = new ArrayList<>();
        /**
         * crearemos un contador, el cual sera la cantidad total de los niños por cada localizacion
         */
        int count = 0;
        /**
         * llamamos un ayudante
         */
        Node temp = head;
        /**
         * creamos un ciclo para recorrer la lista
         */
        while (temp != null){
            /**
             * validamos si el dato en que se encuentra nuestro ayudante tiene una localizacion igual a la
             * que en este momento esta parado
             */
            if (temp.getData().getLocation().getCode().equals(location.getCode())) {
                /**
                 * crearemos un genero teneiendo en cuenta los valores que nos esta dando nuestro ayudante
                 */
                gradesByGenderDTOS.add(getGradesByGenderDTO(temp.getData().getGender()));
                /**
                 * incrementamos el contador, para saber cuantos hay en esta localizacion
                 */
                count++;
            }
            /**
             * nuestro ayudante pasa a el siguiente
             */
            temp = temp.getNext();
        }
        /**
         * creamos nuestra nueva estructura, la cual tendra la localizacion, luego el genero con sus grados
         * y sus rh, luego tendremos el contador que nos dara la cantidad en la localizacion
         */
        GenderByLocationDTO genderByLocationDTO = new GenderByLocationDTO(location,gradesByGenderDTOS, count);
        /**
         * retornaremos ya la estructura completa
         */
        return genderByLocationDTO;
    }


    ////////////////////////

    //METODO QUE NOS VALIDA SI SI HAY DATOS EN LA LISTA
    /**
     * creamos el metodo para evaluar si en la lista hay 1 o mas datos
     * @throws ListaDeException se lanza la excepcion en caso de no haber datos
     */
    public void validateListEmpty() throws ListaDeException
    {
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño) es nula, retorne
         * que no hay datos en la lista
         */
        if(this.head==null)
        {
            /**
             * se crea la excepcion para responder el mensage (no hay datos en la lista)
             */
            throw new ListaDeException("No hay datos en la lista");
        }
    }

    ////////////////////////


    /*
    public int getCountBoysByGenderStructurDe(String code) throws ListaDeException
    {
        validateListEmpty();

        Node temp = this.getHead();

       int count = 0;

        while (temp!=null)
        {

          if(temp.getData().getGender().getCode().equals(code) && temp.getData().isOrphan())
            {

                count++;
           }

            temp=temp.getNext();
         }


       return count;
    }
     */

    /*public int listForGenderAndGradeDe(int grade, String code) throws ListaDeException
    {
        validateListEmpty();
        Node temp = this.getHead();
        int count = 0;
        while (temp!=null)
        {
            if(temp.getData().getGrade()==grade && temp.getData().getLocation().getCode().equals(code)){
                getCountBoysByGenderStructurDe(temp.getData().getGender().getCode());
                count++;
            }
            temp=temp.getNext();
        }
        return count;
    }*/

    /*public void addDe(Boy boy) throws ListaDeException
    {
        Boy boyExist = findByIdDe(boy.getIdentification());
        if(boyExist != null)
        {
            throw new ListaDeException("La identificacion ya existe");
        }
        if(this.head == null)
        {
            head = new Node(boy);
        }
        else
        {
            Node temp = head;
            while (temp.getNext()!=null)
            {
                temp = temp.getNext();
                break;
            }
            //Se queda parado en el ultimo
            temp.setNext(new Node(boy));
            temp.getNext().setPrevious(temp);
        }
        count++;
    }*/

    /*public void addToStart(Boy boy) throws ListaDeException
    {
        Boy boyExist = findByIdDe(boy.getIdentification());
        if(boyExist != null)
        {
            throw new ListaDeException("La identificacion ya existe");
        }
        if(this.head==null)
        {
            this.head = new Node(boy);

        }
        else
        {
            Node temp = new Node(boy);
            temp.setNext(this.head);
            this.head = temp;
            head.setPrevious(null);
        }
        count++;
    }*/

    /*public void deleteBoyDe(String id) throws ListaDeException
    {
        if (this.head != null)
        {
            if (this.head.getData().getIdentification().equals(id))
            {
                this.head = this.head.getNext();
                this.head.setPrevious(null);
            }
            else
            {
                Node temp = this.head;
                while (temp != null)
                {
                    if (temp.getNext() != null && temp.getNext().getData().getIdentification().equals(id))
                    {
                        break;
                    }
                    temp = temp.getNext();
                }
                if (temp != null)
                {
                    temp.setNext(temp.getNext().getNext());
                    temp.getNext().setPrevious(temp);
                }
                else
                {
                    throw new ListaDeException("La identificacion " + id + " No existe en la lista ");
                }
            }
        }
        else
        {
            throw new ListaDeException("No hay datos en la lista");
        }
    }*/

    /*public void changeXtremesDe() throws ListaDeException
    {
        if(this.head!=null && this.head.getNext()!=null)
        {
            //Sacar niño de la cabeza
            Boy start= this.head.getData();
            Node temp = head;
            while (temp.getNext()!=null)
            {
                temp = temp.getNext();
            }
            //temp esta en el ultimo niño
            this.head.setData(temp.getData());
            temp.setData(start);
        }
        else
        {
            throw new ListaDeException("No es posible ejecutar el cambio de extremos");
        }
    }*/

    /*public void addPositionDe(Boy boy, int position) throws ListaDeException
    {
        Boy boyExist = findByIdDe(boy.getIdentification());
        if(boyExist != null)
        {
            throw new ListaDeException("La identificacion ya existe");
        }
        //validar posicion
        if(position > count)
        {
            this.addDe(boy);
            return;
            //throw new ListaSeException("La posicion ingresada no es valida");
        }
        if(position==1)
        {
            addToStart(boy);
        }
        else
        {
            int cont=1;
            Node temp = this.head;
            while(temp!=null)
            {
                if(cont==position-1)
                {
                    break;
                }
                temp = temp.getNext();
                cont++;
            }
            Node nodeNew= new Node(boy);
            nodeNew.setNext(temp.getNext());
            temp.setNext(nodeNew);
            count++;
        }
    }*/

    /*public List<Boy> listDe() throws ListaDeException
    {
        if(this.head!=null)
        {
            Node temp = this.head;
            List<Boy> list = new ArrayList<>();
            while (temp != null)
            {
                list.add(temp.getData());
                temp = temp.getNext();
            }
            return list;
        }
        throw new ListaDeException("no hay datos en la lista");
        //return null;
    }*/

    /*public Boy findByIdDe(String id)
    {
        Node temp = this.head;
        while(temp!= null)
        {
            if(temp.getData().getIdentification().equals(id))
            {
                return temp.getData();
            }
            temp=temp.getNext();
        }
        return null;
    }*/
}
