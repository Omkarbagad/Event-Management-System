package com.capstoneproject.demo.backend.services;

import com.capstoneproject.demo.backend.entities.Registrations;
import com.capstoneproject.demo.backend.exceptions.RegistrationNotFoundException;
import com.capstoneproject.demo.backend.repositories.RegistrationsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationsRepository regRepository;

    @Autowired
    public RegistrationServiceImpl(RegistrationsRepository regRepository) {
        super();
        this.regRepository = regRepository;
    }

    @Override
    public List<Registrations> getAllRegistrations() {
        return regRepository.findAll();
    }

    @Override
    public Registrations getRegistrationById(Long id) {
        return regRepository.findById(id)
                .orElseThrow(() -> new RegistrationNotFoundException("Registration not found with ID: " + id));
    }

    @Override
    public Registrations createRegistration(@Valid Registrations reg) {
        return regRepository.save(reg);
    }

    @Override
    public Registrations updateRegistration(Long id, @Valid Registrations updated) {
        Registrations existing = regRepository.findById(id)
                .orElseThrow(() -> new RegistrationNotFoundException("Registration not found with ID: " + id));
        existing.setEventId(updated.getEventId());
        existing.setUserId(updated.getUserId());
        existing.setRegDate(updated.getRegDate());
        return regRepository.save(existing);
    }

    public Registrations patchRegistration(Long id, Registrations patch) {
        Registrations existing = regRepository.findById(id)
                .orElseThrow(() -> new RegistrationNotFoundException("Registration not found with ID: " + id));

        if (patch.getEventId() != null) {
            existing.setEventId(patch.getEventId());
        }
        if (patch.getUserId() != null) {
            existing.setUserId(patch.getUserId());
        }
        if (patch.getRegDate() != null) {
            existing.setRegDate(patch.getRegDate());
        }
        return regRepository.save(existing);
    }

    @Override
    public void deleteRegistration(Long id) {
        if (!regRepository.existsById(id)) {
            throw new RegistrationNotFoundException("Cannot delete. Registration not found with ID: " + id);
        }
        regRepository.deleteById(id);
    }
}
