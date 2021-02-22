package colval.qc.ca.demo_thymeleaf.services.impl;

import colval.qc.ca.demo_thymeleaf.model.enitties.Staff;
import colval.qc.ca.demo_thymeleaf.repositories.StaffRepository;
import colval.qc.ca.demo_thymeleaf.services.interfaces.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService implements IStaffService {
    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff create(Staff staff) {
        return null;
    }

    @Override
    public Optional<Staff> readOne(Long staffId) {
        return staffRepository.findById(staffId);
    }

    @Override
    public List<Staff> readAll() {
        return staffRepository.findAll();
    }

    @Override
    public void delete(Long staffId) {
        staffRepository.deleteById(staffId);
    }

    @Override
    public List<Staff> getAllTenRandomStaff() {
        return null;
    }
}
