package com.umanizales.lists_prog2.model.listaDe;

import com.umanizales.lists_prog2.Exception.ListaDeException;
import com.umanizales.lists_prog2.Exception.ListaSeException;
import com.umanizales.lists_prog2.model.Boy;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListDe {
    private Node head;
    private int count;

    public void addDe(Boy boy) throws ListaDeException
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
    }

    public void addToStart(Boy boy) throws ListaDeException
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
            temp.getNext().setPrevious(null);
            this.head = temp;
        }
        count++;
    }

    public void deleteBoyDe(String id) throws ListaDeException
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
    }

    public void changeXtremesDe() throws ListaDeException
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
    }

    public void addPositionDe(Boy boy, int position) throws ListaDeException
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
    }

    public List<Boy> listDe() throws ListaDeException
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
    }

    public Boy findByIdDe(String id)
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
}
