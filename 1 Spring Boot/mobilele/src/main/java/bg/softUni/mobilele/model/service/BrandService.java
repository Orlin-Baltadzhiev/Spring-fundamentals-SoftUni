package bg.softUni.mobilele.model.service;

import bg.softUni.mobilele.model.view.BrandViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    List<BrandViewModel> getAllBrands();
}
