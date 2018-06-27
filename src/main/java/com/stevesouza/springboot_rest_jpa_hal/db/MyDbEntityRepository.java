package com.stevesouza.springboot_rest_jpa_hal.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
/**
 * There will automatically created endpoints to POST(create), PUT (update by providing full json), PATCH (update providing only 
 * fields you wish to replace), DELETE, GET (all data or 1 data). Note you pass the primary key in for most of these. You can also
 * use custom searches defined below in the request based on the name of them method.
 * 
 * Note you can also use the 'hal browser' to do the above: http://localhost:8080/browser/index.html
 * @author stevesouza
 *
 */
// Try with different interfaces to generate queries
// try @Query annotation.
@RepositoryRestResource(collectionResourceRel = "mydbentity", path = "mydbentity")
public interface MyDbEntityRepository extends JpaRepository<MyDbEntity, Long> {

	/**
	 * http://localhost:8080/mydbentity/search/findByStrField1?strfield1=steve
	 * 
	 * @param str1
	 * @return
	 */
	List<MyDbEntity> findByStrField1(@Param("strfield1") String str1);

}
