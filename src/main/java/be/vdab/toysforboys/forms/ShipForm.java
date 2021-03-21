package be.vdab.toysforboys.forms;

import be.vdab.toysforboys.domain.Orders;

import java.util.*;


public class ShipForm {
public LinkedHashMap<Orders,Boolean> shipping;


    public ShipForm(LinkedHashMap<Orders, Boolean> shipping) {

        this.shipping = shipping;
    }

    public LinkedHashMap<Orders, Boolean> getShipping()
    {
        return shipping;
    }




}


