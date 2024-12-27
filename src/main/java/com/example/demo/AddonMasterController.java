package com.example.demo;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

//import com.example.demo.Enum.Errortype;
//import com.example.demo.ResponseRequest.AddonRequest;
//import com.example.demo.ResponseRequest.LeadSourceMasterdto;
//import com.example.demo.ResponseRequest.ProductFeatureMasterResponseDto;
//import com.example.demo.ResponseRequest.ResponseHandler;
//import com.example.demo.ResponseRequest.ResponseHandlerWithColumnHead;
//import com.example.demo.dto.AddonMasterdto;
//import com.example.demo.dto.DtoForColumnData;
//import com.example.demo.dto.ProductRequestDTO;
//import com.example.demo.entity.AddonMaster;
//import com.example.demo.entity.LeadSourceMaster;
//import com.example.demo.entity.SlowLog;
//import com.example.demo.exception.ResourceNotFoundException;
//import com.example.demo.repository.SlowLogRepo;
//import com.example.demo.response.RoleResponse;
//import com.example.demo.service.AddonMasterService;


import jakarta.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
//import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

@RestController
@RequestMapping("/addon_master")
public class AddonMasterController {

//	@Autowired
//	private AddonMasterService respo;
//	   @Autowired
//	    private MongoTemplate mongoTemplate;

