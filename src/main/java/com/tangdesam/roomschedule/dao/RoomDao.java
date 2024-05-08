package com.tangdesam.roomschedule.dao;

import com.tangdesam.roomschedule.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room, String> {
}
