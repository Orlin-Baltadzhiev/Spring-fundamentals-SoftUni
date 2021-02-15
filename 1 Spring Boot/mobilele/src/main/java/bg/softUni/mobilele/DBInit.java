package bg.softUni.mobilele;

import bg.softUni.mobilele.model.entities.*;
import bg.softUni.mobilele.model.entities.enums.EngineEnum;
import bg.softUni.mobilele.model.entities.enums.ModelCategoryEnum;
import bg.softUni.mobilele.model.entities.enums.TransmissionEnum;
import bg.softUni.mobilele.model.entities.enums.UserRoleEnum;
import bg.softUni.mobilele.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;
    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;


    public DBInit(ModelRepository modelRepository, BrandRepository brandRepository,
                  OfferRepository offerRepository,
                  PasswordEncoder passwordEncoder, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }
    @Transactional
    @Override
    public void run(String... args) throws Exception {

        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");

        BrandEntity hondaBrand = new BrandEntity();
        hondaBrand.setName("Honda");
        brandRepository.saveAll(List.of(fordBrand, hondaBrand));

        ModelEntity fiestaModel =  initFiesta(fordBrand);
        initEscort(fordBrand);
        intNX750S(hondaBrand);
        createFiestaOffer(fiestaModel);

        initUsers();

    }


    private void initUsers() {
        UserRoleEntity adminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
        UserRoleEntity userRole = new UserRoleEntity().setRole(UserRoleEnum.USER);

        userRoleRepository.saveAll(List.of(adminRole,userRole));

        UserEntity admin = new UserEntity();
        admin.setFirstName("Petur");
        admin.setLastName("Dimitrov");
        admin.setUsername("admin");
        admin.setUserRoles(List.of(adminRole,userRole));
        admin.setPassword(passwordEncoder.encode("topsecret"));

        userRepository.save(admin);

        UserEntity ani = new UserEntity();
        ani.setFirstName("Ani");
        ani.setLastName("Perlata");
        ani.setUsername("Anita");
        ani.setUserRoles(List.of(userRole));
        ani.setPassword(passwordEncoder.encode("topsecret"));

        userRepository.save(ani);
    }

    private void createFiestaOffer(ModelEntity modelEntity){
        OfferEntity fiestaOffer = new OfferEntity();
        fiestaOffer.setEngine(EngineEnum.GASOLINE);
        fiestaOffer.setImageUrl("https://media.autoexpress.co.uk/image/private/s--7btEt2wi--/v1562244788/autoexpress/2017/07/dsc_1328-1.jpg");
        fiestaOffer.setMileage(80000);
        fiestaOffer.setPrice(BigDecimal.valueOf(10000));
        fiestaOffer.setYear(2019);
        fiestaOffer.setDescription("Karana e ot nemska baba. Zimata v garaj");
        fiestaOffer.setTransmission(TransmissionEnum.MANUAL);
        fiestaOffer.setModel(modelEntity);

        offerRepository.save(fiestaOffer);
    }

    private ModelEntity intNX750S(BrandEntity hondaBrand){
        ModelEntity model750s = new ModelEntity();
        model750s.setName("NC750S");
        model750s.setCategory(ModelCategoryEnum.MOTORCYCLE);
        model750s.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/2012_Honda_NC700SA.jpg/300px-2012_Honda_NC700SA.jpg");
        model750s.setStartYear(2014);
        model750s.setBrand(hondaBrand);



        return modelRepository.save(model750s);
    }

    private   ModelEntity initEscort(BrandEntity fordBrand){
        ModelEntity escort = new ModelEntity();
        escort.setName("Escort");
        escort.setCategory(ModelCategoryEnum.CAR);
        escort.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/1996_Ford_Escort_RS_Cosworth_2.0_Front.jpg/1024px-1996_Ford_Escort_RS_Cosworth_2.0_Front.jpg");
        escort.setStartYear(1968);
        escort.setEndYear(2002);
        escort.setBrand(fordBrand);



        return modelRepository.save(escort);
    }

    private   ModelEntity initFiesta(BrandEntity fordBrand){
        ModelEntity fiesta = new ModelEntity();
        fiesta.setName("Fiesta");
        fiesta.setCategory(ModelCategoryEnum.CAR);
        fiesta.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/280px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg");
        fiesta.setStartYear(1976);
        fiesta.setBrand(fordBrand);



        return modelRepository.save(fiesta);
    }




}
