package com.example.market.persistence.mapper;

import com.example.market.domain.*;
import com.example.market.persistence.entity.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring") //Componenete tipo Spring
public interface CategoryMapper {
    //Convierte categoria en Category
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration //Mapeo inverso
    @Mapping(target = "productos", ignore = true)//ignora
    Categoria toCategoria(Category category);
}
