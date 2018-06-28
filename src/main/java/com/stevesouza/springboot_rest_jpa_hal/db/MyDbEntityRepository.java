package com.stevesouza.springboot_rest_jpa_hal.db;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
	
	/**
	 * http://localhost:8080/mydbentity/search/findByStrField1AndStrField2?strfield1=steve&strfield2=souza
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	
	List<MyDbEntity> findByStrField1AndStrField2(@Param("strfield1") String str1, @Param("strfield2") String str2 );
	
	/**
	 * http://localhost:8080/mydbentity/search/findByAgeLessThan?age=57
	 * 
	 * @param age
	 * @return
	 */
    List<MyDbEntity> findByAgeLessThan(@Param("age") int age);
    
    /**
     * http://localhost:8080/mydbentity/search/countByAgeLessThan?age=60
     * 
     * @param age
     * @return
     */

    long countByAgeLessThan(@Param("age") int age);
    
    @Query("SELECT e.strField1 FROM MyDbEntity e where e.strField1 = :strfield1") 
    String findByStrField1WithQuery(@Param("strfield1") String str);

}
