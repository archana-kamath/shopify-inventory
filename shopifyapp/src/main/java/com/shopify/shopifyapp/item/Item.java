package com.shopify.shopifyapp.item;

/**
 * @author archa
 * 
 * This class has all the fields that form the Item
 * Consists of Getter, Setter, Constructors 
 * 
 * itemId - To uniquely identify the item 
 * itemName - Name of item 
 * itemCategory - Category of item 
 * itemPrice - Price per item 
 * totalPrice - Total cost of the items
 * itemQuantity - Number of items at arrival
 * itemRemaining - Number of items remaining after shipment
 * supplierId - To identify the supplier of the product 
 * arrivalTime - Date and time of arrival of Items 
 * updatedTime - Date and time when the data is modified 
 * itemURL - URL of the image where you can view the item 
 */
public class Item {
	
	private Long itemId;
	private String itemName;
	private String itemCategory;
	private Double itemPrice;
	private Double totalPrice;
	private Long itemQuantity;
	private Long itemRemaining;
	private Long supplierId;
	private String arrivalTime;
	private String updatedTime;
	private String itemURL;
	
	public Item() {
		super();
	}

	public Item(Long itemId, String itemName, String itemCategory, Double itemPrice, Double totalPrice,
			Long itemQuantity, Long itemRemaining, Long supplierId, String arrivalTime,
			String updatedTime, String itemURL) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemPrice = itemPrice;
		this.totalPrice = totalPrice;
		this.itemQuantity = itemQuantity;
		this.itemRemaining = itemRemaining;
		this.supplierId = supplierId;
		this.arrivalTime = arrivalTime;
		this.updatedTime = updatedTime;
		this.itemURL = itemURL;
		
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Long getItemRemaining() {
		return itemRemaining;
	}

	public void setItemRemaining(Long itemRemaining) {
		this.itemRemaining = itemRemaining;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getItemURL() {
		return itemURL;
	}

	public void setItemURL(String itemURL) {
		this.itemURL = itemURL;
	}

	
}
