package com.umanizales.lists_prog2.model.listaSe;

import com.umanizales.lists_prog2.Exception.ListaSeException;
import com.umanizales.lists_prog2.model.Boy;
import com.umanizales.lists_prog2.model.Gender;
import com.umanizales.lists_prog2.model.Gender1;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
/**
 * Clase creada que me permite gestionar la lista Simplemente Enlazada
 * Esta clase contiene metodos, operaciones y atributos.
 * @author Alejo Carmona
 * @version 1.0 - 2-nov-2021
 */
public class ListSE {
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
     * @param boy niño con todos sus datos
     * @throws ListaSeException
     */
    public void add(Boy boy) throws ListaSeException
    {
        /**
         * Se llama el metodo que me busca los niños por la identificacion y me dice si el niño ya exite o no
         */
        Boy boyExist = findById(boy.getIdentification());
        /**
         * Se crea un if con el fin de indicarle al metodo que si  el niño ya existe me lance una Execepcion
         */
        if(boyExist != null)
        {
            /**
             * Si el niño ya existe se lanza una excepcion para que el usuario ya sepa que existe el niño
             */
            throw new ListaSeException("La identificacion ya existe");
        }
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño) es nula se cree un niño
         */
        if(head == null)
        {
            /**
             * Se crea un niño nuevo
             */
            head = new Node(boy);
        }
        /**
         * Se crea un else con el fin de indicarle al metodo que si la cabeza no es nula me adicione un niño
         */
        else
        {
            /**
             * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
             */
            Node temp = head;
            /**
             * Creo un ciclo para recorrer la lista SE de principio a fin
             * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
             */
            while (temp.getNext()!=null)
            {
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
        }
        /**
         * incrementamos el contador con el fin de llevar el conteo de los niños
         */
        count++;
    }

