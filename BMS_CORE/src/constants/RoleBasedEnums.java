package constants;

import java.util.HashMap;
import java.util.Map;

public class RoleBasedEnums {
	
	public static final String BMS_OWNER_STRING = "BMS_OWNER";
	public static final String BMS_MANAGER_STRING = "BMS_MANAGER";
	public static final String BMS_ACCOUNTANT_STRING = "BMS_ACCOUNTANT";
	public static final String BMS_EXICUTIVE_STRING = "BMS_EXICUTIVE";
	
	public static final Map<String, String> BMS_ROLES = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
	{
        put("M", "BMS_MANAGER");
        put("E", "BMS_EXICUTIVE");
        put("A", "BMS_ACCOUNTANT");
    }};

	public static enum BMS_OWNER {
	    CHECK_GST("1", "Check GST"),
	    CHECK_BILLS("2", "Check Bills"),
		CHECK_WORKER_DETAILS("3", "Check Worker Details"),
		CHECK_INVENTORY_ITEMS("4", "Check Inventory Items"),
		GENRATE_BILLS("5", "Genrate Bill"),
		ORDER_ITEMS("6", "Order Items"),
		GRANT_ACCESS("7", "Check Pending Requests"),
		REVOKE_ACCESS("8", "Remove Any Employee"),
		BACK("9", "Back");

	    private final String id;
	    private final String key;

	    BMS_OWNER(String id, String key) {
	        this.id = id;
	        this.key = key;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getKey() {
	        return key;
	    }
	}
	
	public static enum BMS_MANAGER {
	    CHECK_BILLS("1", "Check Bills"),
		CHECK_WORKER_DETAILS("2", "Check Worker Details"),
		CHECK_INVENTORY_ITEMS("3", "Check Inventory Items"),
		GENRATE_BILLS("4", "Genrate Bill"),
		ORDER_ITEMS("5", "Order Items"),
		BACK("6", "Back");

	    private final String id;
	    private final String key;

	    BMS_MANAGER(String id, String key) {
	        this.id = id;
	        this.key = key;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getKey() {
	        return key;
	    }
	}
	
	public static enum BMS_ACCOUNTANT {
	    CHECK_BILLS("1", "Check Bills"),
	    CHECK_PRODUCT_GST("2", "Check Product GST"),
	    BACK("9", "Back");

	    private final String id;
	    private final String key;

	    BMS_ACCOUNTANT(String id, String key) {
	        this.id = id;
	        this.key = key;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getKey() {
	        return key;
	    }
	}
	
	public static enum BMS_EXICUTIVE {
	    CHECK_BILLS("1", "Check Bills"),
		GENRATE_BILLS("2", "Genrate Bill"),
		BACK("9", "Back");

	    private final String id;
	    private final String key;

	    BMS_EXICUTIVE(String id, String key) {
	        this.id = id;
	        this.key = key;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getKey() {
	        return key;
	    }
	}
}
