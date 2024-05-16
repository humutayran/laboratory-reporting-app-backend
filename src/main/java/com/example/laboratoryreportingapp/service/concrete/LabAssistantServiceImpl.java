package com.example.laboratoryreportingapp.service.concrete;

import com.example.laboratoryreportingapp.dto.request.LabAssistantRequestDto;
import com.example.laboratoryreportingapp.dto.response.LabAssistantResponseDto;
import com.example.laboratoryreportingapp.mapper.LabAssistantMapper;
import com.example.laboratoryreportingapp.model.LabAssistant;
import com.example.laboratoryreportingapp.repository.LabAssistantRepository;
import com.example.laboratoryreportingapp.service.abstraction.LabAssistantService;
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

    protected LabAssistant getAssistantById(Long id) {
        return labAssistantRepository.findById(id)
                .orElseThrow();
    }
}
