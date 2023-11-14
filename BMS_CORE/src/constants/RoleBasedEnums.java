package constants;

public class RoleBasedEnums {
	
	public static final String BMS_OWNER = "BMS_OWNER";
	public static final String BMS_MANAGER = "BMS_MANAGER";
	public static final String BMS_ACCOUNTANT = "BMS_ACCOUNTANT";
	public static final String BMS_EXICUTIVE = "BMS_EXICUTIVE";

	public static enum BMS_OWNER {
	    CHECK_GST("1", "Check GST"),
	    CHECK_BILLS("2", "Check Bills"),
		CHECK_WORKER_DETAILS("3", "Check Worker Details"),
		CHECK_INVENTORY_ITEMS("4", "Check Inventory Items"),
		GENRATE_BILLS("5", "Genrate Bill"),
		ORDER_ITEMS("6", "Order Items");

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
		ORDER_ITEMS("5", "Order Items");

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
	    CHECK_PRODUCT_GST("2", "Check Product GST");

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
		GENRATE_BILLS("2", "Genrate Bill");

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
