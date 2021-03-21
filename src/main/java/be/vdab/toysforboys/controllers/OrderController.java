package be.vdab.toysforboys.controllers;

import be.vdab.toysforboys.services.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrdersService ordersService;

    public OrderController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("{id}")
    public ModelAndView orderProducten(@PathVariable long id){
        var modelAndView= new ModelAndView("order");
        ordersService.findById(id).ifPresent(order ->
                modelAndView.addObject("orderId",ordersService.findById(id)));

        ordersService.findById(id).ifPresent(order ->
                modelAndView.addObject(
                        "orderdetails",ordersService.findById(id).get().getOrderDetails()));


        return modelAndView;
    }


}