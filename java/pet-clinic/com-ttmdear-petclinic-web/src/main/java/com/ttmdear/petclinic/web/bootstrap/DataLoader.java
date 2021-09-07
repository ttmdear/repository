package com.ttmdear.petclinic.web.bootstrap;

import com.ttmdear.petclinic.data.model.*;
import com.ttmdear.petclinic.data.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(
            OwnerService ownerService,
            PetService petService,
            VetService vetService,
            PetTypeService petTypeService,
            SpecialityService specialityService
    ) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        // Prepare PetType
        PetType dogPetType = new PetType();
        dogPetType.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dogPetType);

        PetType catPetType = new PetType();
        catPetType.setName("Cat");

        PetType savedCatPetType = petTypeService.save(catPetType);

        // Speciality
        Speciality radiologySpeciality = new Speciality();
        radiologySpeciality.setDescription("radiology");

        Speciality savedRadiologySpeciality = specialityService.save(radiologySpeciality);

        Speciality surgerySpeciality = new Speciality();
        surgerySpeciality.setDescription("surgery");

        Speciality savedSurgerySpeciality = specialityService.save(surgerySpeciality);

        Speciality dentistrySpeciality = new Speciality();
        dentistrySpeciality.setDescription("dentistry");

        Speciality savedDentistrySpeciality = specialityService.save(dentistrySpeciality);

        Owner owner1 = new Owner();

        owner1.setFirstName("Paweł");
        owner1.setLastName("Kowalski");
        owner1.setAddress("Warszawska 10");
        owner1.setCity("Gdańsk");
        owner1.setTelephone("987-098-890");

        Pet mikesPet = new Pet();
        mikesPet.setName("Mike");
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());

        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Justyna");
        owner2.setLastName("Wrona");
        owner2.setAddress("Piłata 20");
        owner2.setCity("Słupsk");
        owner2.setTelephone("231-234-231");

        Pet fionaPet = new Pet();
        fionaPet.setName("Fiona");
        fionaPet.setPetType(savedCatPetType);
        fionaPet.setOwner(owner2);
        fionaPet.setBirthDate(LocalDate.now());

        owner2.getPets().add(fionaPet);

        ownerService.save(owner2);

        System.out.println("Owner's loaded ...");

        Vet vet1 = new Vet();

        vet1.setFirstName("Paweł");
        vet1.setLastName("Kowalski");
        vet1.getSpecialities().add(savedDentistrySpeciality);

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Justyna");
        vet2.setLastName("Wrona");
        vet1.getSpecialities().add(savedSurgerySpeciality);

        vetService.save(vet2);

        System.out.println("Vet's loaded ...");
    }
}
