package com.exam.repositories;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.models.panier;
import com.exam.models.produit;

public interface panierRepository extends JpaRepository<panier, Long> {
    @Query("select produit from panier where client_id =:clientId")
	List<produit> findProduitsByPanier(@Param("clientId") Long Id);
	@Query("from panier where client_id =:clientId")
	//HashMap<produit,> findProduitsByClient(@Param("clientId") Long Id);
	List<panier> findPaniersById(@Param("clientId") Long Id);
}
