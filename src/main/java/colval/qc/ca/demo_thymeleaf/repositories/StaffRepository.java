package colval.qc.ca.demo_thymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import colval.qc.ca.demo_thymeleaf.model.enitties.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findStaffByFirstName(String firstName);
    Staff findStaffByFirstNameAndLastName(String firstName, String lastName);
}
