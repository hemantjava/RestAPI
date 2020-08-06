package com.example.restapidevelopment.service;

import com.example.restapidevelopment.controller.EmpRepository;
import com.example.restapidevelopment.dto.EmpRequest;
import com.example.restapidevelopment.dto.EmpResponse;
import com.example.restapidevelopment.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public List<EmpResponse> getAll() {
        final List<EmpResponse> empResponses = new LinkedList<>();
        List<Emp> all = empRepository.findAll();
        if (!CollectionUtils.isEmpty(all)) {
            all.forEach(x -> {
                empResponses.add(EmpResponse.builder()
                        .emp(Emp.builder()
                                .id(x.getId())
                                .joiningDate(x.getJoiningDate())
                                .leavingDate(x.getLeavingDate())
                                .name(x.getName())
                                .build())
                        .build());
            });

        }

        return empResponses;
    }

    public EmpResponse save(Emp emp) {
        final Emp save = empRepository.save(emp);
        EmpResponse empResponse = EmpResponse.builder()
                .emp(save)
                .build();
        return empResponse;
    }

    //One way
    public EmpResponse update(EmpRequest emp) {
        Optional<Emp> byId = empRepository.findById(emp.getId());
        if (byId.isPresent()) {
            final Emp emp1 = byId.get();
            emp1.setName(emp.getName());
            final Emp save = empRepository.save(emp1);
            EmpResponse empResponse = EmpResponse.builder()
                    .emp(save)
                    .build();
            return empResponse;
        }
        return null;
    }

    @Transactional
    public EmpResponse updateData(EmpRequest emp) {
        Integer update = empRepository.update(emp.getId(), emp.getName(), LocalDateTime.now());
        if (update >= 1) {
            Optional<Emp> byId = empRepository.findById(emp.getId());
            if (byId.isPresent())
                return EmpResponse.builder().emp(byId.get()).build();
        }
        return null;
    }
}
