package com.elildes.saude_backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elildes.saude_backend.models.Especialidade;
import com.elildes.saude_backend.models.Profissional;
import com.elildes.saude_backend.repositories.EspecialidadeRepository;
import com.elildes.saude_backend.repositories.ProfissionalRepository;

@Service
public class ProfissionalService {

    private ProfissionalRepository profissionalRepository;
    private EspecialidadeRepository especialidadeRepository;    

    public ProfissionalService(ProfissionalRepository profissionalRepository,
            EspecialidadeRepository especialidadeRepository) {
        this.profissionalRepository = profissionalRepository;
        this.especialidadeRepository = especialidadeRepository;
    }

    // salvar profissional
    public Profissional salvarProfissional(Profissional profissional) {
        List<Especialidade> especialidades = new ArrayList<>();

        for (Especialidade especialidade : profissional.getEspecialidades()) {
            Especialidade existingEspecialidade = especialidadeRepository.findByNome(especialidade.getNome());
            if (existingEspecialidade == null) {
                existingEspecialidade = especialidadeRepository.save(especialidade);
            }
            especialidades.add(existingEspecialidade);
        }
        
        profissional.setEspecialidades(especialidades);
        return profissionalRepository.save(profissional);
    }

    // buscar todos profissiionais
    public List<Profissional> buscarTodosProfissionais() {
        return profissionalRepository.findAll();
    }

    // buscar profissioanl por cpf
    public Optional<Profissional> buscarProfissionalPorCpf(String cpf) {
        return profissionalRepository.findByCpf(cpf);
    }

    // buscar profissioanl por id
    public Optional<Profissional> buscarProfissionalPorId(Long id) {
        return profissionalRepository.findById(id);
    }


}
