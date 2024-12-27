package com.example.demo.jwtAuth;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.constant.Constant;

import com.example.demo.entity.Users;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class JwtUtils {
//
//	@PersistenceContext
//	private EntityManager entityManager;
//
////	@Autowired
////	private RoleMasterRepository roleMasterRepository;
//
////	private static RoleMasterRepository roleMasterRepository;
////	
////	private static UsersRepository usersRepository;
////	
////	private static BrokerOfficeLocationRepository brokerOfficeLocationRepository;
////	
////	private static UserRelationRepository userRelationRepository;
////	
////	private static UsersLobRelationRepository usersLobRelationRepository;
////	
////	private static BrokerMasterRepository brokerMasterRepository;
//	
////	@Autowired
////	public JwtUtils(RoleMasterRepository roleMasterRepository) {
////		JwtUtils.roleMasterRepository = roleMasterRepository;
////	}
////	@Autowired
////	public JwtUtils(UsersRepository usersRepository) {
////		JwtUtils.usersRepository = usersRepository;
////	}
//	
////	@Autowired
////	public JwtUtils(RoleMasterRepository roleMasterRepository, UsersRepository usersRepository, BrokerOfficeLocationRepository brokerOfficeLocationRepository,
////			UsersLobRelationRepository usersLobRelationRepository, BrokerMasterRepository brokerMasterRepository) {
////	    JwtUtils.roleMasterRepository = roleMasterRepository;
////	    JwtUtils.usersRepository = usersRepository;
////	    JwtUtils.brokerOfficeLocationRepository = brokerOfficeLocationRepository;
////	    JwtUtils.usersLobRelationRepository = usersLobRelationRepository;
////	    JwtUtils.brokerMasterRepository = brokerMasterRepository;
////	}
//
//	private static long expiryDuration = 24L * 60L * 60L; // 24 hours in seconds token expiry time
//
//	private static final String AES_ALGORITHM = "AES";
//	private static final String ENCODING = "UTF-8";
//
////	private Optional<BrokerMaster> findByBrokerId;
//
////	public String generateJwt(Users user, UsersRelation userRelation, BrokerMaster brokerMaster) {
////		long milliTime = System.currentTimeMillis();
////		long expiryTime = milliTime + expiryDuration * 1000;
////
////		Date issuedAt = new Date(milliTime);
////		Date expiryAt = new Date(expiryTime);
////
////		// Claims
////		String issuer = (user.getUser_id() != null) ? user.getUser_id().toString() : "N/A";
////		Claims claims = Jwts.claims().setIssuer(issuer).setIssuedAt(issuedAt).setExpiration(expiryAt);
////
////		// Optional claims for Users
////		claims.put("firstname", user.getFirst_name());
////		claims.put("lastname", user.getLast_name());
////		claims.put("username", user.getUsername());
////		claims.put("emailId", user.getEmailId());
////		claims.put("userid", user.getUser_id());
////		claims.put("brokerId", user.getBrokerId());
////
////		// Additional claims for UsersRelation
////		claims.put("role_id", userRelation.getRole_id());
////
////		claims.put("brokerAlias", brokerMaster.getBrokerAlias());
////
////		String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, Constant.SECRET_KEY)
////				.compact();
////
////		return token;
////	}
//
//	public String generateJwt(Users user, UsersRelation userRelation, BrokerMaster brokerMaster,String status) {
//		long milliTime = System.currentTimeMillis();
//		long expiryTime = milliTime + expiryDuration * 1000;
//
//		Date issuedAt = new Date(milliTime);
//		Date expiryAt = new Date(expiryTime);
//
//		// Claims
//		String issuer = (user.getUser_id() != null) ? user.getUser_id().toString() : "N/A";
//		Claims claims = Jwts.claims().setIssuer(issuer).setIssuedAt(issuedAt).setExpiration(expiryAt);
//
//		// Optional claims for Users
//		claims.put("firstname", user.getFirst_name());
//		claims.put("lastname", user.getLast_name());
//		claims.put("username", user.getUsername());
//		claims.put("emailId", user.getEmailId());
//		claims.put("userid", user.getUser_id());
//		claims.put("brokerId", user.getBrokerId());
//		claims.put("roleId", userRelation.getRole_id());
//		Character isLobSpecific = user.getIsLobSpecific();
//		if(isLobSpecific != null && isLobSpecific.equals('Y')) {
//			 List<Long> lobIds = extractLobIdsForUser(user.getUser_id().intValue());
//			claims.put("mappedLobIds", lobIds);		
//		}else {		
//			claims.put("mappedLobIds", new ArrayList<Long>());
//		}
//		// Include the role hierarchy in the claims
//		List<Long> roleHierarchy = extractRolesIdWithHierarchy(Long.valueOf(userRelation.getRole_id()),
//				Long.valueOf(userRelation.getRole_id()));
//		System.err.println("roleHierarchy " + roleHierarchy);
//		
//		List<Long> userHierarchy = extractUsersWithHierarchy(user.getUser_id());
//		if(user.getBranchId()!=null) {
//		List<Long> branchHierarchy = extractBranchWithHierarchy(user.getBranchId().longValue());
//		claims.put("mappedBranchId", branchHierarchy);
//		}else {
//			claims.put("mappedBranchId", "");
//		}
//		
//		Optional<BrokerMaster>	findByBrokerId = brokerMasterRepository.findByBrokerId(user.getBrokerId());
//		Character isBillingEnable = findByBrokerId.get().getIsBillingEnable();
//		if (isBillingEnable != null) {
//			claims.put("isBillingEnable", isBillingEnable);
//		}else {
//			claims.put("isBillingEnable", 'N');
//		}
//
//		claims.put("mappedUserId", userHierarchy);		
//		claims.put("mappedRoleId", roleHierarchy);
//		claims.put("forcePassword", status);
//		claims.put("brokerAlias", brokerMaster.getBrokerAlias());
//		claims.put("subdomain", brokerMaster.getSubdomain());
//		String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, Constant.SECRET_KEY)
//				.compact();
//
//		// Additional claims for UsersRelation
//
//		return token;
//	}
//	
//	public static Character extractIsBillingEnableFromToken(String token) throws AccessDeniedException {
//	    try {
//	        // Decrypt the token and parse claims
//	        String decrypt = decrypt(token, Constant.SECRET_KEY);
//	        Claims claims = Jwts.parser().setSigningKey(Constant.SECRET_KEY).parseClaimsJws(decrypt).getBody();
//	        
//	        // Extract isBillingEnable as String and convert it to Character
//	        String isBillingEnableStr = claims.get("isBillingEnable", String.class);
//	        return (isBillingEnableStr != null && !isBillingEnableStr.isEmpty()) ? isBillingEnableStr.charAt(0) : null;
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        throw new AccessDeniedException("Access Denied: Invalid Token");
//	    }
//	}
//	
//	public static List<Long> extractLobIdsForUser(Integer userId) {
//	    List<Long> lobIds = new ArrayList<>();
//	    lobIds = usersLobRelationRepository.findLobIdsByUserId(userId.intValue());  
//	    return lobIds;
//	}
//	
//	public static List<Long> extractLobIdsForUserFromToken(String token) throws AccessDeniedException {
//	    try {
//
//	        String decrypt = decrypt(token, Constant.SECRET_KEY);
//	        Claims claims = Jwts.parser().setSigningKey(Constant.SECRET_KEY).parseClaimsJws(decrypt).getBody();
//	        	
//	        List<Integer> lobIdsAsIntegers = claims.get("mappedLobIds", List.class);
//	        List<Long> lobIds = new ArrayList<>();
//	        
//	        for (Integer id : lobIdsAsIntegers) {
//	            lobIds.add(id.longValue());
//	        }
//	        
//	        return lobIds;
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        throw new AccessDeniedException("Access Denied: Invalid Token");
//	    }
//	}
//
//	public static String extractDomainFromToken(String token) throws AccessDeniedException {
//		try {
//			String decrypt = decrypt(token, Constant.SECRET_KEY);
//
//			Claims claims = Jwts.parser().setSigningKey(Constant.SECRET_KEY).parseClaimsJws(decrypt).getBody();
//			System.err.println(claims);
//			return claims.get("subdomain", String.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new AccessDeniedException("Access Denied: Broker id is not available for that user");
//		}
//	}
//
//	public static int extractBrokerIdFromToken(String token) throws AccessDeniedException {
//		try {
//			String decrypt = decrypt(token, Constant.SECRET_KEY);
//
//			Claims claims = Jwts.parser().setSigningKey(Constant.SECRET_KEY).parseClaimsJws(decrypt).getBody();
//			return claims.get("brokerId", Integer.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new AccessDeniedException("Access Denied: Broker id is not available for that user");
//		}
//	}
//
//	public static List<String> extractUsersFromToken(String token) throws AccessDeniedException {
//		try {
//			Claims claims = Jwts.parser().setSigningKey(Constant.SECRET_KEY).parseClaimsJws(token).getBody();
//			String lastname = claims.get("lastname", String.class);
//			String username = claims.get("username", String.class);
//			String emailId = claims.get("emailId", String.class);
//			String firstname = claims.get("firstname", String.class);
//
//			return Arrays.asList(firstname, lastname, username, emailId);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new AccessDeniedException("Access Denied: Invalid Token");
//		}
//	}
//
//	public static Integer extractUserIdFromToken(String token) throws AccessDeniedException {
//		try {
//			String decrypt = decrypt(token, Constant.SECRET_KEY);
//			Claims claims = Jwts.parser().setSigningKey(Constant.SECRET_KEY).parseClaimsJws(decrypt).getBody();
//			return claims.get("userid", Integer.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new AccessDeniedException("Access Denied: Invalid Token");
//		}
//	}
//
//	public static int extractRolesIdFromToken(String token) throws AccessDeniedException {
//
//		try {
//
//			String decrypt = decrypt(token, Constant.SECRET_KEY);
//
//			Claims claims = Jwts.parser().setSigningKey(Constant.SECRET_KEY).parseClaimsJws(decrypt).getBody();
////			System.out.println(claims + " main claims in env");
//			return claims.get("roleId", Integer.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new AccessDeniedException("Access Denied: Invalid Token");
//		}
//	}
//
//	public static String extractBrokerAliasFromToken(String token) throws AccessDeniedException {
//		try {
//
//			String decrypt = decrypt(token, Constant.SECRET_KEY);
//			Claims claims = Jwts.parser().setSigningKey(Constant.SECRET_KEY).parseClaimsJws(decrypt).getBody();
//			return claims.get("brokerAlias", String.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new AccessDeniedException("Access Denied: Broker alias is not available for that user");
//		}
//
//	}
//
//	public static String decrypt(String input, String key) {
//		try {
//			Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
//			byte[] keyBytes = key.getBytes(ENCODING);
//			SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, AES_ALGORITHM);
//			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
//
//			byte[] decodedBytes = Base64.getDecoder().decode(input);
//			byte[] decryptedBytes = cipher.doFinal(decodedBytes);
//			return new String(decryptedBytes, ENCODING);
//		} catch (Exception e) {
//			e.printStackTrace();
//			// Handle the exception appropriately
//			return null;
//		}
//	}
//	//EXTRACT BRANCH
//	public static List<Long> extractBranchWithHierarchy(Long branchId) {
//		List<Long> branchIds = new ArrayList<>();
//		branchIds.add(branchId);
//		fetchBranchHierarchy(branchId, branchIds);
//
//		// Remove the initial branchId from the list
//		branchIds.remove(branchId);
//
//		return branchIds;
//	}
//	
//	private static void fetchBranchHierarchy(Long branchId,  List<Long> branchIds) {
//		// Fetch the roles with the given parent role
//		List<BrokerOfficeLocation> branchChilds = brokerOfficeLocationRepository.findByParentId(branchId);
//
//		for (BrokerOfficeLocation childBranchId : branchChilds) {
//			// Check if the child user ID is not the same as the user's user ID
//			if (!childBranchId.getBrokerOfficeLocationRelationId().equals(branchId)) {
//				// Add the child userId to the list
//				branchIds.add(childBranchId.getBrokerOfficeLocationRelationId());
//
//				// Recursively fetch the hierarchy for the child branches
//				fetchBranchHierarchy(childBranchId.getBrokerOfficeLocationRelationId(), branchIds);
//			}
//		}
//	}
//	
//	//EXTRACT USERS
//	public static List<Long> extractUsersWithHierarchy(Long userId) {
//		List<Long> userIds = new ArrayList<>();
//		userIds.add(userId);
//		fetchUserHierarchy(userId, userIds);
//
//		// Remove the initial userId from the list
//		userIds.remove(userId);
//
//		return userIds;
//	}
//	//FETCH USERS
//	private static void fetchUserHierarchy(Long userId,  List<Long> userIds) {
//		// Fetch the roles with the given parent role
//		List<Users> userChilds = usersRepository.findByParentId(userId);
//		if(userChilds != null && !userChilds.isEmpty())
//		{
//			for (Users childUserId : userChilds) {
//				// Check if the child user ID is not the same as the user's user ID
//				if (!childUserId.getUser_id().equals(userId)) {
//					// Add the child userId to the list
//					userIds.add(childUserId.getUser_id());
//	
//					// Recursively fetch the hierarchy for the child users
//					fetchUserHierarchy(childUserId.getUser_id(), userIds);
//				}
//			}
//		}
//
//	}
//	
//
//	public static List<Long> extractRolesIdWithHierarchy(Long roleId, Long userRoleId) {
//		List<Long> roleIds = new ArrayList<>();
//		roleIds.add(roleId);
//		fetchRoleHierarchy(roleId, roleIds, userRoleId);
//
//		// Remove the initial roleId from the list
//		roleIds.remove(userRoleId);
//
//		return roleIds;
//	}
//
//	private static void fetchRoleHierarchy(Long roleId, List<Long> roleIds, Long userRoleId) {
//		// Fetch the roles with the given parent role
//		List<RoleMaster> childRoles = roleMasterRepository.findByParent(roleId);
//
//		for (RoleMaster childRole : childRoles) {
//			// Check if the child role ID is not the same as the user's role ID
//			if (!childRole.getRoleid().equals(userRoleId)) {
//				// Add the child role to the list
//				roleIds.add(childRole.getRoleid());
//
//				// Recursively fetch the hierarchy for the child role
//				fetchRoleHierarchy(childRole.getRoleid(), roleIds, userRoleId);
//			}
//		}
//	}
//
//	public static List<Long> extractRolesIdWithHierarchys(Long roleId, Long userRoleId,Integer brokerId) {
//		List<Long> roleIds = new ArrayList<>();
//		roleIds.add(roleId);
//		fetchRoleHierarchys(roleId, roleIds, userRoleId,brokerId);
//
//		// Remove the initial roleId from the list
//		roleIds.remove(userRoleId);
//
//		return roleIds;
//	}
//
//
//	private static void fetchRoleHierarchys(Long roleId, List<Long> roleIds, Long userRoleId,Integer brokerId) {
//		// Fetch the roles with the given parent role
//		List<RoleMaster> childRoles = roleMasterRepository.findByParentAndBrokerId(roleId,brokerId);
//
//		for (RoleMaster childRole : childRoles) {
//			// Check if the child role ID is not the same as the user's role ID
//			if (!childRole.getRoleid().equals(userRoleId)) {
//				// Add the child role to the list
//				roleIds.add(childRole.getRoleid());
//
//				// Recursively fetch the hierarchy for the child role
//				fetchRoleHierarchy(childRole.getRoleid(), roleIds, userRoleId);
//			}
//		}
//	}
////	private void fetchRoleHierarchy(Long roleId, List<Long> roleIds, Long userRoleId) {
////		// Fetch the roles with the given parent role
////		List<RoleMaster> childRoles = roleMasterRepository.findByParent(roleId);
////
////		for (RoleMaster childRole : childRoles) {
////			// Check if the child role ID is not the same as the user's role ID
////			if (!childRole.getRoleid().equals(userRoleId)) {
////				// Add the child role to the list
////				roleIds.add(childRole.getRoleid());
////
////				// Recursively fetch the hierarchy for the child role
////				fetchRoleHierarchy(childRole.getRoleid(), roleIds, userRoleId);
////			}
////		}
////	}
//
}
