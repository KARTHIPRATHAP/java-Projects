package com.java.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificatonRepository extends JpaRepository<Notification,Integer> {
}
