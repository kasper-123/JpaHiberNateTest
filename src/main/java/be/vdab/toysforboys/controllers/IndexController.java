package be.vdab.toysforboys.controllers;


import be.vdab.toysforboys.domain.Orders;
import be.vdab.toysforboys.forms.ShipForm;
import be.vdab.toysforboys.services.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("/")
class IndexController {
    private final OrdersService ordersService;

    IndexController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public ModelAndView Orders(){

        var modelAndView= new ModelAndView("index2");
         LinkedHashMap<Orders,Boolean> shipform= new LinkedHashMap<>();

for(var i :ordersService.findUnshippedOrders() ){
shipform.put(i,false)    ;
}

        modelAndView.addObject("shipform",shipform);

        return modelAndView;
    }



}
