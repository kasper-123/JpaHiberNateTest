package be.vdab.toysforboys.controllers;

import be.vdab.toysforboys.domain.Orders;
import be.vdab.toysforboys.forms.ShipForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
@Controller
public class shippingController {

    @PostMapping("shipping")
    public String shipOrders(ShipForm shipForm, Errors errors, RedirectAttributes redirect) {

        if (errors.hasErrors()) {
            System.out.println("oei");
            return "redirect:/";
        }

        for (var i : shipForm.getShipping().entrySet()) {

            if (i.getValue()) {
                try {
                    ship(i.getKey());
                } catch (Exception r) {
                    redirect.addAttribute("ShippingFailed", i.getKey());

                }
            }
        }

        return "redirect:/";
    }

    @Transactional
    void ship(Orders o) {
        o.setStatusShipped();
        o.setShippeddate();
        for (var i : o.getOrderDetails()) {
            i.setQuantityInProductsAndStock();
        }

    }
}
