package com.argelastaj.SGW.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("SGW/resources/sgw")
public class ApiController {
	
	   @GetMapping("/isHostAvailable")
	    public boolean IamAlive(){
	        return true;
	    }

}
