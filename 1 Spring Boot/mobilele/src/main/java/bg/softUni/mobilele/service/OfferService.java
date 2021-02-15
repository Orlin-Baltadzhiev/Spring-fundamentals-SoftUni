package bg.softUni.mobilele.service;

import bg.softUni.mobilele.model.service.OfferServiceModel;
import bg.softUni.mobilele.model.view.OfferSummeryViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OfferService {

    List<OfferSummeryViewModel> getAllOffers();

    long save(OfferServiceModel model);

    void delete (long id);
}
