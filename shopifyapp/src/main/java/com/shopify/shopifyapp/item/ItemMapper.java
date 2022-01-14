package com.shopify.shopifyapp.item;

import org.springframework.stereotype.Component;

/**
 * @author archa
 * Mapper class to map model to entity object and viceversa
 */
@Component
public class ItemMapper {

	/**
	 * @param item
	 * @return
	 * To map the attributes from Model to Entity object
	 */
	public ItemEntity mapModelToEntity(Item item) {
		
		ItemEntity itemEntity = new ItemEntity(
				item.getItemId(),
				item.getItemName(), 
				item.getItemCategory(), 
				item.getItemPrice(), 
				item.getTotalPrice(), 
				item.getItemQuantity(), 
				item.getItemRemaining(),
				item.getSupplierId(),
				item.getArrivalTime(),
				item.getUpdatedTime(),
				item.getItemURL());
				
		
		return itemEntity;
	}
	
	/**
	 * @param aItemEntity
	 * @return
	 * To Map the attributes from Entity to Model object
	 */
	public Item mapEntityToModel(ItemEntity aItemEntity) {
		
		Item item = new Item(
				aItemEntity.getItemId(),
				aItemEntity.getItemName(), 
				aItemEntity.getItemCategory(), 
				aItemEntity.getItemPrice(), 
				aItemEntity.getTotalPrice(), 
				aItemEntity.getItemQuantity(), 
				aItemEntity.getItemRemaining(),
				aItemEntity.getSupplierId(),
				aItemEntity.getArrivalTime(),
				aItemEntity.getUpdatedTime(),
				aItemEntity.getItemURL()
				);
		
		return item;
	}

}
