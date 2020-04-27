package com.myproject.learn.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myproject.learn.model.Product;
@Repository
public interface ProductReposioty extends JpaRepository<Product, Long> {
    @Query(value = "SELECT ID \n"
    		+ " FROM product \n"
    		+ " ORDER BY ID DESC LIMIT 1 \n",nativeQuery = true)
    String getNextId();
    @Modifying
    @Query(value = "INSERT INTO product(id,color,product_type,size,price) \n"
    		+ " VALUES (:id,:color,:producttype,:size,:price) \n",nativeQuery = true)
    void saveProduct(@Param("id") String id,@Param("color") String color,@Param("producttype") String producttype,@Param("size") String size,@Param("price") String price);
    
    @Query(value = "SELECT A.id as ID \n"
    		+ " ,B.id as PRODUCTTYPEID \n"
    		+ " ,B.name as PRODUCTNAME \n"
    		+ " ,C.id as COLORID \n"
    		+ " ,C.name as COLORNAME \n"
    		+ " ,C.code as COLORCODE \n"
    		+ " ,D.id as IDSIZE \n"
    		+ " ,D.length as LENGTH \n"
    		+ " ,D.size_frontals as FRONTAL \n"
    		+ " ,A.price as PRICE \n"
    		+"  ,GROUP_CONCAT(E.image_url SEPARATOR ',') AS IMAGE_URL \n"
    	    + " ,GROUP_CONCAT(E.ref_key SEPARATOR ',') AS REF_KEY \n"
    		+ " FROM ((((product A JOIN producttype B ON A.product_type = B.id) \n"
    		+ "  JOIN color C ON A.color = C.id ) JOIN size D ON A.size = D.id )  LEFT JOIN image_detail E ON A.id = E.id_product) \n"
    		+ " WHERE A.product_type = B.id AND A.color = C.id AND A.size = D.id \n"
    		+ " AND (COALESCE(:length,null) is null OR D.length IN (:length)) \n"
    		+ " AND (COALESCE(:producttype,null) is null OR A.product_type IN (:producttype)) \n"
    		+ " AND (COALESCE(:color,null) is null OR A.color IN (:color)) \n"
    		+ " AND (COALESCE(:productId,null) is null OR A.id like %:productId%) \n"
    		+ " AND (COALESCE(:productTypeName,null) is null OR B.name like %:productTypeName%) \n"
    		+ " GROUP BY A.id "
    		+ " \n-- #pageable\n",
    		countQuery = "SELECT COUNT(*) \n"
    				+ " FROM (((product A JOIN producttype B ON A.product_type = B.id) \n"
    			  	+ " JOIN color C ON A.color = C.id ) JOIN size D ON A.size = D.id ) \n"
    				+ " WHERE A.product_type = B.id AND A.color = C.id AND A.size = D.id \n"
    	    		+ " AND (COALESCE(:producttype,null) is null OR A.product_type IN (:producttype)) \n"
    	    		+ " AND (COALESCE(:length,null) is null OR D.length IN (:length)) \n"
    	    		+ " AND (COALESCE(:color,null) is null OR A.color IN (:color)) \n"
    	    		+ " AND (COALESCE(:productId,null) is null OR A.id like %:productId%) \n"
    	    		+ " AND (COALESCE(:productTypeName,null) is null OR B.name like %:productTypeName%) ",
    		nativeQuery = true)
    Page<Object[]> getAllProduct(@Param("productTypeName") String productTypeName,@Param("producttype") List<String> productType,@Param("length") List<String> length,@Param("color") List<String> color,@Param("productId") String productId, Pageable pageable);
    
   @Query(value = "SELECT A.id as ID \n" + 
   		"    		,B.id as PRODUCTTYPEID \n" + 
   		"    		,B.name as PRODUCTNAME \n" + 
   		"    		,C.id as COLORID \n" + 
   		"    		,C.name as COLORNAME \n" + 
   		"    		,C.code as COLORCODE \n"+
   		"           ,D.id as IDSIZE \n" + 
   		"    		,D.length as LENGTH \n" + 
   		"    		,D.size_frontals as FRONTAL \n" + 
   		"    		,A.price as PRICE \n "+ 
   		"           ,GROUP_CONCAT(E.image_url SEPARATOR ',') AS IMAGE_URL \n"
   		+ "         ,GROUP_CONCAT(E.ref_key SEPARATOR ',') AS REF_KEY \n" +
   		"    		FROM ((((product A JOIN producttype B ON A.product_type = B.id) \n" + 
   		"    		JOIN color C ON A.color = C.id ) JOIN size D ON A.size = D.id ) LEFT JOIN image_detail E ON A.id = E.id_product) \n"
   		+ "         WHERE A.id LIKE %:idProduct%",nativeQuery = true)
   List<Object[]> getProductById(@Param("idProduct") String idProduct);
   
   @Query(value ="SELECT A.id as ID \n"
   		+ "       	,A.name as NAME \n"
   		+ "			,A.code as CODE \n"
   		+ "			,B.id as PRODUCT_ID \n"
   		+ "			,B.price as PRICE \n"
   		+ "			,C.length as LENGTH \n"
   		+ "			,GROUP_CONCAT(E.image_url SEPARATOR ',') as IMAGE \n"
   		+ "		FROM ((color A inner join product B on A.id = B.color) inner join size C on B.size = C.id) left join image_detail E ON B.id = E.id_product \n"
   		+ "     WHERE B.product_type =:productType \n"
   		+ "		GROUP BY B.id \n"
   		+ "		ORDER BY A.id,A.name,A.code",
   		nativeQuery = true)
   List<Object[]> getInfoProduct(@Param("productType") String productTypr);
}