	@PostMapping("/add")
	public void inserts(@RequestBody LinkedHashMap<String, Object> obj,HttpServletRequest request) throws AccessDeniedException {



	}

//	@DeleteMapping("/delete/{id}")
//	public ResponseHandler deleters(@PathVariable int id,HttpServletRequest request) throws AccessDeniedException {
//
//		ResponseHandler resp = new ResponseHandler();
//
//		try {
//			respo.dele(id,request);
//			resp.setStatus(true);
//			resp.setData(new HashMap<>());
//			resp.setMessage("Brokerage Configurator with ID " + id + " has been deleted.");
//			resp.setErrortype(Errortype.success);
//		} catch (IllegalArgumentException e) {
//			resp.setStatus(false);
//			resp.setData(new HashMap<>());
//			resp.setMessage(e.getMessage());
//			resp.setErrortype(Errortype.info);
//		} catch (Exception e) {
//			e.printStackTrace();
//			resp.setStatus(false);
//			resp.setData(new HashMap<>());
//			resp.setMessage("Failed to delete Brokerage Configurator.");
//			resp.setErrortype(Errortype.error);
//		}
//		return resp;
//	}
//
//	@GetMapping("listshow/{id}")
//	public ResponseEntity<RoleResponse> getMenusById(@PathVariable("id") int usersId) {
//		RoleResponse response = new RoleResponse();
//
//		try {
//			AddonMaster role = respo.getUsersById(usersId);
//
//			response.setStatus(true);
//			response.setData(role);
//			response.setMessage("Available Record for Users");
//			response.setErrortype(Errortype.success);
//			return ResponseEntity.ok(response);
//		} catch (ResourceNotFoundException e) {
//			response.setStatus(false);
//			response.setData(new HashMap<>());
//			response.setMessage("Error: Users data didn't exists.");
//			response.setErrortype(Errortype.info);
//		}
//		return ResponseEntity.ok(response);
//	}
//
//	@PutMapping("/update/{id}")
//	public ResponseHandler upda(@RequestBody AddonMasterdto obj, @PathVariable int id,HttpServletRequest request) throws AccessDeniedException {
//
//		ResponseHandler resp = new ResponseHandler();
//
//		try {
//			respo.updates(obj, id, request);
//			resp.setStatus(true);
//			resp.setData(new HashMap<>());
//			resp.setMessage("SUCCESS");
//			resp.setErrortype(Errortype.success);
//		} catch (IllegalArgumentException e) {
//			resp.setStatus(false);
//			resp.setData(new HashMap<>());
//			resp.setMessage(e.getMessage());
//			resp.setErrortype(Errortype.info);
//		} catch (Exception e) {
//			e.printStackTrace();
//			resp.setStatus(false);
//			resp.setData(new HashMap<>());
//			resp.setMessage("Failed to insert BrokerageConfigurator");
//			resp.setErrortype(Errortype.error);
//		}
//		return resp;
//
//	}
//	    
//
//	@PostMapping("/listPaging")
//	public ResponseHandlerWithColumnHead getAllEntitiesss(@RequestBody AddonRequest addonRequest,HttpServletRequest request) {
//		ResponseHandlerWithColumnHead resp = new ResponseHandlerWithColumnHead();
//
//		List<DtoForColumnData> columnHeadData = new ArrayList<>();
//		columnHeadData.add(new DtoForColumnData("Addon Slug", "addonSlug", "TEXT"));
//		columnHeadData.add(new DtoForColumnData("Addon Name", "addonName", "TEXT"));
//		columnHeadData.add(new DtoForColumnData("Product Name", "productName", "TEXT"));
//		columnHeadData.add(new DtoForColumnData("Lob", "lobName", "TEXT"));
//		columnHeadData.add(new DtoForColumnData("Company Name", "companyName", "TEXT"));
//		resp.setColumn_head(columnHeadData);
//
//		try {
//			resp.setStatus(true);
//			resp.setData(respo.listss(addonRequest, request));
//			resp.setMessage("SUCCESS");
//			resp.setTotalRecords(respo.totalRecords());
//			resp.setErrortype(Errortype.success);
//		} catch (IllegalArgumentException e) {
//			resp.setStatus(false);
//			resp.setData(new HashMap<>());
//			resp.setMessage(e.getMessage());
//			resp.setErrortype(Errortype.info);
//		} catch (Exception e) {
//			e.printStackTrace();
//			resp.setStatus(false);
//			resp.setData(new HashMap<>());
//			resp.setMessage("Error: Users data didn't exists. ");
//			resp.setErrortype(Errortype.error);
//		}
//		return resp;
//
//	}
//	@GetMapping("/list")
//	public ResponseHandler shows() {
//		ResponseHandler resp = new ResponseHandler();
//
//		try {
//
//			resp.setStatus(true);
//			resp.setData(respo.getAll());
//			resp.setMessage("all data available");
//			resp.setErrortype(Errortype.success);
//		} catch (IllegalArgumentException e) {
//			resp.setStatus(false);
//			resp.setData(new ArrayList<>());
//			resp.setMessage(e.getMessage());
//			resp.setErrortype(Errortype.info);
//		}
//		return resp;
//
//	}
//
//	@Autowired
//	private SlowLogRepo logRepo;
//	
//	@PostMapping("/listPagingss")
//	public ResponseHandler showsss(@RequestBody slowLog as) {
//		ResponseHandler resp = new ResponseHandler();
//
//		try {
//			
//
//			resp.setStatus(true);
//			System.err.println(logRepo.findByTimeTakenGreaterThan( as.getTimeTaken()).stream().map(s ->s.getTimeTaken()).collect(Collectors.toList()));
//			  List<SlowLog> findByTimeTakenGreaterThan = logRepo.findByTimeTakenGreaterThan( as.getTimeTaken());
//			resp.setData(  findByTimeTakenGreaterThan);
//			resp.setMessage("all data available");
//			resp.setErrortype(Errortype.success);
//		} catch (IllegalArgumentException e) {
//			resp.setStatus(false);
//			resp.setData(new ArrayList<>());
//			resp.setMessage(e.getMessage());
//			resp.setErrortype(Errortype.info);
//		}
//		return resp;
//
//	}
//	@PostMapping("/statusUpdate")
//	public RoleResponse statusUpdate(@RequestBody productListingDtos roleDataRequestDto)
//			throws Exception {
//		RoleResponse response = new RoleResponse();
//
//		try {
//			respo.statusUpdate(roleDataRequestDto);
//		
//				response.setStatus(true);
//				response.setData(new ArrayList<>());
//				response.setMessage("Record Updated Successfully");
//				response.setErrortype(Errortype.success);
//			
//			
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//			response.setStatus(false);
//			response.setData(new ArrayList<>());
//			response.setMessage(e.getMessage());
//			response.setErrortype(Errortype.info);
//		} catch (Exception e) {
//			e.printStackTrace();
//
//			response.setStatus(false);
//			response.setData(new ArrayList<>());
//			response.setMessage(e.getMessage());
//			response.setErrortype(Errortype.error);
//		}
//		return response;
//	}
//	
//	
//
//



	
	

}
