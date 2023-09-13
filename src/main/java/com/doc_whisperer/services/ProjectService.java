package com.doc_whisperer.services;

import com.doc_whisperer.entities.Project;
import com.doc_whisperer.model.ClassInfo;
import com.doc_whisperer.repositories.ProjectRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectService {

    // Mock data
    private final List<Project> data = new ArrayList<>();
    @Autowired
    private ProjectRepository projectRepository;

    public ProjectService() {
        List<ClassInfo> classes = List.of(
                new ClassInfo("org.springframework.samples.petclinic.config.SwaggerConfig",
                        List.of("customOpenAPI()", "swaggerContact()", "swaggerLicense()")),

                new ClassInfo("org.springframework.samples.petclinic.application.model.for",
                        List.of("getId()", "setId()", "isNew()", "getName()", "setName()", "toString()")),

                new ClassInfo("org.springframework.samples.petclinic.application.model.Owner",
                        List.of("getAddress()", "setAddress()", "getCity()", "setCity()", "getTelephone()",
                                "setTelephone()", "setPetsInternal()", "setPets()", "addPet()", "getPet()",
                                "getPet()", "getPet()", "toString()")),
                // ... continue in the same pattern for each class and its methods
                new ClassInfo("org.springframework.samples.petclinic.util.mainly",
                        List.of("getById()")),
                new ClassInfo("org.springframework.samples.petclinic.application.model.Pet",
                        List.of("getBirthDate()", "setBirthDate()", "getType()", "setType()", "getOwner()",
                                "setOwner()", "setVisitsInternal()", "setVisits()", "addVisit()")),

                new ClassInfo("org.springframework.samples.petclinic.application.model.PetType", List.of()),

                new ClassInfo("org.springframework.samples.petclinic.application.model.Role",
                        List.of("getUser()", "setUser()", "getName()", "setName()")),
                new ClassInfo("org.springframework.samples.petclinic.application.model.Specialty", List.of()),

                new ClassInfo("org.springframework.samples.petclinic.application.model.User",
                        List.of("getUsername()", "setUsername()", "getPassword()", "setPassword()",
                                "getEnabled()", "setEnabled()", "setRoles()", "addRole()")),

                new ClassInfo("org.springframework.samples.petclinic.application.model.Vet",
                        List.of("setSpecialtiesInternal()", "setSpecialties()", "getNrOfSpecialties()",
                                "getSpecialtiesInternal()", "addSpecialty()", "clearSpecialties()")),

                new ClassInfo("org.springframework.samples.petclinic.application.model.Visit",
                        List.of("getDate()", "setDate()", "getDescription()", "setDescription()",
                                "getPet()", "setPet()")),

                new ClassInfo("org.springframework.samples.petclinic.PetClinicApplication",
                        List.of("main()")),

                new ClassInfo("org.springframework.samples.petclinic.repository.jdbc.JdbcOwnerRepositoryImpl",
                        List.of("findById()", "loadPetsAndVisits()", "save()", "loadOwnersPetsAndVisits()",
                                "delete()", "for()")),

                //... continue in a similar manner for each class

                new ClassInfo("org.springframework.samples.petclinic.util.mainly",
                        List.of("getById()"))
                // ... continue with other classes

        );
        Project project = new Project(1L, "Project1", convertToJson(classes));
        data.add(project);
    }

    public Optional<Project> getProjectById(Long projectId) {
        return projectRepository.findById(projectId);
    }

    public List<Project> getProjects() {
        return data;
    }

    private String convertToJson(List<ClassInfo> classInfos) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(classInfos);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting to JSON", e);
        }
    }
}
