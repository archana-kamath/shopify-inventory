package com.shopify.shopifyapp.item;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.shopify.shopifyapp.AWSConfig;

/**
 * @author archa
 * 
 * This class consists of validation, database interactions, logging and exception handling
 * 
 */
@Service
@Transactional
public class ItemService{
	
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ItemMapper itemMapper;
		
	@Autowired
	private AWSConfig awsConfig;
	
	
	@Value("${aws.s3.bucket}")
    private String bucketName;
	
	
	/**
	 * @param aItem
	 * @return
	 * 
	 * Item details are added to the database
	 * Validation is present 
	 * @throws ItemException 
	 * 
	 */
	public String createItem(Item aItem) throws ItemException {
		
		String errorMessage = "";
		if(itemValidation(aItem, errorMessage)) {
			return errorMessage;
		}

		ItemEntity myItemEntity = itemMapper.mapModelToEntity(aItem);
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		myItemEntity.setArrivalTime(formatter.format(calendar.getTime()).toString());
		myItemEntity.setUpdatedTime(formatter.format(calendar.getTime()).toString());
		
		itemRepository.save(myItemEntity);
	    return "Success Add";
	}

	/**
	 * @param aItem
	 * @param errorMessage
	 * @return
	 * 
	 * Validation to check if all the required fields are entered 
	 * @throws ItemException 
	 */
	public boolean itemValidation(Item aItem, String errorMessage) throws ItemException {
		
		boolean errorStatus;
		errorStatus = false;
		if(aItem.getItemName()==null) {
			errorMessage = "Please Enter Item Name";
			errorStatus =  true;
		}
		if(aItem.getItemCategory()==null) {
			errorMessage = "Please Enter Item Category";
			errorStatus =   true;
		}
		if(aItem.getItemPrice()==null) {
			errorMessage = "Please Enter Price of each item";
			errorStatus =   true;
		}
		if(aItem.getTotalPrice()==null) {
			errorMessage = "Please Enter Total Price";
			errorStatus =   true;
		}
		if(aItem.getItemQuantity()==null) {
			errorMessage = "Please Enter Quantity";
			errorStatus =   true;
		}
		if(aItem.getItemRemaining()==null) {
			errorMessage =  "Please Enter Quantity Remaining";
			errorStatus =   true;
		}
		if(aItem.getSupplierId()==null) {
			errorMessage = "Please Enter Supplier ID";
			errorStatus =   true;
		}
		if(aItem.getItemURL()==null) {
			errorMessage = "Please Upload an image";
			errorStatus =   true;
		}

		return errorStatus;
	}

	public String deleteItem(Long id) throws ItemException {
		System.out.println("deleting "+id);
		itemRepository.deleteByItemId(id);
		return "Sucess Delete";
	}

	public List<Item> viewItems()  throws ItemException {
		List<ItemEntity> itemEntityList = new ArrayList<ItemEntity>();		
		itemRepository.findAll().forEach(itemEntityList::add);
		
		List itemList = new ArrayList<Item>();
		for(ItemEntity itemEntity: itemEntityList) {
			itemList.add(itemMapper.mapEntityToModel(itemEntity));
		}
		return itemList;
	}
	/**
	 * @param id
	 * @param aItem
	 * @return
	 * 
	 * Service method to the update the item details
	 * All the other fields can be updated
	 * Exception: The option to update the image is not provided.
	 */
	public String saveOrUpdate(Item aItem)throws ItemException {
	
			ItemEntity itemEntity =  itemRepository.findByItemId(aItem.getItemId());
			ItemEntity updateItemEntity = new ItemEntity();
			
			if(aItem.getItemName()==null) {
				updateItemEntity.setItemName(itemEntity.getItemName());
			}else {
				updateItemEntity.setItemName(aItem.getItemName());
			}
		
			if(aItem.getItemCategory()==null) {
				updateItemEntity.setItemCategory(itemEntity.getItemCategory());
			}else {
				updateItemEntity.setItemCategory(aItem.getItemCategory());
			}
		
			if(aItem.getItemPrice()==null) {
				updateItemEntity.setItemPrice(itemEntity.getItemPrice());
			}else {
				updateItemEntity.setItemPrice(aItem.getItemPrice());
			}
			
			if(aItem.getTotalPrice()==null) {
				updateItemEntity.setTotalPrice(itemEntity.getTotalPrice());
			}else {
				updateItemEntity.setTotalPrice(aItem.getTotalPrice());
			}
		
			if(aItem.getItemQuantity()==null) {
				updateItemEntity.setItemQuantity(itemEntity.getItemQuantity());
			}else {
				updateItemEntity.setItemQuantity(aItem.getItemQuantity());
			}
			
			if(aItem.getItemRemaining()==(null)) {
				updateItemEntity.setItemRemaining(itemEntity.getItemRemaining());
			}else {
				updateItemEntity.setItemRemaining(aItem.getItemRemaining());
			}
			
			if(aItem.getSupplierId()==null) {
				updateItemEntity.setSupplierId(itemEntity.getSupplierId());
			}else {
				updateItemEntity.setSupplierId(aItem.getSupplierId());
			}
			
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
			updateItemEntity.setUpdatedTime(formatter.format(calendar.getTime()).toString());
			
			updateItemEntity.setItemId(aItem.getItemId());
			updateItemEntity.setItemId(itemEntity.getItemId());
		    itemRepository.save(updateItemEntity);
		    return "Update success";
			}

	 	/**
	 	 * @param multipartFile
	 	 * This method to the file to AWS S3 bucket
	 	 */
	 	@Async
	    public void uploadFile(final MultipartFile multipartFile) {
	       	    try {
	            final File file = convertMultiPartFileToFile(multipartFile);
	            
	            uploadFileToS3Bucket(bucketName, file);
	            file.delete(); 
	            
	        } catch (final AmazonServiceException ex) {
	        	System.out.println("Error= {} while uploading file."+ ex.getMessage());
	        }
	    }
	 
	 /**
	 * @param multipartFile
	 * @return
	 * This method to the file to AWS S3 bucket
	 */
	 private File convertMultiPartFileToFile(final MultipartFile multipartFile) {
	        
	    	final File file = new File(multipartFile.getOriginalFilename());
	        try (final FileOutputStream outputStream = new FileOutputStream(file)) {
	            outputStream.write(multipartFile.getBytes());
	        } catch (final IOException ex) {
	        	ex.getMessage();
	        }
	        return file;
	 }
	 
	    /**
	     * @param bucketName
	     * @param file
	     * This method to the file to AWS S3 bucket
	     */
	 private void uploadFileToS3Bucket(final String bucketName, final File file) {
	    	final String uniqueFileName = file.getName();
	        final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uniqueFileName, file);
	        awsConfig.s3().putObject(putObjectRequest);
	 }
}
