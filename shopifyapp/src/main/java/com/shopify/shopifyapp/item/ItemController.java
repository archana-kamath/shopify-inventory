package com.shopify.shopifyapp.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author archa
 * Controller class that provides REST API to create, edit, delete and view the items data
 * There is API to upload the item image to S3 bucket
 */
@Controller 
@RequestMapping(path="/shopify/item")
//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*",allowCredentials = "true")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	
	/**
	 * API to add the item details to the database
	 * @param aItem
	 * @return
	 * @throws ItemException 
	 */
	@PostMapping(path="/add")
	public @ResponseBody String addItem(@RequestBody Item aItem) throws ItemException {
		String message="";
		try {
			message = itemService.createItem(aItem);
		} catch (ItemException e) {
			message = "Error while Adding Item Data";
			throw new ItemException("Error while Adding Item Data");
		}
		return message;
	}
	
	/**
	 * API to update the item details in the database
	 * @param aItem
	 * @return
	 */
	@PostMapping(path="/update")
	public @ResponseBody String updateItem(@RequestBody Item aItem)  throws ItemException {
		String message="";
		try {
			message = itemService.saveOrUpdate(aItem);
		} catch (ItemException e) {
			message = "Error while Updating Item Data";
			throw new ItemException("Error while Updating Item Data");
		}
		return message;
	}

	/**
	 * API to delete the item details from database
	 * @param item
	 * @return
	 */
	@PostMapping(path="/delete")
	public @ResponseBody String deleteItem(@RequestBody Item item)   throws ItemException {
		String message="";
		try {
			message = itemService.deleteItem(item.getItemId());
		} catch (ItemException e) {
			message = "Error While Deleting Item Data";
			throw new ItemException("Error While Deleting Item Data");
		}
		return message;
	}
	/**
	 * API to list all the data in the database
	 * @return
	 * @throws ItemException 
	 */
	@GetMapping(path="/view-all")
	public @ResponseBody List<Item> viewItems() throws ItemException {
		return itemService.viewItems();
	}
	
	/**
	 * API that uploads the image to the S3 bucket
	 * @param multipartFile
	 * @return
	 */
	@PostMapping(value= "/uploadImage")
    public ResponseEntity<String> uploadFile (
    		@RequestPart(value = "file") final MultipartFile multipartFile)  throws ItemException{

		itemService.uploadFile(multipartFile);
		
		final String response = "[" + multipartFile.getOriginalFilename() + "] uploaded successfully.";
        return new ResponseEntity<>(response, HttpStatus.OK);
       
    }
}
