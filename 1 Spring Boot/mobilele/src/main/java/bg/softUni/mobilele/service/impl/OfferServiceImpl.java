package bg.softUni.mobilele.service.impl;

import bg.softUni.mobilele.model.entities.OfferEntity;
import bg.softUni.mobilele.model.service.OfferServiceModel;
import bg.softUni.mobilele.model.view.OfferSummeryViewModel;
import bg.softUni.mobilele.repository.ModelRepository;
import bg.softUni.mobilele.repository.OfferRepository;
import bg.softUni.mobilele.repository.UserRepository;
import bg.softUni.mobilele.security.CurrentUser;
import bg.softUni.mobilele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final CurrentUser currentUser;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository,
                            CurrentUser currentUser,
                            UserRepository userRepository,
                            ModelRepository modelRepository,
                            ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferSummeryViewModel> getAllOffers() {
        //TODO - implement maping;
        throw new UnsupportedOperationException("Cooming soon ...");
    }

    @Override
    public long save(OfferServiceModel model) {
        OfferEntity offerEntity = asNewEntity(model);
        OfferEntity newEntity = offerRepository.save(offerEntity);
        return newEntity.getId();
    }

    private OfferEntity asNewEntity(OfferServiceModel model) {
        OfferEntity offerEntity = new OfferEntity();
        modelMapper.map(model, offerEntity);
        offerEntity.setId(null);

        offerEntity.setModel(modelRepository.findById(model.getModelId()).orElseThrow());
        offerEntity.setUser(userRepository.findByUsername(currentUser.getName()).orElseThrow());
        return offerEntity;

    }
}
