package com.andreys.service.impl;

import com.andreys.model.entities.Item;
import com.andreys.model.service.ItemServiceModel;
import com.andreys.model.view.ItemViewModel;
import com.andreys.repository.ItemRepository;
import com.andreys.service.CategoryService;
import com.andreys.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ModelMapper modelMapper;
    private final ItemRepository itemRepository;
    private final CategoryService categoryService;

    public ItemServiceImpl(ModelMapper modelMapper, ItemRepository itemRepository, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
    }


    @Override
    public void addItem(ItemServiceModel itemServiceModel) {
        Item item = modelMapper.map(itemServiceModel, Item.class);
        item.setCategory(categoryService.findByName(itemServiceModel.getCategory().getCategoryName()));

        itemRepository.save(item);
    }

    @Override
    public List<ItemViewModel> findAllItems() {
        return this.itemRepository.findAll()
                .stream()
                .map(item -> {
                    ItemViewModel itemViewModel = modelMapper.map(item, ItemViewModel.class);

                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg",
                            item.getGender(),
                            item.getCategory().getCategoryName().name()));
                    return itemViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(String id) {
     return   itemRepository.findById(id)
               .map(item -> {
                   ItemViewModel itemViewModel = modelMapper.map(item, ItemViewModel.class);
                   itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg",
                           item.getGender(),
                           item.getCategory().getCategoryName().name()));

                   return itemViewModel;
               })
             .orElse(null);

    }

    @Override
    public void delete(String id) {
        itemRepository.deleteById(id);
    }


}
