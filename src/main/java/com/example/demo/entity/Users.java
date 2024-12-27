package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users_records")
public class Users {

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Users() {
	}

	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "updated_at", nullable = false)
	private Date updated_at;

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long user_id;

	@Column(name = "location", length = 50)
	private String location;

	@Column(name = "designation", length = 50)
	private String designation;

	@Column(name = "employee_id", length = 50)
	private String employeeId;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date created_at;

	//@NotBlank(message = "First name is required")
	@Column(name = "first_name")
	private String first_name;

	@Column(name = "user_refrence_id")
	private String userRefrenceId;

	@Column(name = "encrypted_pass")
	private String encrypted_pass;

	@Column(name = "parent_id")
	private Integer parentId;

	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "is_logged_in")
	private Character isLoggedIn;
	
	@Column(name = "branch_id")
	private Integer branchId;
	
	
	
	

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Character getIsLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(Character isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "role_id")
	private Integer roleId;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "user_status")
	private Character userStatus;

	@Column(name = "startdate")
	private Date startdate;

	@Column(name = "enddate")
	private Date enddate;

	@Column(name = "middle_name")
	private String middle_name;

	@Column(name = "last_name")
	private String last_name;

//	@Pattern(regexp = "^[a-zA-Z0-9_]{5,20}$", message = "Invalid username. It should be alphanumeric with minimum 5 and maximum 20 characters.")
	private String username;

	//@NotBlank(message = "Mobile number is required")
	@Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number. It should be a 10-digit number.")
	@Column(name = "mobile_no")
	private String mobileNo;

	//@NotBlank(message = "Email is required")
	@Email(message = "Invalid email")
	@Column(name = "email_id")
	@Size(max = 255)
	private String emailId;

	@ElementCollection
	@CollectionTable(name = "user_password_history", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "password")
	@Cascade({ org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE })
	private List<String> passwordHistory = new ArrayList<>();

	public List<String> getPasswordHistory() {
		return passwordHistory;
	}

	public void setPasswordHistory(List<String> passwordHistory) {
		this.passwordHistory = passwordHistory;
	}

	@Column(name = "password")
	private String password;

	public String getEncrypted_pass() {
		return encrypted_pass;
	}

	public void setEncrypted_pass(String encrypted_pass) {
		this.encrypted_pass = encrypted_pass;
	}

	public String getUserRefrenceId() {
		return userRefrenceId;
	}

	public void setUserRefrenceId(String userRefrenceId) {
		this.userRefrenceId = userRefrenceId;
	}

	@Column(name = "brokerId")
	private Integer brokerId;
	//
	// @Pattern(regexp = "\\d{10}")
	@Column(name = "alternate_mobile_no")
	private String alternate_mobile_no;

	// @Pattern(regexp = "\\d{10}")

	@Email
	@Column(name = "alternate_email_id")
	private String alternate_email_id;

	// @Pattern(regexp = "\\d{12}")
	@Column(name = "aadhaar_number")
	private String aadhaar_number;

	// @Pattern(regexp = "[A-Z]{5}\\d{4}[A-Z]{1}")
	@Column(name = "pancard")
	private String pancard;

	// @Pattern(regexp = "\\d{7}")
	@Column(name = "pincode")
	private String pincode;

	// Additional fields
	@Column(name = "status")
	private char status;

	@Column(name = "irdai_license_no")
	private String irdai_license_no;

	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private String start_date;

	@Column(name = "end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private String end_date;

	@Column(name = "user_temp_id")
	private String userTempId;

	// @Column(name = "lob_id")
	// private Long lob_id;

	@Column(name = "gender")
	private String gender;
	@Column(name = "department")
	private Long department;

	@Column(name = "user_type")
	private Long userType;

	@Column(name = "channel")
	private Long channel;

	@Column(name = "branch_name")
	private String branch_name;

	@Column(name = "zone")
	private String zone;
	
	@Column(name = "is_lob_specific")
	private Character isLobSpecific;
	
	@Column(name = "is_lob_wise_user_mapping")
	private Character isLobWiseUserMapping;
	
	@Column(name = "ic_agency_code_mapping_id")
	private Integer icAgencyCodeMappingId;
	
	

	public Integer getIcAgencyCodeMappingId() {
		return icAgencyCodeMappingId;
	}

	public void setIcAgencyCodeMappingId(Integer icAgencyCodeMappingId) {
		this.icAgencyCodeMappingId = icAgencyCodeMappingId;
	}

	public Character getIsLobSpecific() {
		return isLobSpecific;
	}

	public void setIsLobSpecific(Character isLobSpecific) {
		this.isLobSpecific = isLobSpecific;
	}
	
	

	public Character getIsLobWiseUserMapping() {
		return isLobWiseUserMapping;
	}

	public void setIsLobWiseUserMapping(Character isLobWiseUserMapping) {
		this.isLobWiseUserMapping = isLobWiseUserMapping;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public Long getUser_id() {
		return user_id;
	}

	public Users(Date updated_at, Long user_id, String location, String designation, String employeeId, Date created_at,
			@NotBlank(message = "First name is required") String first_name, String userRefrenceId,
			String encrypted_pass, Integer parentId, Integer createdBy, Integer roleId, Character userStatus,
			Date startdate, Date enddate, String middle_name, String last_name,
			@Pattern(regexp = "^[a-zA-Z0-9_]{5,20}$", message = "Invalid username. It should be alphanumeric with minimum 5 and maximum 20 characters.") String username,
			@NotBlank(message = "Mobile number is required") @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number. It should be a 10-digit number.") String mobileNo,
			@NotBlank(message = "Email is required") @Email(message = "Invalid email") @Size(max = 255) String emailId,
			List<String> passwordHistory, String password, Integer brokerId, String alternate_mobile_no,
			@Email String alternate_email_id, String aadhaar_number, String pancard, String pincode, char status,
			String irdai_license_no, String start_date, String end_date, String userTempId, String gender,
			Long department, Long userType, Long channel, String branch_name, String zone, String state, String city,
			String landmark, String address_line1, String address_line2) {
		super();
		this.updated_at = updated_at;
		this.user_id = user_id;
		this.location = location;
		this.designation = designation;
		this.employeeId = employeeId;
		this.created_at = created_at;
		this.first_name = first_name;
		this.userRefrenceId = userRefrenceId;
		this.encrypted_pass = encrypted_pass;
		this.parentId = parentId;
		this.createdBy = createdBy;
		this.roleId = roleId;
		this.userStatus = userStatus;
		this.startdate = startdate;
		this.enddate = enddate;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.username = username;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.passwordHistory = passwordHistory;
		this.password = password;
		this.brokerId = brokerId;
		this.alternate_mobile_no = alternate_mobile_no;
		this.alternate_email_id = alternate_email_id;
		this.aadhaar_number = aadhaar_number;
		this.pancard = pancard;
		this.pincode = pincode;
		this.status = status;
		this.irdai_license_no = irdai_license_no;
		this.start_date = start_date;
		this.end_date = end_date;
		this.userTempId = userTempId;
		this.gender = gender;
		this.department = department;
		this.userType = userType;
		this.channel = channel;
		this.branch_name = branch_name;
		this.zone = zone;
		this.state = state;
		this.city = city;
		this.landmark = landmark;
		this.address_line1 = address_line1;
		this.address_line2 = address_line2;
	}

	@Column(name = "state")
	private String state;

	@Column(name = "city")
	private String city;

	@Column(name = "landmark")
	private String landmark;

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAlternate_mobile_no() {
		return alternate_mobile_no;
	}

	public void setAlternate_mobile_no(String alternate_mobile_no) {
		this.alternate_mobile_no = alternate_mobile_no;
	}

	public String getAlternate_email_id() {
		return alternate_email_id;
	}

	public void setAlternate_email_id(String alternate_email_id) {
		this.alternate_email_id = alternate_email_id;
	}

	public String getAadhaar_number() {
		return aadhaar_number;
	}

	public void setAadhaar_number(String aadhaar_number) {
		this.aadhaar_number = aadhaar_number;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getIrdai_license_no() {
		return irdai_license_no;
	}

	public void setIrdai_license_no(String irdai_license_no) {
		this.irdai_license_no = irdai_license_no;
	}

	public Integer getBrokerId() {
		return brokerId;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getAddress_line1() {
		return address_line1;
	}

	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}

	public String getAddress_line2() {
		return address_line2;
	}

	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}

	public String getUserTempId() {
		return userTempId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getStartdate() {
		return startdate;
	}

	public Character getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Character userStatus) {
		this.userStatus = userStatus;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public void setUserTempId(String userTempId) {
		this.userTempId = userTempId;
	}

	public Long getDepartment() {
		return department;
	}

	public void setDepartment(Long department) {
		this.department = department;
	}

	public Long getUserType() {
		return userType;
	}

	public void setUserType(Long userType) {
		this.userType = userType;
	}

	public Long getChannel() {
		return channel;
	}

	public void setChannel(Long channel) {
		this.channel = channel;
	}

	public void setBrokerId(Integer brokerId) {
		this.brokerId = brokerId;
	}

	@Column(name = "address_line1")
	private String address_line1;

	@Column(name = "address_line2")
	private String address_line2;

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	


	// Getters and setters for the additional fields
}
