package com.example.laundry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    private OrderCheckRepository ordercheckRepository;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/orders")
    public String showOrders(Model model) {
        List<Order1> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @PostMapping("/orders")
    public String createOrder(@ModelAttribute Order1 order) {
        orderRepository.save(order);
        return "redirect:/orders";
    }
    @PostMapping("/orders_check")
    public String createOrderCheck(@ModelAttribute Order_check order) {
        ordercheckRepository.save(order);
        return "redirect:/orders";
    }
    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        orderRepository.deleteById(id);
        return "orders";
    }

//    @RequestMapping("/find/{id_check}")
//    public void findTask(@PathVariable Long id) {
//        Order1 order = orderRepository.findById(id).orElse(null);
//        Order_check orderCheck = ordercheckRepository.findById(id).orElse(null);
//        if (order.getCode() == (orderCheck.getCode_check()))
//            deleteTask(id);
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelOrder(@PathVariable Long id, @RequestParam int code) {
        Order1 order = orderRepository.findByIdAndCode(id, code);
        if (order == null) {
            return ResponseEntity.badRequest().body("Invalid id or code");
        }
        orderRepository.delete(order);
        return ResponseEntity.ok("Order cancelled successfully");
    }
}
