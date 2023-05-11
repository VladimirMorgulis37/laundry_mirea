package com.example.laundry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCheckRepository extends JpaRepository<Order_check, Long> {
}