package bg.softUni.mobilele;

import bg.softUni.mobilele.model.entities.*;
import bg.softUni.mobilele.model.entities.enums.EngineEnum;
import bg.softUni.mobilele.model.entities.enums.ModelCategoryEnum;
import bg.softUni.mobilele.model.entities.enums.TransmissionEnum;
import bg.softUni.mobilele.repository.BrandRepository;
import bg.softUni.mobilele.repository.ModelRepository;
import bg.softUni.mobilele.repository.OfferRepository;
import bg.softUni.mobilele.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;
    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public DBInit(ModelRepository modelRepository, BrandRepository brandRepository,
                  OfferRepository offerRepository,
                  PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    @Transactional
    @Override
    public void run(String... args) throws Exception {

        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");
        setCurrentTimestamps(fordBrand);

        BrandEntity hondaBrand = new BrandEntity();
        hondaBrand.setName("Honda");
        setCurrentTimestamps(hondaBrand);

        brandRepository.saveAll(List.of(fordBrand, hondaBrand));

        ModelEntity fiestaModel =  initFiesta(fordBrand);
        initEscort(fordBrand);
        intNX750S(hondaBrand);
        createFiestaOffer(fiestaModel);

        initAdmin();
    }
    private void initAdmin() {
        UserEntity admin = new UserEntity();
        admin.setFirstName("Petur");
        admin.setLastName("Dimitrov");
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("topsecret"));
        setCurrentTimestamps(admin);
        userRepository.save(admin);
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
        setCurrentTimestamps(fiestaOffer);
        offerRepository.save(fiestaOffer);
    }

    private ModelEntity intNX750S(BrandEntity hondaBrand){
        ModelEntity model750s = new ModelEntity();
        model750s.setName("NC750S");
        model750s.setCategory(ModelCategoryEnum.MOTORCYCLE);
        model750s.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/2012_Honda_NC700SA.jpg/300px-2012_Honda_NC700SA.jpg");
        model750s.setStartYear(2014);
        model750s.setBrand(hondaBrand);

        setCurrentTimestamps(model750s);

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

        setCurrentTimestamps(escort);

        return modelRepository.save(escort);
    }

    private   ModelEntity initFiesta(BrandEntity fordBrand){
        ModelEntity fiesta = new ModelEntity();
        fiesta.setName("Fiesta");
        fiesta.setCategory(ModelCategoryEnum.CAR);
        fiesta.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/280px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg");
        fiesta.setStartYear(1976);
        fiesta.setBrand(fordBrand);

        setCurrentTimestamps(fiesta);

        return modelRepository.save(fiesta);
    }

    private static void setCurrentTimestamps(BaseEntity baseEntity){

        baseEntity.setCreated(LocalDateTime.now());
        baseEntity.setUpdated(LocalDateTime.now());
    }


}
