package com.example.demo.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Constant {

	public static final char YES = 'Y';
	public static final char NO = 'N';

	public final static double SLOW_LOG_THRESHHOLD = 1;
	public  final static boolean IS_ENABLE_SLOWLOG = true;
	public static final char Expiry_Token_Time = 30;
	public static final String SECRET_KEY = "0123456789abcdef0123456789abcdef";
	public static final String APP_ENV = "uat";

	public static final String POLICY_ENTRY = "transactionDrafts";
	
	public static final String CLAIM_DETAILS = "claim_details";
	public static final String CLAIM_EXPENSES ="calim_expenses";
	
	public static final String ENDORSEMENT_MEMBER = "endorsement_member_archived_data";
	
	public static final String ENDORSEMENT_NOMINEE = "endorsement_nominee_archived_data";
	
	public static final String ENDORSEMENT_ADDON = "endorsement_addon_archived_data";
	
	@Value("${spring.data.mongodb.uri:}")
	public String MONGO_URI1;
	
	public static final String MONGO_URI = "mongodb://brocore2:brocore900%23@127.0.0.1:27017/brocore?tls=false&authSource=admin";

	public static final String LOCAL_MONGO_URI = "mongodb://brocore2:brocore900%23@13.200.56.164:27017/brocore?tls=false&authSource=admin";
	public static final String UAT = "https://uatapibrocore.fynity.in/documents/";
	
	public static final String APP_URL = "https://uatapibrocore.fynity.in/";

	public static final String FILE_PATH = "/var/www/html/brocore_resources/images/";
	public static final String INTERNAL_FILE_PATH = "/var/www/html/brocore_resources/images/";

	public static final String DOC_PATH = "/var/www/html/brocore_resources/documents/";
	public static final String TEMP_DOC_PATH = "/var/www/html/brocore_resources/tempdocuments/";
	public static final String LOCAL_FILE_PATH = "C:/images/";

	public static final String LOCAL_FILE_PATH_XL = "C:/excel/";
	public static final String FRONTEND_URL = "https://brocore.fynity.in/";

	
	public static final String GLOBAL_DATE_FORMAT = "dd-MM-yyyy";


	public static final String OCR_URL = "https://mdmuat.fynity.in/read_policy_copy_ocr";
	public static final String OCR_TOKEN = "8fe7cadc-6a1d-44d3-ab06-b6036698298a";
	
	public static final long MAX_EXCEL_UPLOAD_SIZE=5242880;  //5*1024*1024
	
	public static final int CLEAR_CACHE_INTERVAL=7;
	public static  Integer process_background_excel=50;
	public static Integer BATCH_EXCEL_UPLOAD_SIZE = 100;

    public static final Integer BATCH_SIZE = 100;
	public static final String CLAIM_DRAFT = "claimDrafts";
	public static final String SMS_LOGS = "sms_logs";
	public static final String WHATSAPP_LOGS = "whatsapp_logs";


	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}