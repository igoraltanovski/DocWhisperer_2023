package com.doc_whisperer.services;

import com.doc_whisperer.model.ClassInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectService {

    // Mock data
    private final Map<String, List<ClassInfo>> data = new HashMap<>();

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
        data.put("pet-clinic", classes);
    }

    public List<ClassInfo> getClassesForProject(String projectName) {
        return data.getOrDefault(projectName, new ArrayList<>());
    }

    public List<String> getProjects() {
        List<String> projects = new ArrayList<>();
        projects.add("pet-clinic");
        // Add more projects here if needed.
        return projects;
    }
}
