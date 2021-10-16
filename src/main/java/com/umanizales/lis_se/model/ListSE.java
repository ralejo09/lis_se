package com.umanizales.lis_se.model;

import com.umanizales.lis_se.Exception.ListaSeException;
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

    public boolean add(Boy boy)
    {
        if(head == null)
        {
            head = new Node(boy);
        }
        else
        {
            Node temp = head;
            while (temp.getNext()!=null)
            {
                if(boy.getIdentification().equals(temp.getData().getIdentification()))
                {
                    return false;
                }
                temp = temp.getNext();
            }
            //Se queda parado en el ultimo
            temp.setNext(new Node(boy));
        }
        count++;
        return true;
    }

    public void addToStart(Boy boy)
    {
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

    public void invertList()
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
            throw new ListaSeException("No hay datos en la lista");
        }
    }

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
                    if(gender.equals("Femenino")) {
                        list.add(temp.getData());
                        temp = temp.getNext();
                    }else if(gender.equals("Masculino")){
                        list.add(temp.getData());
                        temp = temp.getNext();
                    }
                }
            return list;
        }
        return null;
    }

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
