package com.shopify.shopifyapp.item;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author archa
 * Repository class to execute the database operations
 */
@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, Long>{

	@Transactional
	void deleteByItemId(Long id);
	ItemEntity findByItemId(Long id);

}

