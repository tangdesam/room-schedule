package com.tangdesam.roomschedule.dao;

import com.tangdesam.roomschedule.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking, String> {
}
