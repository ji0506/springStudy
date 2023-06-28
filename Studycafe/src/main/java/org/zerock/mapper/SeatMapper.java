package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Seat;

public interface SeatMapper {
	
	List<Seat> selectSeatList();
	
}
