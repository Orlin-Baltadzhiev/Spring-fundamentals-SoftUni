package com.andreys.service;

import com.andreys.model.service.ItemServiceModel;
import com.andreys.model.view.ItemViewModel;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface ItemService {

    void addItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel> findAllItems();

    ItemViewModel findById(String id);

    void delete(String id);


}
