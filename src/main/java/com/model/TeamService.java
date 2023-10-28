package com.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
	
	@Autowired
	TeamMapper teamMapper;

	public boolean delete(int teamno) throws Exception {
		boolean flag = false;
			
		teamMapper.delete(teamno);
			
		flag = true;
		
		return flag;
	}

}
