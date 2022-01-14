package com.shopify.shopifyapp.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author archa
 * 
 * Entity Class to interact with the database
 * Consists of Getter, Setter, Constructors
 */
@Entity
@Table(name = "item")
public class ItemEntity {

	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long itemId;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="item_category")
	private String itemCategory;
	
	@Column(name="item_price")
	private Double itemPrice;

	@Column(name="total_price")
	private Double totalPrice;
		
	@Column(name="item_quantity")
	private Long itemQuantity;
	
	@Column(name="item_remaining")
	private Long itemRemaining;
	
	@Column(name="supplier_id")
	private Long supplierId;

	@Column(name="arrival_time")
	private String arrivalTime;
	
	@Column(name="updated_time")
	private String updatedTime;
	
	@Column(name="image_url")
	private String itemURL;
	
	public ItemEntity() {
		super();
	}	

	public ItemEntity(Long itemId, String itemName, String itemCategory, Double itemPrice, Double totalPrice,
			Long itemQuantity, Long itemRemaining,  Long supplierId, String arrivalTime,
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
