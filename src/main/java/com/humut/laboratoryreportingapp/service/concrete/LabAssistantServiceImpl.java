package com.humut.laboratoryreportingapp.service.concrete;

import com.humut.laboratoryreportingapp.dto.request.LabAssistantRequestDto;
import com.humut.laboratoryreportingapp.dto.response.LabAssistantResponseDto;
import com.humut.laboratoryreportingapp.exception.AssistantNotFoundException;
import com.humut.laboratoryreportingapp.mapper.LabAssistantMapper;
import com.humut.laboratoryreportingapp.model.LabAssistant;
import com.humut.laboratoryreportingapp.repository.LabAssistantRepository;
import com.humut.laboratoryreportingapp.service.abstraction.LabAssistantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabAssistantServiceImpl implements LabAssistantService {
    LabAssistantRepository labAssistantRepository;

    public LabAssistantServiceImpl(LabAssistantRepository labAssistantRepository) {
        this.labAssistantRepository = labAssistantRepository;
    }

    @Override
    public List<LabAssistantResponseDto> findAllAssistants() {
        List<LabAssistant> labAssistant = labAssistantRepository.findAll();
        return labAssistant.stream().map(LabAssistantMapper.INSTANCE::entityToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public LabAssistantResponseDto addAssistant(LabAssistantRequestDto labAssistant) {
        LabAssistant saved = LabAssistantMapper.INSTANCE.requestDtoToEntity(labAssistant);
        labAssistantRepository.save(saved);
        return LabAssistantMapper.INSTANCE.entityToResponseDto(saved);
    }

    @Override
    public LabAssistantResponseDto getAssistant(Long id) {
        LabAssistant labAssistant = getAssistantById(id);
        return LabAssistantMapper.INSTANCE.entityToResponseDto(labAssistant);

    }

    @Override
    public void deleteAssistant(Long id) {
        labAssistantRepository.deleteById(id);
    }

    @Override
    public boolean existByHospitalId(String hospitalId) {
        return labAssistantRepository.existsByHospitalId(hospitalId);
    }

    @Override
    public LabAssistantResponseDto findAssistantWithHospitalId(String hospitalId) {
        LabAssistant labAssistant = labAssistantRepository.findByHospitalId(hospitalId).orElseThrow();
        return LabAssistantMapper.INSTANCE.entityToResponseDto(labAssistant);
    }

    protected LabAssistant getAssistantById(Long id) {
        return labAssistantRepository.findById(id)
                .orElseThrow();
    }

}
