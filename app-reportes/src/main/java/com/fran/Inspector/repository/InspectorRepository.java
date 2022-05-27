package com.fran.Inspector.repository;



import com.fran.Inspector.model.Inspector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface InspectorRepository  extends JpaRepository<Inspector,Integer> {

    /*
    List<Inspector> getAllInspector();
     */

    @Query(value = "select * from inspector where id= :idinspector", nativeQuery = true)
    Inspector getInspectorById(@Param("idinspector") Integer id);

    @Query(value = "insert into inspector (name,cel,email)value(:nameinspector , :celinspector , :emailinspector )", nativeQuery = true)
    void addNewInspector (@Param("nameinspector") String name, @Param("celinspector") String cel, @Param("emailinspector") String email);

    /*
    void updateInspector (Inspector updateInspector);
    */

}
