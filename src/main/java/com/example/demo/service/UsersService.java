package com.example.demo.service;



import jakarta.servlet.http.HttpServletRequest;

import java.net.UnknownHostException;
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Map;

public interface UsersService {

   

    List<String> getAllMobileNumbers();

    List<String> getAllUsername();

    List<String> getAllEmails();
    
    Map<String, Object> getUserDetails(HttpServletRequest httpRequest)throws AccessDeniedException;

    void safeRemove(Long rolesId,HttpServletRequest httpRequest) throws AccessDeniedException;
    
   long totalRecord();
    
    

	
	
}
