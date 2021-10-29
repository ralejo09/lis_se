package com.umanizales.lists_prog2.model.listaSe;

import com.umanizales.lists_prog2.Exception.ListaSeException;
import com.umanizales.lists_prog2.model.Boy;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

 @Data
@Service
public class ListSE {
    private Node head;
    private int count;
    //private int countMunicipio;
    //ya
    public void add(Boy boy) throws ListaSeException
    {
        Boy boyExist = findById(boy.getIdentification());
        if(boyExist != null)
        {
            throw new ListaSeException("La identificacion ya existe");
        }
        if(head == null)
        {
            head = new Node(boy);
        }
        else
        {
            Node temp = head;
            while (temp.getNext()!=null)
            {
                temp = temp.getNext();
            }
            //Se queda parado en el ultimo
            temp.setNext(new Node(boy));
        }
        count++;
    }
    //ya
    public void addToStart(Boy boy) throws ListaSeException
    {
        Boy boyExist = findById(boy.getIdentification());
        if(boyExist != null)
        {
            throw new ListaSeException("La identificacion ya existe");
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
        }
        count++;
    }
    //ya
    public void addPosition(Boy boy, int position) throws ListaSeException
    {
        Boy boyExist = findById(boy.getIdentification());
        if(boyExist != null)
        {
            throw new ListaSeException("La identificacion ya existe");
        }
        //validar posicion
        if(position > count)
        {
            this.add(boy);
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
    }

    public void invertList() throws ListaSeException
    {
        if(this.head != null) {
            ListSE listTemp = new ListSE();
            //Recorrer lista de principio a fin
            Node temp = this.head;
            while (temp != null)
            {
                listTemp.addToStart(temp.getData());
                temp = temp.getNext();
            }
            this.head = listTemp.getHead();
        }

    }

    public int count()
    {
        int cont=0;
        if(this.head != null) {
            //Recorrer lista de principio a fin
            Node temp = this.head;
            while (temp != null)
            {
                cont++;
                temp = temp.getNext();
            }
        }
        return cont;
    }
    //ya
    public List<Boy> list() throws ListaSeException
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
        throw new ListaSeException("no hay datos en la lista");
        //return null;
    }
    //ya
    public void changeXtremes() throws ListaSeException
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
            throw new ListaSeException("No es posible ejecutar el cambio de extremos");
        }
    }
    //ya
    public void delete(String identification) throws ListaSeException
    {
        if(this.head != null)
        {
            if(this.head.getData().getIdentification().equals(identification))
            {
                this.head=this.head.getNext();
            }
            else
            {
                Node temp = this.head;
                while(temp!=null)
                {
                    if(temp.getNext() != null && temp.getNext().getData().getIdentification().equals(identification))
                    {
                        break;
                    }
                    temp = temp.getNext();
                }
                //temp va estar parado en el anterior al que debo de eliminar o va a ser null
                if(temp!=null)
                {
                    temp.setNext(temp.getNext().getNext());
                }
                else
                {
                    throw new ListaSeException("La identificacion " + identification + " no existe en la lista");
                }
            }
        }
        else
        {
            validateListEmpty();
        }
    }
    //ya
    public Boy findById(String id)
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
    }

    public ListSE getListSeBoysByGender(String gender) throws ListaSeException
    {
        validateListEmpty();
        Node temp = this.head;
        ListSE listTemp = new ListSE();
        while (temp!=null)
        {
            if(temp.getData().getGender().name().equals(gender))
            {
                listTemp.add(temp.getData());
            }
            temp= temp.getNext();
        }
        return listTemp;
    }

    public void variantBoys() throws ListaSeException
    {
        validateListEmpty();
        ListSE kids= this.getListSeBoysByGender("MASCULINO");
        ListSE girls= this.getListSeBoysByGender("FEMENINO");
        ListSE minList = null;
        ListSE maxList = null;
        if(kids.getCount()>girls.getCount())
        {
            minList=girls;
            maxList=kids;
        }
        else
        {
            minList= kids;
            maxList= girls;
        }
        Node temp = minList.getHead();
        int pos=2;
        while (temp!=null)
        {
            maxList.addPosition(temp.getData(), pos);
            pos = pos + 2;
            temp= temp.getNext();
        }
        this.head= maxList.getHead();
    }

    public int getCountBoysByLocation(String code)
    {
        Node temp = this.getHead();
        int count = 0;
        while (temp!=null)
        {
            if(temp.getData().getLocation().getCode().equals(code))
            {
                count++;
            }
            temp=temp.getNext();
        }
        return count;
    }

    ////////////////////////
    public void validateListEmpty() throws ListaSeException
    {
        if(this.head==null)
        {
            throw new ListaSeException("No hay datos en la lista");
        }
    }
    ////////////////////////

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