    //METODO ADICIONAR AL INICIO
    /**
     * Metodo que me adiciona un niño al inicio de la lista
     * @param boy niño con todos sus datos
     * @throws ListaSeException
     */
    public void addToStart(Boy boy) throws ListaSeException
    {
        /**
         * Se llama el metodo que me busca los niños por la identificacion y me dice si el niño ya exite o no
         */
        Boy boyExist = findById(boy.getIdentification());
        /**
         * Se crea un if con el fin de indicarle al metodo que si  el niño ya existe me lance una Execepcion
         */
        if(boyExist != null)
        {
            /**
             * Si el niño ya existe se lanza una excepcion para que el usuario ya sepa que existe el niño
             */
            throw new ListaSeException("La identificacion ya existe");
        }
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño) es nula se cree un niño
         */
        if(this.head==null)
        {
            /**
             * Se crea un niño nuevo
             */
            this.head = new Node(boy);
        }
        /**
         * Se crea un else con el fin de indicarle al metodo que si la cabeza no es nula me adicione un niño
         */
        else
        {
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
        }
        /**
         * incrementamos el contador con el fin de llevar el conteo de los niños
         */
        count++;
    }

    //METODO ADICIONAR POR POSICION
    /**
     * Metodo que me adiciona un niño a la pocision dada en el parametro
     * @param boy niño con todos sus datos
     * @param position es el numero donde se va a adicionar a el niño
     * @throws ListaSeException
     */
    public void addPosition(Boy boy, int position) throws ListaSeException
    {
        /**
         * Se llama el metodo que me busca los niños por la identificacion y me dice si el niño ya exite o no
         */
        Boy boyExist = findById(boy.getIdentification());
        /**
         * Se crea un if con el fin de indicarle al metodo que si  el niño ya existe me lance una Execepcion
         */
        if(boyExist != null)
        {
            /**
             * Si el niño ya existe se lanza una excepcion para que el usuario ya sepa que existe el niño
             */
            throw new ListaSeException("La identificacion ya existe");
        }
        //validar posicion
        /**
         * Validamos si la posicion ingresada, es mayor a la catidad que tiene el contador
         */
        if(position > count)
        {
            /**
             * si la posicion ingresada es mayor, se llama el metodo de adicionar al final para que adicione
             * un nuevo niño
             */
            this.add(boy);
            return;
            //throw new ListaSeException("La posicion ingresada no es valida");
        }
        /**
         * validamos si la posicion ingresada es la 1
         */
        if(position==1)
        {
            /**
             * si la posicion ingresada es la 1, llamamos al metodo de adicionar al inicio para que nos guarde
             * el niño en la primera posicion
             */
            addToStart(boy);
        }
        /**
         * sino
         */
        else
        {
            /**
             * inicializamos un contador(cont) en 1
             */
            int cont=1;
            /**
             * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
             */
            Node temp = this.head;
            /**
             * Creo un ciclo para recorrer la lista SE de principio a fin
             * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
             */
            while(temp!=null)
            {
                /**
                 * validamos si el contador(cont) es igual a la posicion ingresada menos 1
                 */
                if(cont==position-1)
                {
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
            Node nodeNew= new Node(boy);
            /**
             * le decimos a nuestro nuevo ayudante que tome lo que tiene nuestro primer ayudante
             */
            nodeNew.setNext(temp.getNext());
            /**
             * le decimos a nuestro primer ayudante que coja el niño nuevo que tiene nuestro segundo ayudante
             */
            temp.setNext(nodeNew);
            /**
             * incrementamos el contador con el fin de llevar el conteo de los niños
             */
            count++;
        }
    }

    //METODO PARA INVERTIR LA LISTA
    /**
     *
     * @throws ListaSeException
     */
    public void invertList() throws ListaSeException
    {
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño) es nula,
         * no hay datos en la lista
         */
        if(this.head != null) {
            /**
             * Cojemos la lista que ya tenemos y le cremos una temporal
             */
            ListSE listTemp = new ListSE();
            /**
             * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
             */
            Node temp = this.head;
            /**
             * Creo un ciclo para recorrer la lista SE de principio a fin
             * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
             */
            while (temp != null)
            {
                /**
                 * a la lista temporal le asignamos de primero lo que tiene el ayudante
                 */
                listTemp.addToStart(temp.getData());
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
     * @return se retorna la cantidad
     */
    public int count()
    {
        /**
         * inicializamos un contador(cont) en 0
         */
        int cont=0;
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño)
         * es nula se retorna el contador en 0
         */
        if(this.head != null) {
            /**
             * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
             */
            Node temp = this.head;
            /**
             * Creo un ciclo para recorrer la lista SE de principio a fin
             * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
             */
            while (temp != null)
            {
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
     * @return retorna la lista aramadita
     * @throws ListaSeException
     */
    public List<Boy> list() throws ListaSeException
    {
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño) es nula, retorne
         * que no hay datos en la lista
         */
        if(this.head!=null)
        {
            /**
             * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
             */
            Node temp = this.head;
            /**
             * creamos una lista, para ubicar todos los niños en ella
             */
            List<Boy> list = new ArrayList<>();
            /**
             * Creo un ciclo para recorrer la lista SE de principio a fin
             * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
             */
            while (temp != null)
            {
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
        throw new ListaSeException("no hay datos en la lista");
        //return null;
    }

    //METODO CAMBIAR EXTREMOS

    /**
     * creamos este metodo para hacer el cambio de ubicacion de los extremos osea el primer y ultimo niño
     * @throws ListaSeException
     */
    public void changeXtremes() throws ListaSeException
    {
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño) es nula
         * Y si el que sigue de la cabeza tambien es null, esto va a retornar que no es posible hacer el cambio.
         * pero si no es nulo entra al if y continua su operacion
         */
        if(this.head!=null && this.head.getNext()!=null)
        {
            //Sacar niño de la cabeza
            /**
             * se crea una variable para indicar que en este se va a almacenar el primer niño
             */
            Boy start= this.head.getData();
            /**
             * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
             */
            Node temp = head;
            /**
             * Creo un ciclo para recorrer la lista SE de principio a fin
             * hasta llegar al niño antes del ultimo, ya que el ultimo en su siguiente seria nulo
             */
            while (temp.getNext()!=null)
            {
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
        else
        {
            /**
             * si la cabeza no tiene ningun dato y si su siguiente tampoco tiene ningun dato,
             * se retorna esta excepcion para indicar que no es posible hacer el cambio de los extremos
             */
            throw new ListaSeException("No es posible ejecutar el cambio de extremos");
        }
    }

    //METODO DE ELIMINAR
    /**
     * se crea este metodo para eliminar un dato de la lista
     * @param identification se pide que se ingrese la identificacion, porque es un dato unico de cada niño
     * @throws ListaSeException
     */
    public void delete(String identification) throws ListaSeException
    {
        /**
         * Se crea un if con el fin de indicarle al metodo que si la cabeza(el primer niño) es nula, retorne
         * que no hay datos en la lista
         */
        if(this.head != null)
        {
            /**
             * Se crea un if con el fin de indicarle al metodo que de el dato que tiene la cabeza, si la
             * identificacion es igual a la identificacion ingresada entra al if y continua su operacion
             */
            if(this.head.getData().getIdentification().equals(identification))
            {
                /**
                 * le asigna a la cabeza lo que hay en su siguiente
                 */
                this.head=this.head.getNext();
            }
            /**
             * sino
             */
            else
            {
                /**
                 * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
                 */
                Node temp = this.head;
                /**
                 * Creo un ciclo para recorrer la lista SE de principio a fin
                 * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
                 */
                while(temp!=null)
                {
                    /**
                     * a el dato que tiene actualmente el ayudante se le va a analizar si su siguien te es nulo y si
                     * la identificacion del siguiente es igual a la identificacion ingresada
                     */
                    if(temp.getNext() != null && temp.getNext().getData().getIdentification().equals(identification))
                    {
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
                if(temp!=null)
                {
                    /**
                     * el ayudante toma al siguiente del siguiente para que el siguiente quede eliminado
                     */
                    temp.setNext(temp.getNext().getNext());
                }
                /**
                 * sino
                 */
                else
                {
                    /**
                     * se retorna esta excepxion si nuestro ayudante no tiene nada, para indicarnos que la
                     * identificacion ingresada no existe
                     */
                    throw new ListaSeException("La identificacion " + identification + " no existe en la lista");
                }
            }
        }
        /**
         * sino
         */
        else
        {
            /**
             * se llama este metodo que nos indica que no hay datos en la lista
             */
            validateListEmpty();
        }
    }

    //METODO PARA ENCONTRAR POR IDENTIFICACION
    /**
     * Se crea este metodo para poder encontrar a un niño por su identificacion
     * @param id se pide que se ingrese la identificacion, porque es un dato unico de cada niño
     * @return retorna un null si no encuentra nada
     */
    public Boy findById(String id)
    {
        /**
         * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
         */
        Node temp = this.head;
        /**
         * Creo un ciclo para recorrer la lista SE de principio a fin
         * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
         */
        while(temp!= null)
        {
            /**
             * creamos un if donde indicamos que a el dato que tiene el ayudante le tomamos la identificacion
             * y miramos si es igual a la identificacion ingresada
             */
            if(temp.getData().getIdentification().equals(id))
            {
                /**
                 * retorna el niño o el dato que tiene nuestro ayudante
                 */
                return temp.getData();
            }
            /**
             * el ayudante cambia al siguiente node de el que ya esta
             */
            temp=temp.getNext();
        }
        /**
         * retornamos un null si no hay datos en la lista
         */
        return null;
    }

    //METODO QUE NOS RETORNA UNA LISTA POR GENERO QUE LE INGRESEMOS
    /**
     * se crea el metodo con el fin de generar una ista dependiendo al genero que le ingresemos por parametro
     * @param gender parametro que necesitamos para evaluar y poder sacar la lista
     * @return retorna una lista dependiendo del genero
     * @throws ListaSeException
     */
    public ListSE getListSeBoysByGender(String gender) throws ListaSeException
    {
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
        ListSE listTemp = new ListSE();
        /**
         * Creo un ciclo para recorrer la lista SE de principio a fin
         * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
         */
        while (temp!=null)
        {
            /**
             * creamos el if para evaluar el dato que tiene el ayudante agarrado, a ese dato le evaluamos
             * de que genero es y si es igual a el que se le ingreso
             */
            if(temp.getData().getGender().getDescription().equals(gender))
            {
                /**
                 * si el genero es igual al que se le ingreso llamamos al metodo adicionar y le decimos que
                 * nos adicione el que tiene el ayudante a la lista temporal
                 */
                listTemp.add(temp.getData());
            }
            /**
             * el ayudante cambia al siguiente node de el que ya esta
             */
            temp= temp.getNext();
        }
        /**
         * retornamos la lista temporal
         */
        return listTemp;
    }

    //METODO QUE INTERCALA LOS NIÑOS POR EDADES

    /**
     * creamos un metodo que nos intercale los niños por edades segun el genero que le ingresemos
     * @throws ListaSeException
     */
    public void variantBoys() throws ListaSeException
    {
        /**
         * llamamos este metodo para indicar si la lista tiene algo o no
         */
        validateListEmpty();
        /**
         * se toma la lista de los niños, llamando al metodo de ontener lista por genero
         */
        ListSE kids= this.getListSeBoysByGender("MASCULINO");
        /**
         * se toma la lista de los niñas, llamando al metodo de ontener lista por genero
         */
        ListSE girls= this.getListSeBoysByGender("FEMENINO");
        /**
         * inicializamos variables para poner la lista que menos niños tenga, para saber la minList
         */
        ListSE minList = null;
        /**
         * inicializamos variables para poner la lista que mas niños tenga, para saber la maxlist
         */
        ListSE maxList = null;
        /**
         * creamos el if llamando el metodo que nos cuenta la cantidad para saber si la cantidad de
         * los niños es mayor a la cantidad de las niñas
         */
        if(kids.getCount()>girls.getCount())
        {
            /**
             * si la lista de los niños es mayor, tomamos primero la lista menor que seria la de las niñas
             * y luego la lista mayor que seria la de los niños
             */
            minList=girls;
            maxList=kids;
        }
        else
        {
            /**
             * si la lista de las niñas es mayor, tomamos primero la lista menor que seria la de los niños
             * y luego la lista mayor que seria la de las niñas
             */
            minList= kids;
            maxList= girls;
        }
        /**
         * llamamos a un ayudante para que nos coja la lista menor y no la asigne a la cabeza
         */
        Node temp = minList.getHead();
        /**
         * inicializamos una variable llamada pos en 2
         */
        int pos=2;
        /**
         * Creo un ciclo para recorrer la lista SE de principio a fin
         * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
         */
        while (temp!=null)
        {
            /**
             * tomamos la lista mayor y llamamos al adicionar por posicion, le damos el dato que tiene nuestro
             * ayudante y la posicion que inicializamos en 2
             */
            maxList.addPosition(temp.getData(), pos);
            /**
             * le decimos a la posicion que se incremente de 2 en 2 para poder que quede intercalado
             */
            pos = pos + 2;
            /**
             * el ayudante cambia al siguiente node de el que ya esta
             */
            temp= temp.getNext();
        }
        /**
         * la lista mayor la tiene la cabeza
         */
        this.head= maxList.getHead();
    }

    //METODO QUE NOS CUENTA LA CANTIDAD POR MUNICIPIO
    /**
     * creamos un metodo que nos permitira saber cuantos niños hay por cada localizacion
     * @param code le entra como parametro el codigo de la localizacion
     * @return retorna una lista con la cantidad por municipios
     */
    public int getCountBoysByLocation(String code)
    {
        /**
         * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
         */
        Node temp = this.getHead();
        /**
         * inicializamos un contador en 0
         */
        int count = 0;
        /**
         * Creo un ciclo para recorrer la lista SE de principio a fin
         * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
         */
        while (temp!=null)
        {
            /**
             * tomamos el dato que tenga el ayudante y miramos la localizacion y a la localizacion le miramos el codico
             * y miramos si es igual al que le entramos por parametro
             */
            if(temp.getData().getLocation().getCode().equals(code))
            {
                /**
                 * incrementamos el contador de la localizacion en la que este el ayudante
                 */
                count++;
            }
            /**
             * el ayudante cambia al siguiente node de el que ya esta
             */
            temp=temp.getNext();
        }
        /**
         * retornamos el calculo del incremento de el contador, para cada localizacion
         */
        return count;
    }

    //METODO QUE NOS CUENTA LA CANTIDAD POR GENERO
    /**
     * creamos un metodo que nos permitira saber cuantos niños hay por cada genero
     * @param code le entra como parametro el codigo del genero
     * @return retorna una lista con la cantidad por genero
     */
    public int getCountBoysByGender(String code)
     {
         /**
          * llamamos un ayudante y lo ubicamos en la cabeza(el primer niño)
          */
         Node temp = this.getHead();
         /**
          * inicializamos un contador en 0
          */
         int count = 0;
         /**
          * Creo un ciclo para recorrer la lista SE de principio a fin
          * llego al final cuando mi ayudante ya quede parado en el ultimo niño antes del null
          */
         while (temp!=null)
         {
             /**
              * tomamos el dato que tenga el ayudante y miramos el genero y al genero le miramos el codico
              * y miramos si es igual al que le entramos por parametro
              */
             if(temp.getData().getGender().getCode().equals(code))
             {
                 /**
                  * incrementamos el contador del genero en el que este el ayudante
                  */
                 count++;
             }
             /**
              * el ayudante cambia al siguiente node de el que ya esta
              */
             temp=temp.getNext();
         }
         /**
          * retornamos el calculo del incremento de el contador, para cada localizacion
          */
         return count;
     }

    public void listForAgeAndLocations (int age, String code) throws ListaSeException
    {
        validateListEmpty();
        if (this.head != null) {
            ListSE listTemp = new ListSE();
            Node temp = this.head;
            while(temp != null)
            {
                if (temp.getData().getAge()<= age && temp.getData().getLocation().getCode().equals(code)){
                    listTemp.addToStart(temp.getData());
                }
                temp = temp.getNext();
            }
            this.head = listTemp.getHead();
        }
    }


    public void listForAgeAndGender (int age, String code) throws ListaSeException
    {
        validateListEmpty();
        if (this.head != null) {
            ListSE listTemp = new ListSE();
            Node temp = this.head;
            while(temp != null)
            {
                /*if(temp.getData().getAge()!=age){
                    throw new ListaSeException("No es posible hacer la busqueda pruebe otros datos");
                }*/
                if(temp.getData().getAge()<=age && temp.getData().getGender().getCode().equals(code)){
                    listTemp.addToStart(temp.getData());
                }
                else {
                    listTemp.add(temp.getData());
                }
                temp = temp.getNext();
            }
            this.head = listTemp.getHead();
        }
    }

    public void deleteForAge(byte age) throws ListaSeException
    {
        validateListEmpty();
        Node temp = this.head;
        while(temp!=null){
            if(temp.getData().getAge()>age){
                delete(temp.getData().getIdentification());
            }
            temp=temp.getNext();
        }
    }

    public void deleteForGender(String code) throws ListaSeException{
        validateListEmpty();
        Node temp = this.head;
        while(temp!=null){
            if(temp.getData().getGender().getCode().equals(code)){
                delete(temp.getData().getIdentification());
            }
            temp=temp.getNext();
        }
    }

    public void listForGrade(byte grade) throws ListaSeException{
        validateListEmpty();
        if (this.head != null) {
            ListSE listTemp = new ListSE();
            Node temp = this.head;
            while(temp != null)
            {
                if (temp.getData().getGrade()==grade){
                    listTemp.addToStart(temp.getData());
                }
                temp = temp.getNext();
            }
            this.head = listTemp.getHead();
        }
    }





    ////////////////////////

    //METODO QUE NOS VALIDA SI SI HAY DATOS EN LA LISTA
    /**
     * creamos el metodo para evaluar si en la lista hay 1 o mas datos
     * @throws ListaSeException se lanza la excepcion en caso de no haber datos
     */
    public void validateListEmpty() throws ListaSeException
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
            throw new ListaSeException("No hay datos en la lista");
        }
    }

    ////////////////////////

    /*public void deleteByPosition(int position) throws ListaSeException
    {
        /// Validación de la posicíon
        if(position > count)
        {
            this.deleteByPosition(position);
            return;
            //throw  new ListaSeException("La posición ingresada no es válida");
        }
        if(position ==1)
        {
            deleteByPosition(position);
        }
        else
        {
            int cont=1;
            Node temp = this.head;
            while(temp!=null)
            {
                if(cont == position-1 )
                {
                    break;
                }
                temp= temp.getNext();
                cont--;
            }
            //Ayudante va estar posicionado en la posición anterior
            count--;
        }
    }*/

    /*
    public void noRepeat(Boy boy)
    {
        boolean stop = false;
        if(this.head == null)
        {
            head = new Node(boy);
            stop = true;
        }
        else
        {
            Node temp = this.head;
            while(temp.getNext()!= null)
            {
                if(temp.equals(boy) && stop==false)
                {
                    temp.setNext(new Node(boy));
                    stop = true;
                }
            }
        }
    }
    */

    /*
    public List<Boy> forGender(String gender)
    {
        if(this.head!=null)
        {
            Node temp = this.head;
            List<Boy> list = new ArrayList<>();
                while (temp != null) {
                    if(gender.equals("FEMENINO")) {
                        list.add(temp.getData());
                        temp = temp.getNext();
                    }else if(gender.equals("MASCULINO")){
                        list.add(temp.getData());
                        temp = temp.getNext();
                    }
                }
            return list;
        }
        return null;
    }

     */

    /*
    public int countMunicipio(String municipio)
    {
        //int cont=0;
        int conMunicipio = 0;
        if(this.head != null) {
            Node temp = this.head;
            while(temp.getNext()!= null)
            {
                if(temp.getData().getMunicipio().equals(municipio))
                {
                    conMunicipio++;
                }
                temp = temp.getNext();
            }
            conMunicipio++;
        }
        return conMunicipio;
    }
    */

    /*
    public void forGenderList(String gender)
    {
        if(this.head!=null)
        {
            Node temp = this.head;
            Boy boy = null;
            while (temp != null) {
                if(temp.getData().getGender().equals(gender)){
                    boy = new Boy(temp.getData().getIdentification(),temp.getData().getName(),temp.getData().getAge(),temp.getData().getGender(),temp.getData().getMunicipio());
                    delete(temp.getData().getIdentification());
                    addToStart(boy);
                }
                temp = temp.getNext();
            }
        }
    }*/

    /*
    public void delete(String id)
    {
        Node temp = this.head;
        if(temp.getData().getIdentification().equals(id))
        {
            setHead(temp.getNext());
        }
        else
        {
            while (temp.getNext() != null)
            {
                if(temp.getNext().getData().getIdentification().equals(id))
                {
                    temp.setNext(temp.getNext().getNext());
                    break;
                }
                temp = temp.getNext();
            }
        }
        count--;
    }
    */

    /*public List<Boy> formunicipio(String municipio)
    {
        if(this.head!=null)
        {
            Node temp = this.head;
            List<Boy> list = new ArrayList<>();
            while (temp != null) {
                if(municipio.equals(municipio)) {
                    list.add(temp.getData());
                    temp = temp.getNext();
                }else if(municipio.equals(municipio)){
                    list.add(temp.getData());
                    temp = temp.getNext();
                }
                return municipio + countMunicipio
            }
            return list;
        }
        return null;
    }*/

    /*
    public void mostrarGenero(String gender) {
        Node temp = head;
        //Recorremos la lista hasta el final
        while (temp.getNext() != null) {
            //preguntamos  si el genero corresponde al buscado
            if (String(gender, temp.getNext() -> gender) == 0)
                //lo mostramos
                printf("%s \n", p -> nombre);
            p = p -> sgte;
        }
    }*/

    /*public void noRepeat(Boy boy)
    {
        Node temp = this.head;
        Node temp2 = null;

        while (temp.getNext() != null)
        {
            if (temp.getData().equals(boy))
            {
                temp2.setNext(temp.getNext());
                temp.setNext(null);
            } else {

                Node temp1 = new Node(boy);
                temp1.setNext(this.head);
                this.head = temp1;

                List<Boy> list = new ArrayList<>();
                while (temp != null)
                {
                    list.add(temp.getData());
                    temp = temp.getNext();
                }
            }
        }
    }*/

    /*public void delete(Boy boy)
    {
        Node temp = this.head;
        Node temp2 = null;
        boolean stop = false;

        while (temp != null && stop == false) {
            if(temp.getData().equals(boy)) {
                if(temp2 == null){
                    this.head = temp.getNext();
                    temp.setNext(null);
                }else{
                    temp2.setNext(temp.getNext());
                    temp.setNext(null);
                }
                stop = true;
            }
            temp2 = temp;
            temp = temp.getNext();
        }
        count--;
    }*/


}
