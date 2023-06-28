package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class SampleHotel {
	
	@Autowired
	private Chef chef;
	
}
